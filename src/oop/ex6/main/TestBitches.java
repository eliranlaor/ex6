package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBitches {

    public static void main(String[] args){

        GlobalScope a = new GlobalScope();
        InternalScope b = new InternalScope(a);
        GlobalScope c = new GlobalScope();
        System.out.println(b.getClass().isInstance(a));
    }

}
