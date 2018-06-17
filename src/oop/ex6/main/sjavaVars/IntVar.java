package oop.ex6.main.sjavaVars;

import oop.ex6.main.SyntaxException;

public class IntVar extends Var{

    private int value;
    private String name;

    /**
     *
     * @param isInitialized
     * @param isFinal
     * @param name
     * @param value
     * @throws SyntaxException
     */
    public IntVar(boolean isInitialized, boolean isFinal, String name, String value) throws
            SyntaxException {
        this.isInitialized = isInitialized;
        this.isFinal = isFinal;
        this.varName = name;
        if(!isInitialized){return;}
        // don't care for value in case it comes from function deceleration (value is not known).
        if (value != null){
            setValue(value);
        }

    }

    @Override
    public void setValue(String value) throws SyntaxException {
        try {
            this.value = Integer.parseInt(value);
        }
        catch (Exception e) {
            throw new SyntaxException();
        }
        this.isInitialized = true;
    }

    /**
     *
     * @return
     */
    public int getVarType() {
        return Var.INT_INDEX;
    }
}
