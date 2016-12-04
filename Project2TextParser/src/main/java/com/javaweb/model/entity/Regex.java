package com.javaweb.model.entity;

import java.util.regex.Pattern;


public interface Regex {
    String SENTENCE_SEPARATOR = "[.!?]";
    String WHITESPACE = "\\s";
    String PUNCTUATION = "[-`~@#$%^&*()_+=/|{}['\":;,<>]";

    Pattern PUNCTUATION_PATTERN = Pattern.compile(PUNCTUATION);
    Pattern SENTENCE_SEPARATOR_PATTERN = Pattern.compile(SENTENCE_SEPARATOR);
    Pattern WHITESPACE_PATTERN = Pattern.compile(WHITESPACE);
}
