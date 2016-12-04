package com.javaweb.model.entity;


public class ElementAdder {
    private Addable addable;
    public void setWhereToAdd(Addable addable){
        this.addable = addable;
    }

    public void add(LexicalElement element){
        addable.add(element);
    }
}
