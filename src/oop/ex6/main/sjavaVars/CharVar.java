package oop.ex6.main.sjavaVars;

public class CharVar extends Var{

    private String value;

    public CharVar(boolean isInitialized, boolean isFinal, String name, String value){
        this.value = value;
        this.isInitialized = isInitialized;
        this.varType = varType;
        this.isFinal = isFinal;
        this.varName = name;
        if(!isInitialized){return;}
        this.value = value; //TODO check value validity
    }
}