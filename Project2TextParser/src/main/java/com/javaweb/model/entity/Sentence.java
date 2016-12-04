package com.javaweb.model.entity;


public class Sentence implements LexicalElement{
    private Composite words;

    @Override
    public void add(LexicalElement sentence) {
        words.add(sentence);
    }
}
