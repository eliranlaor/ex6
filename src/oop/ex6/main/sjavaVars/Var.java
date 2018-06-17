package oop.ex6.main.sjavaVars;

public abstract class Var{

    /*magic numbers*/
    private final int INT_INDEX = 0;
    private final int DOUBLE_INDEX = 1;
    private final int BOOLEAN_INDEX = 2;
    private final int STRING_INDEX = 2;
    private final int CHAR_INDEX = 2;
    /*magic numbers - end*/

    /*object parameters*/
    protected boolean isInitialized;
    protected int varType;
    protected boolean isFinal;
    protected String varName;
    /*object parameters - end*/

    public Var(){
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
