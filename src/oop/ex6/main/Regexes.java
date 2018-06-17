package oop.ex6.main;

public class Regexes {

    private static final String INT = "int", DOUBLE = "double", STRING = "String", FINAL = "final ",
            BOOLEAN="boolean", CHAR="char", COMMA=",", EQUAL="=", SPACE = "\\s+", RETURN = "return",
            SEMICOLON = ";" , VOID = "void" , OPEN_ROUND_BRACKET = "/(" , CLOSE_ROUND_BRACKET = "/)",
            IF = "if", WHILE = "while", OPEN_CURLY_BRACKETS = "{";

    public static final String TRUE = "true", FALSE = "false";

    private static final String SPACES = SPACE + "*";
    private static final String SPACES_PLUS = SPACE + "+";

    private static final String VAR_TYPE =
            "(" + INT + "|" + DOUBLE + "|" + STRING + "|" + BOOLEAN + "|" + CHAR + ")";

    private static final String VAR_NAME = "_\\w+|[a-zA-Z]\\w*";
    private static final String VAR_VALUE = "([^\\n\\r]*)";
    private static final String VAR_NAME_EQUAL = VAR_NAME + "(" + SPACES + EQUAL + SPACES + VAR_VALUE + ")?";
    private static final String VAR_NAME_COMMA = VAR_NAME_EQUAL + SPACES + COMMA + SPACES;
    private static final String VAR_NAME_COMMAS = "(" + VAR_NAME_COMMA + "*" + VAR_NAME_EQUAL + ")";


    private static final String FUNCTION_NAME = "([a-zA-Z]\\w*)";
    private static final String FUNCTION_ARG = "(" + VAR_TYPE + SPACES_PLUS + VAR_NAME + ")";
    private static final String FUNCTION_ARGS =
            "(" + FUNCTION_ARG + "?|" + "(" + FUNCTION_ARG + SPACES + COMMA + SPACES + ")*" + FUNCTION_ARG +
                    ")";

    private static final String VAR_COMMAS =
            "(" + VAR_NAME + ")?|" + "(" + VAR_NAME + SPACES + COMMA + SPACES + ")*" + VAR_NAME + ")";

    public static final String DOUBLE_REGEX = "-?\\d+([.]\\d+)?";
    private static final String CONDITION = "(" + TRUE + "|" + FALSE + "|" + DOUBLE_REGEX + ")";

    public static final String INT_REGEX = "-?\\d+";
    public static final String CHAR_REGEX = "\'.\'";
    public static final String STRING_REGEX = "\"" + VAR_VALUE + "\"";

    private final static String COMMENT = "//[^\\n\\r]*";




    public final static String VAR_DECLERATION =
            SPACES + "(" + FINAL + ")?" + SPACES + VAR_TYPE + SPACES_PLUS + VAR_NAME_COMMAS + SPACES +
                    SEMICOLON + SPACES;

    public final static String RETURN_REGEX = SPACES + RETURN + SPACES + SEMICOLON + SPACES;

    public final static String EMPTY_LINE_COMMENT = "(" + SPACES + "|" + COMMENT + ")";

    public final static String CLOSING_CURLY_BRACKETS = SPACES + "}" + SPACES;

    public final static String FUNCTION_DECLERATION =
            SPACES + VOID + SPACES_PLUS + FUNCTION_NAME + SPACES + OPEN_ROUND_BRACKET + SPACES +
                    FUNCTION_ARGS + SPACES + CLOSE_ROUND_BRACKET + SPACES + OPEN_CURLY_BRACKETS + SPACES;

    public final static String FUNCTION_CALL =
            SPACES + FUNCTION_NAME + SPACES + OPEN_ROUND_BRACKET + SPACES + VAR_COMMAS + SPACES +
                    OPEN_ROUND_BRACKET + SEMICOLON + SPACES;

    public final static String IF_WHILE =
            SPACES + "(" + IF + "|" + WHILE + ")" + CONDITION + SPACES + OPEN_CURLY_BRACKETS + SPACES;

    //TODO - assignment regex
}
