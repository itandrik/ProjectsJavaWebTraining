package com.javaweb.model.entity;


import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Abstract class for all symbols. Has 4 states. Has
 * realisation of "Flyweight" pattern. Defines symbol in the text.
 * It is leaf in the "Composite".
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Symbol implements LexicalElement, Comparable {
    /**
     * Weak reference are not restricted to these hash tables.
     */
    private static final WeakHashMap<Character, WeakReference<Symbol>>
            flyweightSymbol = new WeakHashMap<>();
    /**
     * Character of symbol
     */
    private char symbol;

    /* States of symbol. It will work faster that checking with "instanceof" */
    private SymbolType symbolType;

    /**
     * Default constructor
     *
     * @param symbol character of symbol
     */
    private Symbol(char symbol, SymbolType symbolType) {
        this.symbol = symbol;
        this.symbolType = symbolType;
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
     * @return instance of symbol according to character element
     */
    public static Symbol createSymbol(char symbol) {
        /* Return Symbol object with minimal resources */
        if (flyweightSymbol.containsKey(symbol)) {
            return flyweightSymbol.get(symbol).get();
        }

        /* We are unconcerned with object creation cost,
        we are reducing overall memory consumption */
        Symbol symbolWrapper;
        if (Regex.SENTENCE_SEPARATOR.matches(symbol)) {
            symbolWrapper = new Symbol(symbol, SymbolType.SENTENCE_SEPARATOR);
        } else if (Regex.WHITESPACE.matches(symbol)) {
            symbolWrapper = new Symbol(symbol, SymbolType.WHITESPACE);
        } else if (Regex.PUNCTUATION.matches(symbol)) {
            symbolWrapper = new Symbol(symbol, SymbolType.PUNCTUATION);
        } else {
            symbolWrapper = new Symbol(symbol, SymbolType.LETTER);
        }

        /* Put object to HashMap */
        flyweightSymbol.put(symbol, new WeakReference<Symbol>(symbolWrapper));
        return symbolWrapper;
    }

    /**
     * Make class comparable
     *
     * @param o object of another Symbol
     * @return - this bigger o then 1 - this smaller o then -1 - this == o then 0
     */
    @Override
    public int compareTo(Object o) {
        return symbol - ((Symbol) o).getSymbol();
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    @Override
    public String toString() {
        return symbolType.getFormattedString(symbol);
    }
}
