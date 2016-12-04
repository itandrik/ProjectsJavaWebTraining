package com.javaweb.model.entity;

import java.util.LinkedList;
import java.util.List;


public class Composite implements LexicalElement{
    private List<LexicalElement> elements;

    public Composite() {
        this.elements = new LinkedList<>();
    }

    @Override
    public void add(LexicalElement element) {
        elements.add(element);
    }

}
