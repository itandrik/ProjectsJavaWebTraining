package com.javaweb.model.entity;


import java.util.List;

public class Text implements LexicalElement{
    private Composite sentences;

    public Text() {
        this.sentences = new Composite();
    }

    @Override
    public void add(LexicalElement element) {
        sentences.add(element);
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        return sentences.getListOfElements();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Programming book : \n");
        getListOfElements().forEach(
                (elem) -> result.append(elem.toString())
        );
        return result.toString();
    }
}
