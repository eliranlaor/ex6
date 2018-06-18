package oop.ex6.main;

import java.io.IOException;

public class Sjavac {

    private String filePathToParse;


    public Sjavac(String filePath){
        filePathToParse = filePath;
    }

    private int runCheck(){
        try {
            FileParser fileParser = new FileParser(filePathToParse);
            fileParser.parse();
        }
        catch(IOException e){
            return 0;
        }
        return 1; //TODO - tentative
    }


    public static void main(String[] args){
        Sjavac checker = new Sjavac(args[0]);
        checker.runCheck();
    }

}
