package oop.ex6.main;

import oop.ex6.main.sjavaVars.Var;

public class InternalScope extends Scope{

    public InternalScope(Scope parentScope){
        this.parentScope = parentScope;
    }//TODO

    public Var containsVar(String name){
        return containsHelper(this, name);
    }

    private Var containsHelper(Scope scope, String searchVal){
        if(scope.getParentScope() == null){ //if this is the global
            return scope.containsVar(searchVal);
        }
        for (Var v : getVars()){
            if(v.getVarName().equals(searchVal)){
                return v;
            }
        }
        return containsHelper(scope.getParentScope(), searchVal);
    }

}
