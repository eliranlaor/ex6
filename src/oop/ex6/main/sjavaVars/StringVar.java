package oop.ex6.main.sjavaVars;

public class StringVar extends Var{

    private String value;

    public StringVar(boolean isInitialized, boolean isFinal, String name, String value){
        this.isInitialized = isInitialized;
        this.isFinal = isFinal;
        this.varName = name;
        if(!isInitialized){return;}
        this.value = value;
        //TODO - check value validity
    }


}
