package com.javaweb.model.entity.symbol;


public class PunctuationSign extends Symbol {
    public PunctuationSign(char symbol) {
        super(symbol);
        super.setIsPunctuation(true);
    }
    @Override
    public String toString() {
        return "\t\t|Punctuation sign : " + getSymbol() + ";\n";
    }
}
