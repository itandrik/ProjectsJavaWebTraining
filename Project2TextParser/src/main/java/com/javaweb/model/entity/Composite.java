package com.javaweb.model.entity;

import java.util.LinkedList;
import java.util.List;


public class Composite implements LexicalElement{
    private List<LexicalElement> elements;

    public Composite() {
        this.elements = new LinkedList<>();
    }

    /*public void swapWith(List<LexicalElement> elements){
        List<LexicalElement> temp = new LinkedList<>(this.elements);

        this.elements.clear();
        for (LexicalElement element:elements) {
            this.elements.add(element);
        }

        elements.clear();
        for (LexicalElement element:temp) {
            elements.add(element);
        }
    }*/

    @Override
    public void add(LexicalElement element) {
        elements.add(element);
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        return elements;
    }
}
