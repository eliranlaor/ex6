package oop.ex6.main;

import java.util.regex.Pattern;

public class test {


    public static void main(String[] args){
        Pattern p = Pattern.compile("{");
        if (p.matcher("{").matches()){
            System.out.println("eliran is the king");
        }
        else
            System.out.println("eliran is not the king");

    }

}
