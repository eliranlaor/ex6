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
    public static final String REGEX_1 = " *(final )? *(int|double|boolean|String|char) +" +
            "(_\\w+|[a-zA-Z]\\w*);";
    public static final String REGEX_2 =
            " *(int|double|boolean|String|char) +(_\\w+|[a-zA-Z]\\w*) *= *([^\\n\\r]*) *; *";
    public static final String REGEX_3 = " +(_\\w+|[a-zA-Z]\\w*) *= *([^\\n\\r]*) *; *";
    public static final String END_SCOPE = " *} *";
    public static final String RETURN = " *return *; *";
    public static final String FUNCTION_DECLARATION = "6";
    public static final String IF_WHILE_DECLARATION = "6";

    public static final String[] REGEXES = {REGEX_1, REGEX_2, REGEX_3, END_SCOPE, RETURN, FUNCTION_DECLARATION};

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
                matcher = patterns[i].matcher(line);
                String[] lineInfoArgs = new String[matcher.groupCount()];
                for (int j = 1; j <= matcher.groupCount(); j++) {
                    lineInfoArgs[j] = matcher.group(j);
                }
                return new LineInfo(REGEXES[i], lineInfoArgs);
            }
        }
        throw new SyntaxException();
    }

}
