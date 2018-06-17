package oop.ex6.main.sjavaVars;

import oop.ex6.main.InitializationException;

import java.util.regex.Pattern;

public class DoubleVar extends Var{

    private double value;
    private String INT_REGEX = "";

    public DoubleVar(boolean isInitialized, boolean isFinal, String name, String value)
            throws InitializationException {
        try {
            this.isInitialized = isInitialized;
            this.varType = varType;
            this.isFinal = isFinal;
            this.varName = name;
            if(!isInitialized){return;}
            Pattern pattern = Pattern.compile(INT_REGEX);
            if (pattern.matcher(value).matches()) {
                this.value = Integer.parseInt(value);
            }
            else{
                this.value = Double.parseDouble(value);
            }
        }
        catch (Exception e) {
            throw new InitializationException();
        }
    }
}

