package oop.ex6.main;

import oop.ex6.main.sjavaVars.Var;

import java.util.ArrayList;

public abstract class Scope {
    protected Scope parentScope;
    private ArrayList<Var> vars;


    public Scope(){} //TODO


    public Scope getParentScope() {
        return parentScope;
    }


    public ArrayList<Var> getVars() {
        return vars;
    }

    public void addVar(Var var) {
        this.vars.add(var);
    }

    public Var containsVar(String name){return null;}

}
