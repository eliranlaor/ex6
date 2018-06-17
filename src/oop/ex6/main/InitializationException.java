package oop.ex6.main;

/**
 *
 */
public class InitializationException extends Exception {

    /*  */
    private static final String PRINT_MESSAGE = "Code encountered an initialization Error.";

    /**
     *
     */
    public InitializationException() {
        System.err.println(InitializationException.PRINT_MESSAGE);
    }
}
