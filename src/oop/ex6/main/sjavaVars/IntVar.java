package oop.ex6.main.sjavaVars;

import oop.ex6.main.InitializationException;

public class IntVar extends Var{

    private int value;
    private String name;

    public IntVar(boolean isInitialized, boolean isFinal, String name, String value) throws
            InitializationException {
        try {
            this.isInitialized = isInitialized;
            this.varType = varType;
            this.isFinal = isFinal;
            this.varName = name;
            if(!isInitialized){return;}
            this.value = Integer.parseInt(value);
        }
        catch (Exception e) {
            throw new InitializationException();
        }
    }
}
