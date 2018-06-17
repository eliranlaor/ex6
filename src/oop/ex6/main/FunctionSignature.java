package oop.ex6.main;

import java.util.ArrayList;
import oop.ex6.main.sjavaVars.Var;
import oop.ex6.main.sjavaVars.VarFactory;

public class FunctionSignature {

    private String name;
    private ArrayList<Var> vars;
    private VarFactory varFactory;


    public FunctionSignature(LineInfo lineInfo){
        setAll(lineInfo);
        this.vars = new ArrayList<>();
        varFactory = new VarFactory();
    }

    private void setAll(LineInfo lineInfo){
        String[] args = lineInfo.getArgs();
        this.name = args[0];
        String[] varNames = args[1].split(",");
        boolean isFinal = false;
        String varType;
        String varName;
        Var newVar;
        for(int i = 0; i < varNames.length; i++){
            String b = varNames[i].trim();
            b = b.replaceAll("( )+", " ");
            String[] tempString = b.split(" ");
            int index = 0;
            if(tempString[index] == "final"){
                isFinal = true;
                index++;
            }
            varType = tempString[index];
            index++;
            varName = tempString[index];
            newVar = varFactory.creatVar(true, varType, isFinal, varName, null);
            vars.add(newVar);
        }
    }
}
