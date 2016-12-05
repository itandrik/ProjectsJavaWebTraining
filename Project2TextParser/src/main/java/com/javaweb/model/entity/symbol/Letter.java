package com.javaweb.model.entity.symbol;


public class Letter extends Symbol {
    public Letter(char symbol) {
        super(symbol);
        super.setIsLetter(true);
    }

    @Override
    public String toString() {
        return "\t\t\t|Letter : " + getSymbol() + ";\n";
    }
}
