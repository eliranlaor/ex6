package oop.ex6.main;

import oop.ex6.main.sjavaVars.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class FileParser {
    private Reader inFile;
    private BufferedReader buffer;
    private MatcherWrapper matcherWrapper;
    private String fileToParse;
    private VarFactory varFactory;
    private GlobalScope globalScope;
    private boolean returnFlag;

    public FileParser(String sJavacFileName) throws IOException{
        fileToParse = sJavacFileName;
        resetFileBuffer();
        matcherWrapper = new MatcherWrapper();
        varFactory = new VarFactory();
        returnFlag = false;
    }


    private void resetFileBuffer() throws IOException{
        inFile = new FileReader(fileToParse);
        buffer = new BufferedReader(inFile);
    }

    public void parse() throws IOException, SyntaxException{
        globalScope = firstParse();
        resetFileBuffer();
        secondParse(globalScope);
    }

    private GlobalScope firstParse() throws IOException{
        try{
            GlobalScope globalScope = new GlobalScope();
            LineInfo currentLineInfo;
            String currentLine = buffer.readLine();
            while(currentLine != null) {
                currentLineInfo = matcherWrapper.match(currentLine);
                updateGlobalScope(globalScope, currentLineInfo);
                currentLine = buffer.readLine();
            }
            return globalScope;
        }
        catch(IOException e){ //TODO complete this functionality
            return null;
        }
        catch(SyntaxException e){
            return null;
        }
    }



    private void assigment(LineInfo lineInfo, Scope scope) throws SyntaxException{
        String[] args = lineInfo.getArgs();
        Var var = scope.containsRecorsive(args[0]);
        if(var == null){
            //TODO - need to throw an exception
        }
        if(var.isFinal() && var.isInitialized()){
            //TODO - need to throw an exception
        }
        String value = args[1].trim();
        Var secondVar = scope.containsRecorsive(value);
        if(secondVar != null){
            if(secondVar.isInitialized()) {
                if(!var.areTypesMatch(var.getVarType(), secondVar.getVarType())){
                    //TODO - throw exception
                }
                var.setInitialized();
            }
            else{
                //TODO - need to throw an exception - usage of uninitialized variable
            }
        }
        else{
            //second var isn't a variable
            var.setValue(value); // check validity of value
        }
    }


    private void varDeclaration(LineInfo lineInfo, Scope scope) throws SyntaxException{
        String[] args = lineInfo.getArgs();
        boolean isFinal = false;
        Var newVar;
        String varType;
        int index = 0;
        if(args[index] == "final"){
            isFinal = true;
            index++;
        }
        varType = args[index];
        index++;
        String[] varNames = args[index].replaceAll(" ", "").split(",");
        //varName will contain "NAME=VALUE" or "NAME"
        for(int i = 0; i < varNames.length; i++){
            String[] tempString = varNames[i].split("=");
            if(scope.containsInScope(tempString[0]) != null){
                //TODO throw exception - trying to initial an already existing var
            }
            if(tempString.length > 1){ //declaring and initialing var
                newVar = varFactory.creatVar(true, varType, isFinal, tempString[0],
                        tempString[1]);
            }
            else{
                newVar = varFactory.creatVar(false, varType, isFinal, args[i], null);
            }
            scope.addVar(newVar);
        }
    }


    private void updateGlobalScope(GlobalScope global, LineInfo currentLineInfo) throws IOException,
            SyntaxException{
        //TODO

        //if we encounter if/while blocks - we need to throw an exception

        //when encountering function declaration, we need to update line buffer to the end of that function.
        switch(currentLineInfo.getType()){
            case Regexes.VAR_DECELERATION:
                //variable declaration
                varDeclaration(currentLineInfo, global);
               break;
            case Regexes.ASSIGNMENT:
                //variable initialization
                assigment(currentLineInfo, globalScope);
                break;
            case Regexes.EMPTY_LINE_COMMENT:
                //need to ignore :)
                break;
            case Regexes.FUNCTION_DECELERATION:
                global.addFunctionDeclaration(currentLineInfo);
                findEndOfFunction();
                break;
            default:
                throw new SyntaxException();
        }
    }

    private void findEndOfFunction() throws IOException, SyntaxException{
        String currentLine = buffer.readLine();
        LineInfo currentLineInfo;
        while(currentLine != null){
            currentLineInfo = matcherWrapper.match(currentLine);
            if(currentLineInfo.getType() == Regexes.CLOSING_CURLY_BRACKETS){
                return;
            }
            if(currentLineInfo.getType() == Regexes.IF_WHILE){
                findEndOfFunction();
            }
            if(currentLineInfo.getType() == Regexes.FUNCTION_DECELERATION){
                throw new SyntaxException();//TODO new exception-same as the one we need to add in 5 lines
            }
        }
        //if we got here - there was an illegal functionality
        throw new SyntaxException();//TODO new exception
    }

    private void secondParse(Scope currentScope)throws IOException, SyntaxException{
        String currentLine = buffer.readLine();
        LineInfo currentLineInfo;
        while(currentLine != null) {
            currentLineInfo = matcherWrapper.match(currentLine);
            if (currentLineInfo.getType() == Regexes.FUNCTION_DECELERATION) {
                Scope newScope = new InternalScope(currentScope);
                String funcName = currentLineInfo.getArgs()[0];
                FunctionSignature currentFunction = globalScope.getFunction(funcName);
                newScope.addVar(currentFunction.getVars());
                parseScope(newScope);
            }
            currentLine = buffer.readLine();
        }
    }


    private void parseScope(Scope currentScope) throws IOException, SyntaxException{
        String currentLine = buffer.readLine();
        LineInfo currentLineInfo;
        while(currentLine != null){
            currentLineInfo = matcherWrapper.match(currentLine);
            if(currentLineInfo.getType() == Regexes.CLOSING_CURLY_BRACKETS){
                return;
            }
            updateInternalScope(currentLineInfo, currentScope);
            currentLine = buffer.readLine();
        }
    }

    private void updateInternalScope(LineInfo currentLineInfo, Scope curScope) throws IOException {
        try {
            returnFlag = false;
            switch (currentLineInfo.getType()) {
                case Regexes.IF_WHILE:
                    if (checkBooleanCondition(currentLineInfo, curScope)) {
                        InternalScope newScope = new InternalScope(curScope);
                        parseScope(newScope);
                    } else {
                        throw new SyntaxException();
                    }
                    break;
                case Regexes.FUNCTION_CALL:
                    if (!checkFunctionCall(currentLineInfo, curScope)) {
                        throw new SyntaxException();
                    }
                    break;
                case Regexes.EMPTY_LINE_COMMENT:
                    break;
                case Regexes.RETURN_REGEX:
                    returnFlag = true;
                    break;
                case Regexes.ASSIGNMENT:
                    assigment(currentLineInfo, curScope);
                    break;
                case Regexes.VAR_DECELERATION:
                    varDeclaration(currentLineInfo, curScope);
                    break;
            }
        }
        catch(SyntaxException e){
            //TODO - handle exception
        }
    }

    private boolean checkBooleanCondition(LineInfo lineInfo, Scope curScope){
        String condition = lineInfo.getArgs()[1].trim();
        Var newVar = curScope.containsRecorsive(condition);
        if(newVar != null && (newVar.getVarType().equals(Var.BOOLEAN_INDEX) ||
                newVar.getVarType().equals(Var.DOUBLE_INDEX) ||
                newVar.getVarType().equals(Var.INT_INDEX))){
            return true;
        }
        return false;
    }

    private boolean checkFunctionCall(LineInfo lineInfo, Scope curScope)throws SyntaxException{
        String[] functionCallArgs = lineInfo.getArgs();
        String funcName = functionCallArgs[0].trim();
        FunctionSignature func = globalScope.getFunction(funcName);
        if(func != null){
            ArrayList<Var> originalArgs = func.getVars();
            String[] paramsNames = functionCallArgs[1].replaceAll(" ", "").split(",");
            if(originalArgs.size() != paramsNames.length){
                return false;
            }
            Var origVar;
            Var argVar;
            for(int i = 0; i < originalArgs.size(); i++){
                origVar = originalArgs.get(i);
                argVar = curScope.containsRecorsive(paramsNames[i]);
                if(argVar != null){ //if user send a variable
                    if(!origVar.areTypesMatch(origVar.getVarType(), argVar.getVarType())){
                        return false;
                    }
                }
                else{//if user send a value
                    varFactory.creatVar
                            (true, origVar.getVarType(), false, "tmp", paramsNames[i]);
                }
            }
        }
        return false;
    }
}



