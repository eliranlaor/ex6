package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBitches {

    public static void main(String[] args){
        String a = "   String     b, int a, double h ";
        String[] varNames = a.split(",");
        for(int i = 0; i < varNames.length; i++){
            String b = varNames[i].trim();
            b = b.replaceAll("( )+", " ");
            String[] tempString = b.split(" ");
            for(int j = 0; j < tempString.length; j++){
                System.out.println(tempString[j]);
            }
        }
    }

}
