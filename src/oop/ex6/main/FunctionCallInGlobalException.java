package oop.ex6.main;

/**
 *
 */
public class FunctionCallInGlobalException extends JavacException {

    /*  */
    private static final String PRINT_MESSAGE = "Javac encountered attempt to call a function in the " +
            "global scope";

    /**
     *
     */
    public FunctionCallInGlobalException() {
        System.err.println(FunctionCallInGlobalException.PRINT_MESSAGE);
    }
}
