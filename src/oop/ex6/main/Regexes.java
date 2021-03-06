package oop.ex6.main;

/**
 * class that holds all the regexes that are required to parse a Javac code
 */
public class Regexes {

    private static final String INT = "int", DOUBLE = "double", STRING = "String", FINAL = "final ",
            BOOLEAN="boolean", CHAR="char", COMMA=",", EQUAL="=", SPACE = "\\s", RETURN = "return",
            SEMICOLON = ";" , VOID = "void" , OPEN_ROUND_BRACKET = "\\(" , CLOSE_ROUND_BRACKET = "\\)",
            IF = "if", WHILE = "while", OPEN_CURLY_BRACKETS = "\\{", AND = "\\&\\&", OR = "\\|\\|";

    private static final String SPACES = SPACE + "*";
    private static final String SPACES_PLUS = SPACE + "+";

    private static final String VAR_TYPE =
            "(" + INT + "|" + DOUBLE + "|" + STRING + "|" + BOOLEAN + "|" + CHAR + ")";
    private static final String VAR_NAME = "_\\w+|[a-zA-Z]\\w*";
    private static final String VAR_VALUE = "([^\\n\\r]*)";
    private static final String VAR_NAME_EQUAL = VAR_NAME + "(" + SPACES + EQUAL + SPACES + VAR_VALUE + ")?";
    private static final String VAR_NAME_COMMA = "(" + VAR_NAME_EQUAL + SPACES + COMMA + SPACES + ")";
    private static final String VAR_NAME_COMMAS = "(" + VAR_NAME_COMMA + "*" + VAR_NAME_EQUAL + ")";
    private final static String VAR_NAME_VALUE = "(" + VAR_NAME + "|[^\\n\\r]*)";
    private static final String VAR_COMMAS =
            "(" + VAR_NAME_VALUE + "?|" + "(" + VAR_NAME_VALUE + SPACES + COMMA + SPACES + ")*"
                    + VAR_NAME_VALUE + ")";
    private static final String FUNCTION_NAME = "([a-zA-Z]\\w*)";
    private static final String FUNCTION_ARG = "(" + "(" + FINAL + ")?" + VAR_TYPE + SPACES_PLUS + VAR_NAME
            + ")";
    private static final String FUNCTION_ARGS =
            "(" + FUNCTION_ARG + "?|" + "(" + FUNCTION_ARG + SPACES + COMMA + SPACES + ")*" + FUNCTION_ARG +
                    ")";
    private final static String COMMENT = "//[^\\n\\r]*";


    /* Regexes for Vars Checks */
    public static final String TRUE = "true", FALSE = "false";
    public static final String DOUBLE_REGEX = "-?\\d+([.]\\d+)?";
    public static final String INT_REGEX = "-?\\d+";
    public static final String CHAR_REGEX = "\'.\'";
    public static final String STRING_REGEX = "\"" + VAR_VALUE + "\"";
    /* Regexes for Vars Checks - end*/


    private static final String SINGLE_CONDITION =
            "(" + TRUE + "|" + FALSE + "|" + DOUBLE_REGEX + "|" + VAR_NAME + ")";
    public static final String AND_OR = "(" + AND + "|" + OR + ")";
    private static final String CONDITION =
            "(" + SINGLE_CONDITION + "?|" + "(" + SINGLE_CONDITION + SPACES + AND_OR + SPACES + ")*" +
                    SINGLE_CONDITION + ")";

    /* Regexes for MatcherWrapper */

    public final static String VAR_DECELERATION =
            SPACES + "(" + FINAL + ")?" + SPACES + VAR_TYPE + SPACES_PLUS + VAR_NAME_COMMAS + SPACES +
                    SEMICOLON + SPACES;

    public final static String ASSIGNMENT =
            SPACES + "(" + VAR_NAME + ")" + SPACES + EQUAL + SPACES + VAR_NAME_VALUE + SPACES + SEMICOLON
                    + SPACES;

    public final static String RETURN_REGEX = SPACES + RETURN + SPACES + SEMICOLON + SPACES;

    public final static String EMPTY_LINE_COMMENT = "(" + SPACES + "|" + COMMENT + ")";

    public final static String CLOSING_CURLY_BRACKETS = SPACES + "\\}" + SPACES;

    public final static String FUNCTION_DECELERATION =
            SPACES + VOID + SPACES_PLUS + FUNCTION_NAME + SPACES + OPEN_ROUND_BRACKET + SPACES +
                    FUNCTION_ARGS + SPACES + CLOSE_ROUND_BRACKET + SPACES + OPEN_CURLY_BRACKETS + SPACES;

    public final static String FUNCTION_CALL =
            SPACES + FUNCTION_NAME + SPACES + OPEN_ROUND_BRACKET + SPACES + VAR_COMMAS + SPACES +
                    CLOSE_ROUND_BRACKET + SEMICOLON + SPACES;

    public final static String IF_WHILE =
            SPACES + "(" + IF + "|" + WHILE + ")" + SPACES + OPEN_ROUND_BRACKET + SPACES + CONDITION +
                    SPACES + CLOSE_ROUND_BRACKET + SPACES + OPEN_CURLY_BRACKETS + SPACES;

    public final static String[] REGEXES = {VAR_DECELERATION, ASSIGNMENT, RETURN_REGEX,
            EMPTY_LINE_COMMENT, CLOSING_CURLY_BRACKETS, FUNCTION_DECELERATION, FUNCTION_CALL, IF_WHILE};

    /* Regexes for MatcherWrapper - end */

}
