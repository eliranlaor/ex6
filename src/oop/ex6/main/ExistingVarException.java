package oop.ex6.main;

/**
 *
 */
public class ExistingVarException extends JavacException {

    /*  */
    private static final String PRINT_MESSAGE = "Javac encountered attempt to define an already existing " +
            "var.";

    /**
     *
     */
    public ExistingVarException() {
        System.err.println(ExistingVarException.PRINT_MESSAGE);
    }
}
