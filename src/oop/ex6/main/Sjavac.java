package oop.ex6.main;

import java.io.IOException;

public class Sjavac {

    private String filePathToParse;


    public Sjavac(String filePath){
        filePathToParse = filePath;
    }

    private void runCheck(){
        try {
            FileParser fileParser = new FileParser(filePathToParse);
            fileParser.parse();
            System.out.println(0);
        }
        catch(IOException e){
            System.out.println(2);
        }
        catch(JavacException e){
            System.out.println(1);
        }
    }


    public static void main(String[] args){
        Sjavac checker = new Sjavac(args[0]);
        checker.runCheck();
    }

}
