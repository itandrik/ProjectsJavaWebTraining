package com.javaweb.model.entity.symbol;


public class SeparateSentenceSign extends Symbol {
    public SeparateSentenceSign(char symbol) {
        super(symbol);
        super.setIsSentenceSeparator(true);
    }

    @Override
    public String toString() {
        return "\t|Sentence separator : " + getSymbol() + ";\n";
    }
}
