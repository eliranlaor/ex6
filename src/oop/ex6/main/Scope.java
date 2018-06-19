package oop.ex6.main;

import oop.ex6.main.sjavaVars.Var;

import java.util.ArrayList;

/**
 *
 */
public abstract class Scope {

    protected Scope parentScope;
    protected ArrayList<Var> vars;

    /**
     *
     */
    public Scope(){}

    /**
     *
     * @return
     */
    public Scope getParentScope() {
        return parentScope;
    }

    /**
     *
     * @return
     */
    public ArrayList<Var> getVars() {
        return vars;
    }

    /**
     *
     * @param var
     */
    public void addVar(Var var) {
        this.vars.add(var);
    }

    /**
     *
     * @param vars
     */
    public void addVar(ArrayList<Var> vars){
        for (Var var:vars) {
            addVar(var);
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public Var containsInScope(String name){
        for (Var v : getVars()){
            if(v.getVarName().equals(name)){
                return v;
            }
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    public Var containsRecorsive(String name){return null;}

}
