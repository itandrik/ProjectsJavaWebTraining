package com.javaweb.model.entity.symbol;

/**
 * Letter.java
 * <t>
 * Class that shows letter object behaviour
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Letter extends Symbol {
    /**
     * @param symbol char of special letter
     */
    public Letter(char symbol) {
        super(symbol);          // Setting char letter for Symbol
        super.setIsLetter(true);// Setting correct flag
    }

    /**
     * Show letter in the console
     *
     * @return string with letter
     */
    @Override
    public String toString() {
        return "\t\t\t|Letter : " + getSymbol() + ";\n";
    }
}
