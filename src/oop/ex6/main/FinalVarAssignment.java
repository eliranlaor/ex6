package oop.ex6.main;

/**
 *
 */
public class FinalVarAssignment extends JavacException {

    /*  */
    private static final String PRINT_MESSAGE = "Javac encountered attempt to assign a final var with a " +
            "value";

    /**
     *
     */
    public FinalVarAssignment() {
        System.err.println(FinalVarAssignment.PRINT_MESSAGE);
    }
}
