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
    /*object parameters - end*/

    public Var(boolean isInitialized, int varType, boolean isFinal){
        this.isInitialized = isInitialized;
        this.varType = varType;
        this.isFinal = isFinal;
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
