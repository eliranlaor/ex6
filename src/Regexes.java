public class Regexes {

    public static final String INT = "int", DOUBLE = "double", STRING = "String", FINAL = "final ",
            BOOLEAN="boolean", CHAR="char", COMMA=",", EQUAL="=", SPACE = "\\s+", RETURN = "return",
            SEMICOLON = ";" , VOID = "void" , OPEN_ROUND_BRACKET = "/(" , CLOSE_ROUND_BRACKET = "/)",
            IF = "if", WHILE = "while", OPEN_CURLY_BRACKETS = "{", TRUE = "true", FALSE = "false";

    public static final String SPACES = SPACE + "*";
    public static final String SPACES_PLUS = SPACE + "+";

    public static final String VAR_TYPE =
            "(" + INT + "|" + DOUBLE + "|" + STRING + "|" + BOOLEAN + "|" + CHAR + ")";

    public static final String VAR_NAME = "_\\w+|[a-zA-Z]\\w*";
    public static final String VAR_VALUE = "([^\\n\\r]*)";
    public static final String VAR_NAME_EQUAL = VAR_NAME + "(" + SPACES + EQUAL + SPACES + VAR_VALUE + ")?";
    public static final String VAR_NAME_COMMA = VAR_NAME_EQUAL + SPACES + COMMA + SPACES;
    public static final String VAR_NAME_COMMAS = "(" + VAR_NAME_COMMA + "*" + VAR_NAME_EQUAL + ")";


    public static final String FUNCTION_NAME = "([a-zA-Z]\\w*)";
    public static final String FUNCTION_ARG = "(" + VAR_TYPE + SPACES_PLUS + VAR_NAME + ")";
    public static final String FUNCTION_ARGS =
            "(" + FUNCTION_ARG + "?|" + "(" + FUNCTION_ARG + SPACES + COMMA + SPACES + ")*" + FUNCTION_ARG +
                    ")";

    public static final String VAR_COMMAS =
            "(" + VAR_NAME + ")?|" + "(" + VAR_NAME + SPACES + COMMA + SPACES + ")*" + VAR_NAME + ")";

    public static final String DOUBLE_REGEX = "-?\\d+([.]\\d+)?";
    public static final String CONDITION = "(" + TRUE + "|" + FALSE + "|" + DOUBLE_REGEX + ")";





    final static String VAR_DECLERATION =
            SPACES + "(" + FINAL + ")?" + SPACES + VAR_TYPE + SPACES_PLUS + VAR_NAME_COMMAS + SPACES +
                    SEMICOLON + SPACES;

    final static String RETURN_REGEX = SPACES + RETURN + SPACES + SEMICOLON + SPACES;

    final static String COMMENT = "//[^\\n\\r]*";

    final static String EMPTY_LINE = SPACES;

    final static String CLOSING_CURLY_BRACKETS = SPACES + "}" + SPACES;

    final static String FUNCTION_DECLERATION =
            SPACES + VOID + SPACES_PLUS + FUNCTION_NAME + SPACES + OPEN_ROUND_BRACKET + SPACES +
                    FUNCTION_ARGS + SPACES + CLOSE_ROUND_BRACKET + SPACES + OPEN_CURLY_BRACKETS + SPACES;

    final static String FUNCTION_CALL =
            SPACES + FUNCTION_NAME + SPACES + OPEN_ROUND_BRACKET + SPACES + VAR_COMMAS + SPACES +
                    OPEN_ROUND_BRACKET + SEMICOLON + SPACES;

    final static String IF_WHILE =
            SPACES + "(" + IF + "|" + WHILE + ")" + CONDITION + SPACES + OPEN_CURLY_BRACKETS + SPACES;

}
