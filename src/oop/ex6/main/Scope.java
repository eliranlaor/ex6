package oop.ex6.main;

import java.util.ArrayList;

public class Scope {
    public static String[] types = new String[]{"function", "global", "if&while"};
    private Scope parentScope;
    private ArrayList<Var> vars;
    private String scopeType;

    public Scope(Scope parent, String type){

    }

    public Scope getParentScope() {
        return parentScope;
    }

    public String getScopeType() {
        return scopeType;
    }

    public ArrayList<Var> getVars() {
        return vars;
    }

    public void addVar(Var var) {
        this.vars.add(var);
    }
}
