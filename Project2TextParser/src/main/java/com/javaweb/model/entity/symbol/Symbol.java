package com.javaweb.model.entity.symbol;


import com.javaweb.model.entity.LexicalElement;
import com.javaweb.model.entity.Regex;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;

public abstract class Symbol implements LexicalElement {
    private static final WeakHashMap<Symbol, WeakReference<Symbol>>
            flyweightSymbol = new WeakHashMap<>();
    private char symbol;
    private boolean isLetter = false;
    private boolean isWhitespace = false;
    private boolean isSentenceSeparator = false;
    private boolean isPunctuation = false;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(LexicalElement element) {
        //this is leaf node so this method is not applicable to this class.
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }

    public static Symbol createSymbol(char symbol) {
        String symbolCastedToString = String.valueOf(symbol);

        /* We are unconcerned with object creation cost,
        we are reducing overall memory consumption */
        Symbol symbolWrapper;
        if (Regex.SENTENCE_SEPARATOR_PATTERN
                .matcher(symbolCastedToString).matches()) {
            symbolWrapper = new SeparateSentenceSign(symbol);
        } else if (Regex.WHITESPACE_PATTERN
                .matcher(symbolCastedToString).matches()) {
            symbolWrapper = new WhitespaceSign(symbol);
        } else if (Regex.PUNCTUATION_PATTERN
                .matcher(symbolCastedToString).matches()) {
            symbolWrapper = new PunctuationSign(symbol);
        } else {
            symbolWrapper = new Letter(symbol);
        }

        if (!flyweightSymbol.containsKey(symbolWrapper)) {
            flyweightSymbol.put(symbolWrapper, new WeakReference<>(symbolWrapper));
        }

        return flyweightSymbol.get(symbolWrapper).get();
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isLetter() {
        return isLetter;
    }

    public void setIsLetter(boolean letter) {
        isLetter = letter;
    }

    public boolean isWhitespace() {
        return isWhitespace;
    }

    public void setIsWhitespace(boolean whitespace) {
        isWhitespace = whitespace;
    }

    public boolean isSentenceSeparator() {
        return isSentenceSeparator;
    }

    public void setIsSentenceSeparator(boolean sentenceSeparator) {
        isSentenceSeparator = sentenceSeparator;
    }

    public boolean isPunctuation() {
        return isPunctuation;
    }

    public void setIsPunctuation(boolean punctuation) {
        isPunctuation = punctuation;
    }
}
