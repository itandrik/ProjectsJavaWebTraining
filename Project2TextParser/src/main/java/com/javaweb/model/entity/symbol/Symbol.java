package com.javaweb.model.entity.symbol;


import com.javaweb.model.entity.Regex;
import com.javaweb.model.entity.LexicalElement;

public abstract class Symbol implements LexicalElement{
    private char symbol;
    private boolean isLetter = false;
    private boolean isWhitespace = false;
    private boolean isSeparateSentence = false;
    private boolean isPunctuation = false;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(LexicalElement element) {
        //this is leaf node so this method is not applicable to this class.
    }

    public static Symbol createSymbol(char symbol) {
        String symbolStr = String.valueOf(symbol);
        if (Regex.SENTENCE_SEPARATOR_PATTERN
                .matcher(symbolStr).matches()){
            return new SeparateSentenceSign(symbol);
        } else if(Regex.WHITESPACE_PATTERN
                .matcher(symbolStr).matches()) {
            return new WhitespaceSign(symbol);
        } else if(Regex.PUNCTUATION_PATTERN
                .matcher(symbolStr).matches()){
            return new PunctuationSign(symbol);
        }else{
            return new Letter(symbol);
        }
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

    public boolean isSeparateSentence() {
        return isSeparateSentence;
    }

    public void setIsSeparateSentence(boolean separateSentence) {
        isSeparateSentence = separateSentence;
    }

    public boolean isPunctuation() {
        return isPunctuation;
    }

    public void setIsPunctuation(boolean punctuation) {
        isPunctuation = punctuation;
    }
}
