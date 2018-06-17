package oop.ex6.main.sjavaVars;

import oop.ex6.main.InitializationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class BooleanVar extends Var{


    private boolean value;
    private String name;

    private static final String DOUBLE_REGEX = "";
    private static final String TRUE = "true";
    private static final String FALSE = "false";


    public BooleanVar(boolean isInitialized, boolean isFinal, String name, String value)
            throws InitializationException {
        try {
            this.isInitialized = isInitialized;
            this.isFinal = isFinal;
            this.name = name;
            if(!isInitialized){return;}
            Pattern pattern = Pattern.compile(DOUBLE_REGEX);
            if (!(pattern.matcher(value).matches() || (value.equals(FALSE) || value.equals(TRUE)))){
                throw new InitializationException();
            }
            this.value = (pattern.matcher(value).matches()) ?
                    (Integer.parseInt(pattern.matcher(value).group()) != 0) :
                    (value.equals(TRUE)) ? true : false;
        }
        catch (Exception e) {
            throw new InitializationException();
        }
    }
}
