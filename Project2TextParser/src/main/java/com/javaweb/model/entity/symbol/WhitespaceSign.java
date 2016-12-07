package com.javaweb.model.entity.symbol;

/**
 * Class that shows whitespace object behaviour
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class WhitespaceSign extends Symbol {
    /**
     * @param symbol char of special sign
     */
    public WhitespaceSign(char symbol) {
        super(symbol);              // Setting char whitespace for Symbol
        super.setIsWhitespace(true);// Setting correct flag
    }

    /**
     * Show whitespace mark in the console
     *
     * @return string with letter
     */
    @Override
    public String toString() {
        return "\t\t|--Whitespace--\n";
    }
}
