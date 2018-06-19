package oop.ex6.main;

/**
 *
 */
public class NoReturnInEndOfFuncException extends JavacException {

    /*  */
    private static final String PRINT_MESSAGE = "Javac encountered end of function with not return " +
            "statement in the end of it";

    /**
     *
     */
    public NoReturnInEndOfFuncException() {
        System.err.println(NoReturnInEndOfFuncException.PRINT_MESSAGE);
    }
}

