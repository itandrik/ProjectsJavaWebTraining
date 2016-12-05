package com.javaweb.model.entity;


import java.util.List;

public class Sentence implements LexicalElement{
    private Composite words;

    public Sentence() {
        this.words = new Composite();
    }

    @Override
    public void add(LexicalElement word) {
        words.add(word);
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        return words.getListOfElements();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\t|Sentence : \n");
        getListOfElements().forEach(
                (elem) -> result.append(elem.toString())
        );
        return result.toString();
    }
}
