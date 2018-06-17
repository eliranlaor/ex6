package oop.ex6.main.sjavaVars;

import oop.ex6.main.InitializationException;

import java.util.regex.Pattern;

public class DoubleVar {

    private double value;
    private String name;
    private String INT_REGEX = "";

    public DoubleVar(String value, String name) throws InitializationException {
        try {
            Pattern pattern = Pattern.compile(INT_REGEX);
            if (pattern.matcher(value).matches()) {
                this.value = Integer.parseInt(value);
            }
            else{
                this.value = Double.parseDouble(value);
            }
            this.name = name;
        }
        catch (Exception e) {
            throw new InitializationException();
        }
    }
}

