package com.javaweb.model.entity.symbol;


import com.javaweb.model.entity.LexicalElement;
import com.javaweb.model.entity.Regex;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Symbol.java
 * <t>
 * Abstract class for all symbols. Has 4 states. Has
 * realisation of "Flyweight" pattern. Defines symbol in the text.
 * It is leaf in the "Composite".
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public abstract class Symbol implements LexicalElement, Comparable {
    /**
     * Weak reference are not restricted to these hash tables.
     */
    private static final WeakHashMap<Symbol, WeakReference<Symbol>>
            flyweightSymbol = new WeakHashMap<>();
    /**
     * Character of symbol
     */
    private char symbol;
    /* States of symbol. It will work faster that checking with "instanceof" */
    private boolean isLetter = false;
    private boolean isWhitespace = false;
    private boolean isSentenceSeparator = false;
    private boolean isPunctuation = false;

    /**
     * Default constructor
     *
     * @param symbol character of symbol
     */
    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Needs to implement because of {@link LexicalElement}
     *
     * @param element element to add
     */
    @Override
    public void add(LexicalElement element) {
        //this is leaf node so this method is not applicable to this class.
    }

    /**
     * Needs to implement because of {@link LexicalElement}
     *
     * @return list of all elements in the collection
     */
    @Override
    public List<LexicalElement> getListOfElements() {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }

    /**
     * Factory method + Flyweight. Here are checking
     * symbol using regular expressions and returning
     * correct instance of symbol.
     *
     * @param symbol symbol from text
     * @return instance of symbol according
     *         to character element
     */
    public static Symbol createSymbol(char symbol) {

        /* We are unconcerned with object creation cost,
        we are reducing overall memory consumption */
        Symbol symbolWrapper;
        if (Regex.SENTENCE_SEPARATOR.matches(symbol)) {
            symbolWrapper = new SeparateSentenceSign(symbol);
        } else if (Regex.WHITESPACE.matches(symbol)) {
            symbolWrapper = new WhitespaceSign(symbol);
        } else if (Regex.PUNCTUATION.matches(symbol)) {
            symbolWrapper = new PunctuationSign(symbol);
        } else {
            symbolWrapper = new Letter(symbol);
        }

        /* Put to HashMap */
        if (!flyweightSymbol.containsKey(symbolWrapper)) {
            flyweightSymbol.put(symbolWrapper, new WeakReference<>(symbolWrapper));
        }

        /* Return Symbol object with minimal resources*/
        return flyweightSymbol.get(symbolWrapper).get();
    }

    /**
     * Make class comparable
     * @param o object of another Symbol
     * @return 1    - this > o
     *         -1   - this < o
     *         0    - this == o
     */
    @Override
    public int compareTo(Object o) {
        return symbol > ((Symbol) o).getSymbol() ? 1 :
                (symbol < ((Symbol) o).getSymbol() ? -1 : 0);
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
