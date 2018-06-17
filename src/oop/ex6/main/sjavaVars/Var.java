package oop.ex6.main.sjavaVars;

import oop.ex6.main.SyntaxException;

public abstract class Var{

    /*magic numbers*/
    static final int INT_INDEX = 0;
    static final int DOUBLE_INDEX = 1;
    static final int BOOLEAN_INDEX = 2;
    static final int STRING_INDEX = 3;
    static final int CHAR_INDEX = 4;
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

    public void setValue(String value) throws SyntaxException{}

    /**
     *
     * @param firstType
     * @param secondType
     * @return
     */
    public boolean areTypesMatch(int firstType, int secondType){
        switch (firstType){
            case DOUBLE_INDEX:
                return (secondType==INT_INDEX || secondType==DOUBLE_INDEX);
            case BOOLEAN_INDEX:
                return (secondType==INT_INDEX || secondType==DOUBLE_INDEX || secondType==BOOLEAN_INDEX);
            default:
                return (firstType==secondType);
        }
    }

}
