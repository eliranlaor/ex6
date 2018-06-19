package oop.ex6.main;

import oop.ex6.main.sjavaVars.Var;

import java.util.ArrayList;

public class InternalScope extends Scope{

    public InternalScope(Scope parentScope){
        this.parentScope = parentScope;
        this.vars = new ArrayList<>();
    }

    public Var containsRecorsive(String name){
        return containsHelper(this, name);
    }

    private Var containsHelper(Scope scope, String searchVal){
        if(scope.getParentScope() == null){ //if this is the global
            return scope.containsInScope(searchVal);
        }
        for (Var v : getVars()){
            if(v.getVarName().equals(searchVal)){
                return v;
            }
        }
        return containsHelper(scope.getParentScope(), searchVal);
    }

}
