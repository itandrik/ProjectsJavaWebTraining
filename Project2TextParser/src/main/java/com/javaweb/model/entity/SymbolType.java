package com.javaweb.model.entity;

/**
 * Class, that describes type of symbol from text
 *
 * @author Andrii Chernysh
 */
public enum SymbolType {
    LETTER("\t\t\t|Letter : %c;\n"),                        // Letter
    PUNCTUATION("\t\t|Punctuation sign : %c;\n"),           // Punctuation (',',etc)
    SENTENCE_SEPARATOR( "\t|Sentence separator : %c;\n"),   // '.','?','!'
    WHITESPACE("\t\t|--Whitespace--%c\n");                  // Whitespaces

    /**
     * String for formatted output
     */
    String formattedOutputString;

    /**
     * Default constructor for enum
     *
     * @param formattedOutputString pretty output string
     */
    SymbolType(String formattedOutputString) {
        this.formattedOutputString = formattedOutputString;
    }

    /**
     * @param symbol symbol, that is needed to show in the console
     * @return       formatted string to show
     */
    public String getFormattedString(char symbol){
        return String.format(formattedOutputString,symbol);
    }
}
