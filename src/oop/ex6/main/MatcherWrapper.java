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
    public static final String REGEX_1 = "";
    public static final String REGEX_2 = "";
    public static final String REGEX_3 = "";
    public static final String REGEX_4 = "";
    public static final String REGEX_5 = "";
    public static final String REGEX_6 = "";

    public static final String[] REGEXES = {REGEX_1, REGEX_2, REGEX_3, REGEX_4, REGEX_5, REGEX_6};

    /**
     *
     */
    public MatcherWrapper(){
        patterns = new Pattern[REGEXES.length];
        for (int i = 0; i < REGEXES.length; i++) {
            patterns[i] = Pattern.compile(REGEXES[i]);
        }
    }

    /**
     *
     * @param line
     * @return
     * @throws SyntaxException
     */
    public LineInfo match(String line) throws SyntaxException{
        for (int i = 0; i < REGEXES.length; i++) {
            if (patterns[i].matcher(line).matches()){
                String[] lineInfoArgs = new String[matcher.groupCount()];
                for (int j = 0; j < matcher.groupCount(); j++) {
                    lineInfoArgs[i] = matcher.group(i);
                }
                return new LineInfo(REGEXES[i], lineInfoArgs);
            }
        }
        throw new SyntaxException();
    }

}
