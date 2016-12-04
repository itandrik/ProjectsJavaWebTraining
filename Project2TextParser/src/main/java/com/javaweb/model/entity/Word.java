package com.javaweb.model.entity;


public class Word implements LexicalElement {
    private Composite symbols;

    public Word() {
        this.symbols = new Composite();
    }

    @Override
    public void add(LexicalElement element) {
        symbols.add(element);
    }

}
