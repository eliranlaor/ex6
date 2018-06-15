package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBitches {

    public static void main(String[] args){

        String javaTypes = "int|double|boolean|String|char";
        String varName = "_\\w+|[a-zA-Z]\\w*";
        String argument = "(int|double|boolean|String|char) +(_\\w+|[a-zA-Z]\\w*)";
        Pattern pattern = Pattern.compile(" *(final )? *(int|double|boolean|String|char) +" +
                "(_\\w+|[a-zA-Z]\\w*) *; *");
        Matcher matcher = pattern.matcher("final int a;");
        System.out.println(matcher.matches());
        for(int i = 1; i <= matcher.groupCount(); i++){
            System.out.println(matcher.group(i));
        }
    }

}
