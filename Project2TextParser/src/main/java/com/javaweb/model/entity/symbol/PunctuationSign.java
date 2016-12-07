package com.javaweb.model.entity.symbol;

/**
 * PunctuationSign.java
 * <t>
 * Class that shows punctuation mark object behaviour
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class PunctuationSign extends Symbol {
    /**
     * @param symbol char of special sign
     */
    public PunctuationSign(char symbol) {
        super(symbol);               // Setting char punctuation for Symbol
        super.setIsPunctuation(true);// Setting correct flag
    }

    /**
     * Show punctuation mark in the console
     *
     * @return string with letter
     */
    @Override
    public String toString() {
        return "\t\t|Punctuation sign : " + getSymbol() + ";\n";
    }
}
