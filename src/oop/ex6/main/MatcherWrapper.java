package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class MatcherWrapper {

    /* patterns for all the regexes */
    private Pattern[] patterns;

    /* a matcher for the regexes */
    private Matcher matcher;


    /**
     * compiles all the regexes to the patterns
     */
    public MatcherWrapper(){
        patterns = new Pattern[Regexes.REGEXES.length];
        for (int i = 0; i < Regexes.REGEXES.length; i++) {
            patterns[i] = Pattern.compile(Regexes.REGEXES[i]);
        }
    }

    /**
     * matches a line of javac with regexes of valid lines.
     * @param line - a string represents a line in Javac
     * @return a LineInfo object which have the information of a valid Javac line
     * @throws SyntaxException
     */
    public LineInfo match(String line) throws SyntaxException{
        for (int i = 0; i < Regexes.REGEXES.length; i++) {
            if (patterns[i].matcher(line).matches()){
                matcher = patterns[i].matcher(line);
                matcher.matches(); //class requirement
                String[] lineInfoArgs = new String[matcher.groupCount()];
                for (int j = 1; j <= matcher.groupCount(); j++) {
                    lineInfoArgs[j-1] = matcher.group(j);
                }
                return new LineInfo(Regexes.REGEXES[i], lineInfoArgs);
            }
        }
        throw new SyntaxException();
    }

}
