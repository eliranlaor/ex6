package oop.ex6.main.sjavaVars;

import oop.ex6.main.Regexes;
import oop.ex6.main.SyntaxException;

import java.util.regex.Pattern;

/**
 * represents a Var of type Char
 */
public class CharVar extends Var{

    /* */
    private char value;

    /**
     *
     * @param isInitialized
     * @param isFinal
     * @param name
     * @param value
     * @throws SyntaxException
     */
    public CharVar(boolean isInitialized, boolean isFinal, String name, String value) throws
            SyntaxException{
        this.isInitialized = isInitialized;
        this.isFinal = isFinal;
        this.varName = name;
        if(!isInitialized){return;}
        // don't care for value in case it comes from function deceleration (value is not known).
        if (value != null){
            setValue(value);
        }    }

    @Override
    public void setValue(String value) throws SyntaxException{
        Pattern pattern = Pattern.compile(Regexes.CHAR_REGEX);
        if (!pattern.matcher(value).matches()){
            throw new SyntaxException();
        }
        this.value = value.charAt(1);
        this.isInitialized = true;
    }

    /**
     *
     * @return
     */
    public int getVarType(){
        return Var.CHAR_INDEX;
    }
}