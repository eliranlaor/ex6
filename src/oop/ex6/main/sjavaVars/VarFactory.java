package oop.ex6.main.sjavaVars;

import oop.ex6.main.SyntaxException;

/**
 * factory for vars. creates var object by
 */
public class VarFactory {
    public VarFactory(){
    }

    public Var creatVar(boolean isInitialized, String varType, boolean isFinal, String name, String value)
    throws SyntaxException{
        switch (varType) {
            case "String":
                return new StringVar(isInitialized, isFinal, name, value);
            case "double":
                return new DoubleVar(isInitialized, isFinal, name, value);
            case "int":
                return new IntVar(isInitialized, isFinal, name, value);
            case "boolean":
                return new BooleanVar(isInitialized, isFinal, name, value);
            case "char":
                return new CharVar(isInitialized, isFinal, name, value);
        }
        return null;
    }
}
