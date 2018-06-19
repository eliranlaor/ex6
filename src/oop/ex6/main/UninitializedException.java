package oop.ex6.main;

/**
 *
 */
public class UninitializedException extends JavacException {

    /*  */
    private static final String PRINT_MESSAGE = "Javac encountered attempt to use an uninitialized var.";

    /**
     *
     */
    public UninitializedException() {
        System.err.println(UninitializedException.PRINT_MESSAGE);
    }
}