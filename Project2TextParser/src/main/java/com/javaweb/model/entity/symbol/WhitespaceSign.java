package com.javaweb.model.entity.symbol;


public class WhitespaceSign extends Symbol {

    public WhitespaceSign(char symbol) {
        super(symbol);
        super.setIsWhitespace(true);
    }

}
