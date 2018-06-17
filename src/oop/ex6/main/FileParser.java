package oop.ex6.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileParser {
    private Reader inFile;
    private BufferedReader buffer;
    private MatcherWrapper matcherWrapper;


    public FileParser(String sJavacFileName) throws IOException{
        try {
            inFile = new FileReader(sJavacFileName);
            buffer = new BufferedReader(inFile);
            matcherWrapper = new MatcherWrapper();
        }
        catch(IOException e){
            //TODO check if we need to print err message
            throw e;
        }
    }

    public void parse(){
        GlobalScope global = firstParse();
        //TODO reset reader
        secondParse(global);
    }



    private GlobalScope firstParse(){
        try{
            LineInfo currentLineInfo;
            String currentLine = buffer.readLine();
            while(currentLine != null) {
                currentLineInfo = matcherWrapper.match(currentLine);
                updateGlobalScope(currentLineInfo); //TODO
                currentLine = buffer.readLine();
            }
        }
        catch(IOException e){ //TODO complete this functionality

        }
        catch(SyntaxException e){

        }




        return null;
    }

    private void updateGlobalScope(LineInfo currentLineInfo) { //TODO

        //if we encounter if/while blocks - we need to throw an exception

        //when encountering function declaration, we need to update line buffer to the end of that function.
        switch(currentLineInfo.getType()){
            case MatcherWrapper.REGEX_1:
                break;
            case MatcherWrapper.REGEX_2:
                break;
            case MatcherWrapper.REGEX_3:
                break;
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



