package oop.ex6.main;

/**
 *
 */
public class FuncDeclerationInFuncException extends JavacException {

    /*  */
    private static final String PRINT_MESSAGE = "Javac encountered function deceleration inside a function "
            + "scope";

    /**
     *
     */
    public FuncDeclerationInFuncException() {
        System.err.println(FuncDeclerationInFuncException.PRINT_MESSAGE);
    }
}
