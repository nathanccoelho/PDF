package com.generation.json.model;

import java.util.List;

public class AppendixesList {
    private List<Appendixes> appendixes;

    private List<Clauses> clauses;

    public List<Clauses> getClauses() {
        return clauses;
    }

    public void setClauses(List<Clauses> clauses) {
        this.clauses = clauses;
    }

    public List<Appendixes> getAppendixes(){
        return appendixes;
    }

    public void setAppendixes(List<Appendixes> appendixes){
        this.appendixes = appendixes;
    }
}
