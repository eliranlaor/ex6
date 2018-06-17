package oop.ex6.main.sjavaVars;

import oop.ex6.main.Regexes;
import oop.ex6.main.SyntaxException;

import java.util.regex.Pattern;

/**
 *
 */
public class BooleanVar extends Var{


    private boolean value;
    private String name;


    /**
     *
     * @param isInitialized
     * @param isFinal
     * @param name
     * @param value
     * @throws SyntaxException
     */
    public BooleanVar(boolean isInitialized, boolean isFinal, String name, String value)
            throws SyntaxException {
        this.isInitialized = isInitialized;
        this.isFinal = isFinal;
        this.name = name;
        if(!isInitialized){return;}
        // don't care for value in case it comes from function deceleration (value is not known).
        if (value != null){
            setValue(value);
        }    }

    @Override
    public void setValue(String value) throws SyntaxException {
        Pattern pattern = Pattern.compile(Regexes.DOUBLE_REGEX);
        if (!(pattern.matcher(value).matches() || (value.equals(Regexes.FALSE) ||
                value.equals(Regexes.TRUE)))) {
            throw new SyntaxException();
        }
        this.value = (pattern.matcher(value).matches()) ?
                (Integer.parseInt(pattern.matcher(value).group()) != 0) :
                (value.equals(Regexes.TRUE)) ? true : false;
        this.isInitialized = true;
    }

    /**
     *
     * @return
     */
    public int getVarType() {
        return Var.BOOLEAN_INDEX;
    }

}
