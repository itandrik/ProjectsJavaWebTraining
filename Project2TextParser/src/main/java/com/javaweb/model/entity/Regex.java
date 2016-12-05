package com.javaweb.model.entity;

import java.util.regex.Pattern;


public interface Regex {
    String SENTENCE_SEPARATOR = "[.!?]";
    String WHITESPACE = "\\s";
    String PUNCTUATION = "[-`~@#$%^&*()_+=/|{}\\['\":;,<>]";
    String VOWEL_LETTER = "[eyuioaEYUIOA]";
    String CONSONANT_LETTER = "[^aeyuio_+-.,!@#$%^&*();\\/|<>\"':\\d\\s]";

    Pattern PUNCTUATION_PATTERN = Pattern.compile(PUNCTUATION);
    Pattern SENTENCE_SEPARATOR_PATTERN = Pattern.compile(SENTENCE_SEPARATOR);
    Pattern WHITESPACE_PATTERN = Pattern.compile(WHITESPACE);
    Pattern VOWEL_LETTER_PATTERN = Pattern.compile(VOWEL_LETTER);
    Pattern CONSONANT_LETTER_PATTERN = Pattern.compile(CONSONANT_LETTER);
}
