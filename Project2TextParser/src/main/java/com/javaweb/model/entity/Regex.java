package com.javaweb.model.entity;

import java.util.regex.Pattern;


public enum Regex {
    SENTENCE_SEPARATOR("[.!?]"),
    WHITESPACE("\\s"),
    PUNCTUATION("[-`~@#$%^&*()_+=/|{}\\['\":;,<>]"),
    VOWEL_LETTER("[eyuioaEYUIOA]"),
    CONSONANT_LETTER("[a-zA-Z&&[^aeioyuAEYUIO]]");//"[^aeyuio_+-.,!@#$%^&*();/|<>\"':\\d\\s]";

    Pattern pattern;

    Regex(String regularExpressionString) {
        pattern = Pattern.compile(regularExpressionString);
    }

    public boolean matches(char symbol) {
        return pattern.matcher(String.valueOf(symbol)).matches();
    }
}
