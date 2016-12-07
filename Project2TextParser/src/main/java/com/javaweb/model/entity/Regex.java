package com.javaweb.model.entity;

import java.util.regex.Pattern;

/**
 * Enum that describes regular expressions,
 * that is needed for this program.
 * Also it creates {@link Pattern} class and
 * matches some special regular expression with
 * custom symbol.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public enum Regex {
    SENTENCE_SEPARATOR("[.!?]"),
    WHITESPACE("\\s"),
    PUNCTUATION("[-`~@#$%^&*()_+=/|{}\\['\":;,<>]"),
    VOWEL_LETTER("[eyuioaEYUIOA]"),
    CONSONANT_LETTER("[a-zA-Z&&[^aeioyuAEYUIO]]");//"[^aeyuio_+-.,!@#$%^&*();/|<>\"':\\d\\s]";

    /**
     * Pattern for matcher.
     */
    Pattern pattern;

    /**
     * Enum constructor for creating pattern
     *
     * @param regularExpressionString string with regular expression
     */
    Regex(String regularExpressionString) {
        pattern = Pattern.compile(regularExpressionString);
    }

    /**
     * @param symbol symbol to check
     * @return is matches with regular expression
     */
    public boolean matches(char symbol) {
        return pattern.matcher(String.valueOf(symbol)).matches();
    }
}
