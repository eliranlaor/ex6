package oop.ex6.main;

/**
 *
 */
public class SyntaxException extends Exception {

    /*  */
    private static final String PRINT_MESSAGE = "Code encountered a syntax Error.";

    /**
     *
     */
    public SyntaxException() {
        System.err.println(SyntaxException.PRINT_MESSAGE);
    }
}
