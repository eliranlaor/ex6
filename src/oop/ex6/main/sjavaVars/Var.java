package oop.ex6.main.sjavaVars;

import oop.ex6.main.SyntaxException;

/**
 * represents a var in a Javac code
 */
public abstract class Var{


    /*magic numbers represents types of vars*/
    public static final String INT_INDEX = "INT_INDEX";
    public static final String DOUBLE_INDEX = "DOUBLE_INDEX";
    public static final String BOOLEAN_INDEX = "BOOLEAN_INDEX";
    public static final String STRING_INDEX = "STRING_INDEX";
    public static final String CHAR_INDEX = "CHAR_INDEX";
    /*magic numbers - end*/

    /*object parameters*/
    protected boolean isInitialized;
    protected String varType;
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
    public String getVarType() {
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
    public boolean areTypesMatch(String firstType, String secondType){
        switch (firstType){
            case DOUBLE_INDEX: // double can get also int
                return (secondType.equals(INT_INDEX) || secondType.equals(DOUBLE_INDEX));
            case BOOLEAN_INDEX: // boolean can get double and int
                return (secondType.equals(INT_INDEX) || secondType.equals(DOUBLE_INDEX) ||
                        secondType.equals(BOOLEAN_INDEX));
            default: // the rest can get only themselves
                return (firstType==secondType);
        }
    }

}
