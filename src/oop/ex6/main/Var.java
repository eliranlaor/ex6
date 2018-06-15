package oop.ex6.main;

public class Var{

    /*magic numbers*/
    private final int INT_INDEX = 0;
    private final int DOUBLE_INDEX = 1;
    private final int BOOLEAN_INDEX = 2;
    /*magic numbers - end*/

    /*object parameters*/
    private boolean isInitialized;
    private int varType;
    private boolean isFinal;
    private String varName;
    /*object parameters - end*/

    public Var(boolean isInitialized, int varType, boolean isFinal, String name){
        this.isInitialized = isInitialized;
        this.varType = varType;
        this.isFinal = isFinal;
        this.varName = name;
    }

    public String getVarName() {
        return varName;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public int getVarType() {
        return varType;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized() {
        isInitialized = true;
    }

}
