package oop.ex6.main.sjavaVars;

import oop.ex6.main.Regexes;
import oop.ex6.main.SyntaxException;
import java.util.regex.Pattern;

/**
 * represents a Var of type String
 */
public class StringVar extends Var{

    private String value;
    private final static String EMPTY_STRING = "";
    private final static String APOSTROPHES = "\"";



    public StringVar(boolean isInitialized, boolean isFinal, String name, String value) throws
            SyntaxException{
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
    public void setValue(String value) throws SyntaxException{
        Pattern pattern = Pattern.compile(Regexes.STRING_REGEX);
        if (!pattern.matcher(value).matches()){
            throw new SyntaxException();
        }
        this.value = value.replace(APOSTROPHES,EMPTY_STRING);
        this.isInitialized = true;
    }

    /**
     *
     * @return
     */
    public int getVarType(){
        return Var.STRING_INDEX;
    }
}
