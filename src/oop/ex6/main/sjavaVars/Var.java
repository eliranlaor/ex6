package oop.ex6.main.sjavaVars;

import oop.ex6.main.SyntaxException;

/**
 * represents a var in a Javac code
 */
public abstract class Var{


    /*magic numbers represents types of vars*/
    public static final int INT_INDEX = 0;
    public static final int DOUBLE_INDEX = 1;
    public static final int BOOLEAN_INDEX = 2;
    public static final int STRING_INDEX = 3;
    public static final int CHAR_INDEX = 4;
    /*magic numbers - end*/

    /*object parameters*/
    protected boolean isInitialized;
    protected int varType;
    protected boolean isFinal;
    protected String varName;
    /*object parameters - end*/

    /**
     * creates a Var object initialised with it's characteristics: such as TODO
     */
    public Var(){
        //TODO - put constructor of all the classes in here
    }

    /**
     *
     * @return
     */
    public String getVarName() {
        return varName;
    }

    /**
     *
     * @return
     */
    public boolean isFinal() {
        return isFinal;
    }

    /***
     *
     * @return
     */
    public int getVarType() {
        return varType;
    }

    /**
     *
     * @return
     */
    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     *
     */
    public void setInitialized() {
        isInitialized = true;
    }

    /**
     *
     * @param value
     * @throws SyntaxException
     */
    public void setValue(String value) throws SyntaxException{}

    /**
     *
     * @param firstType
     * @param secondType
     * @return
     */
    public boolean areTypesMatch(int firstType, int secondType){
        switch (firstType){
            case DOUBLE_INDEX: // double can get also int
                return (secondType==INT_INDEX || secondType==DOUBLE_INDEX);
            case BOOLEAN_INDEX: // boolean can get double and int
                return (secondType==INT_INDEX || secondType==DOUBLE_INDEX || secondType==BOOLEAN_INDEX);
            default: // the rest can get only themselves
                return (firstType==secondType);
        }
    }

}
