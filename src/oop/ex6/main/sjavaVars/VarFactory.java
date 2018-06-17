package oop.ex6.main.sjavaVars;

import oop.ex6.main.InitializationException;

public class VarFactory {
    public VarFactory(){
    }

    public Var creatVar(boolean isInitialized, String varType, boolean isFinal, String name, String value){
        try {
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
        catch(InitializationException e){
            return null;
            //TODO - handle exception
        }
    }
}
