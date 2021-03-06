package oop.ex6.main;

import oop.ex6.main.sjavaVars.Var;

import java.util.ArrayList;

public class GlobalScope extends Scope{

    private ArrayList<FunctionSignature> functionsSignature;

    public GlobalScope(){
        this.parentScope = null;
        functionsSignature = new ArrayList<>();
        this.vars = new ArrayList<>();
    }

    public void addFunctionDeclaration(LineInfo funcDeclaration) throws JavacException{
        FunctionSignature func = new FunctionSignature(funcDeclaration);
        functionsSignature.add(func);
    }

    @Override
    public Var containsRecorsive(String name) {
        return super.containsInScope(name);
    }

    public FunctionSignature getFunction(String name){
        for(FunctionSignature f : functionsSignature){
            if(f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }

}
