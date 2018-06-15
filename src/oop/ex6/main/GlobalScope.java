package oop.ex6.main;

import java.util.ArrayList;

public class GlobalScope extends Scope{

    ArrayList<LineInfo> functionsSignature;

    public GlobalScope(){

    }

    public Var containsVar(String name){
        for (Var v : getVars()){
            if(v.getVarName().equals(name)){
                return v;
            }
        }
        return null;
    }


}
