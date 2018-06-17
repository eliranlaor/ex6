package oop.ex6.main;

public class IntVar {

    private int value;
    private String name;

    public IntVar(String value, String name) throws InitializationException{
        try {
            this.value = Integer.parseInt(value);
            this.name = name;
        }
        catch (Exception e) {
            throw new InitializationException();
        }
    }
}
