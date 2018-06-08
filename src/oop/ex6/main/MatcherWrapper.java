package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class MatcherWrapper {

    /*  */
    private Pattern[] patterns;

    /*  */
    private Matcher matcher;

    /*  */
    public static final int VAR_DECLERATION1 = 0;
    public static final int VAR_DECLERATION2 = 0;
    public static final int VAR_DECLERATION3 = 0;
    public static final int VAR_DECLERATION4 = 0;
    public static final int VAR_DECLERATION5 = 0;
    public static final int VAR_DECLERATION6 = 0;


    public MatcherWrapper(){
        patterns = Patterncreator.createPatterns();
    }

    private void createPatterns(){

    }

    public LineInfo match(String line){

    }

}
