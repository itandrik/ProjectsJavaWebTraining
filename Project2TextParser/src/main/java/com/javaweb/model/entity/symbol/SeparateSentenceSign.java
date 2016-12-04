package com.javaweb.model.entity.symbol;


public class SeparateSentenceSign extends Symbol {
    public SeparateSentenceSign(char symbol) {
        super(symbol);
        super.setIsSeparateSentence(true);
    }
}
