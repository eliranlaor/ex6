package oop.ex6.main;

import oop.ex6.main.sjavaVars.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileParser {
    private Reader inFile;
    private BufferedReader buffer;
    private MatcherWrapper matcherWrapper;
    private String fileToParse;
    private VarFactory varFactory;

    public FileParser(String sJavacFileName) throws IOException{
        fileToParse = sJavacFileName;
        resetFileBuffer();
        matcherWrapper = new MatcherWrapper();
        varFactory = new VarFactory();
    }


    private void resetFileBuffer(){
        try {
            inFile = new FileReader(fileToParse);
            buffer = new BufferedReader(inFile);
        }
        catch (IOException e){
            //TODO
        }
    }
    public void parse(){
        GlobalScope global = firstParse();
        resetFileBuffer();
        secondParse(global);
    }



    private GlobalScope firstParse(){
        try{
            GlobalScope globalScope = new GlobalScope();
            LineInfo currentLineInfo;
            String currentLine = buffer.readLine();
            while(currentLine != null) {
                currentLineInfo = matcherWrapper.match(currentLine);
                updateGlobalScope(globalScope, currentLineInfo); //TODO
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

    private void updateGlobalScope(GlobalScope global, LineInfo currentLineInfo) throws SyntaxException{ //TODO

        //if we encounter if/while blocks - we need to throw an exception

        //when encountering function declaration, we need to update line buffer to the end of that function.
        String[] args = currentLineInfo.getArgs();
        boolean isFinal = false;
        boolean isInitialized;
        Var newVar;
        String varType;
        switch(currentLineInfo.getType()){
            case MatcherWrapper.REGEX_1:
                //variable declaration
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
                    if(global.containsInScope(tempString[0]) != null){
                        //TODO throw exception - trying to initial an already existing var
                    }
                    if(tempString.length > 1){ //declaring and initialing var
                        newVar = varFactory.creatVar(true, varType, isFinal, tempString[0],
                                tempString[1]);
                    }
                    else{
                        newVar = varFactory.creatVar(false, varType, isFinal, args[i], null);
                    }
                    global.addVar(newVar);
                }
                break;
            case MatcherWrapper.REGEX_2:
                //variable initialization
                Var var = global.containsRecorsive(args[0]);
                if(var == null){
                    //TODO - need to throw an exception
                }
                if(var.isFinal() && var.isInitialized()){
                    //TODO - need to throw an exception
                }
                String value = args[1].trim();
                Var secondVar = global.containsRecorsive(value);
                if(secondVar != null){
                    if(secondVar.isInitialized()) {
                        if(!var.areTypesMatch(var.getVarType(), secondVar.getVarType())){
                            throw new SyntaxException();
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
                break;
            case Regexes.EMPTY_LINE_COMMENT:
                //need to ignore :)
                break;
            case Regexes.FUNCTION_DECELERATION:
                global.addFunctionDeclaration(currentLineInfo);
                break;
            default:
                throw new SyntaxException();
        }
    }

    private void findEndOfFunction() throws SyntaxException{
        try {
            String currentLine = buffer.readLine();
            LineInfo currentLineInfo;
            while(currentLine != null){
                currentLineInfo = matcherWrapper.match(currentLine);
                if(currentLineInfo.getType() == MatcherWrapper.END_SCOPE){
                    return;
                }
                if(currentLineInfo.getType() == MatcherWrapper.IF_WHILE_DECLARATION){
                    findEndOfFunction();
                }
                if(currentLineInfo.getType() == MatcherWrapper.FUNCTION_DECLARATION){
                    throw new SyntaxException();//TODO new exception-same as the one we need to add in 5 lines
                }
            }
            //if we got here - there was an illegal functionality
            throw new SyntaxException();//TODO new exception
        }
        catch(IOException e){
            //TODO
        }
        catch (SyntaxException e){

        }
    }

    private void secondParse(Scope currentScope){
        try {
            String currentLine = buffer.readLine();
            LineInfo currentLineInfo;
            while(currentLine != null) {
                currentLineInfo = matcherWrapper.match(currentLine);
                if (currentLineInfo.getType() == MatcherWrapper.FUNCTION_DECLARATION) {
                    Scope newScope = new InternalScope(currentScope);
                    parseScope(newScope);
                }
                currentLine = buffer.readLine();
            }
        }
        catch (IOException e){
            //TODO
        }
        catch (SyntaxException e){
            //TODO
        }
    }


    private void parseScope(Scope currentScope){
        try {
            String currentLine = buffer.readLine();
            LineInfo currentLineInfo;
            while(currentLine != null){
                currentLineInfo = matcherWrapper.match(currentLine);
                if(currentLineInfo.getType() == MatcherWrapper.END_SCOPE){
                    return;
                }
                updateInternalScope(currentLineInfo);


                currentLine = buffer.readLine();
            }
        }
        catch(IOException e){
            //TODO
        }
        catch(SyntaxException e){
            //TODO
        }
    }

    private void updateInternalScope(LineInfo currentLineInfo) { //TODO

        switch(currentLineInfo.getType()){
            case MatcherWrapper.REGEX_1:
                break;
            case MatcherWrapper.REGEX_2:
                break;
            case MatcherWrapper.REGEX_3:
                break;
        }
    }



}



