package com.javaweb.model.entity.symbol;

/**
 * Class that shows sentence separator object behaviour
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class SeparateSentenceSign extends Symbol {
    /**
     * @param symbol char of special sign
     */
    public SeparateSentenceSign(char symbol) {
        super(symbol); // Setting char sentence separator for Symbol
        super.setIsSentenceSeparator(true);// Setting correct flag
    }

    /**
     * Show sentence separator mark in the console
     *
     * @return string with letter
     */
    @Override
    public String toString() {
        return "\t|Sentence separator : " + getSymbol() + ";\n";
    }
}
