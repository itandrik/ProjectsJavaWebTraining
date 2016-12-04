package com.javaweb.model.entity;


public class Text implements LexicalElement{
    private Composite sentences;

    public Text() {
        this.sentences = new Composite();
    }

    @Override
    public void add(LexicalElement element) {
        sentences.add(element);
    }

}
