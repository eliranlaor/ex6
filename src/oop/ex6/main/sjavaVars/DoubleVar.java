package oop.ex6.main.sjavaVars;

import oop.ex6.main.Regexes;
import oop.ex6.main.SyntaxException;

import java.util.regex.Pattern;

public class DoubleVar extends Var{

    private double value;

    public DoubleVar(boolean isInitialized, boolean isFinal, String name, String value)
            throws SyntaxException {
        this.isInitialized = isInitialized;
        this.isFinal = isFinal;
        this.varName = name;
        if(!isInitialized){return;}
        setValue(value);
    }


    public void setValue(String value) throws SyntaxException{
        try{
            Pattern pattern = Pattern.compile(Regexes.INT_REGEX);
            if (pattern.matcher(value).matches()) {
                this.value = Integer.parseInt(value);
            }
            else{
                this.value = Double.parseDouble(value);
            }
            this.isInitialized = true;
        }
        catch (Exception e){
            throw new SyntaxException();
        }

    }

    /**
     *
     * @return
     */
    public int getVarType(){
        return Var.DOUBLE_INDEX;
    }
}

