package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooleanVar {


]    private Matcher matcher;

    private boolean value;
    private String name;

    private static final String NUMBER_REGEX = "";


    public BooleanVar(String value, String name) throws InitializationException{
        try {
            Pattern pattern = Pattern.compile(NUMBER_REGEX);
            if (!pattern.matcher(value).matches()){
                throw new InitializationException();
            }
            this.value = (Integer.parseInt(pattern.matcher(value).group()) != 0 || value.equals("true"));
            this.name = name;
        }
        catch (Exception e) {
            throw new InitializationException();
        }
    }
}
