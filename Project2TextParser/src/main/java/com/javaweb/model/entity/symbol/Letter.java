package com.javaweb.model.entity.symbol;


public class Letter extends Symbol {
    public Letter(char symbol) {
        super(symbol);
        super.setIsLetter(true);
    }
}
