package oop.ex6.main;

public class LineInfo {

    private String type;

    private String[] args;

    public LineInfo(String type, String[] args){
        this.type = type;
        this.args = args;
    }

    public String getType() {
        return type;
    }

    public String[] getArgs() {
        return args;
    }
}
