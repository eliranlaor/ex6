package oop.ex6.main;

import java.util.ArrayList;
import oop.ex6.main.sjavaVars.Var;

public class FunctionSignature {

    private String name;
    private ArrayList<Var> vars;

    public FunctionSignature(LineInfo lineInfo){
        setAll(lineInfo);
    }

    private void setAll(LineInfo lineInfo){
        String[] args = lineInfo.getArgs();
        this.name = args[0];
        String[] varNames = args[1].split(",");
        for(int i = 0; i < varNames.length; i++){
            String[] tempString = varNames[i].split(" *");
        }
    }

    public void setVars(ArrayList<Var> vars) {
        this.vars = vars;
    }
}
