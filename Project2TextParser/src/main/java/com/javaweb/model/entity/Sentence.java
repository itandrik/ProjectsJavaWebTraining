package com.javaweb.model.entity;


import java.util.List;

/**
 * Class that describes sentence in the DOM model
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Sentence extends Composite {
    /**
     * Adding punctuation marks and words to sentence
     *
     * @param previousSymbol previous symbol from text
     * @param symbol         symbol from text
     */
    public void parseWhitespaceAndPunctuation(
            Word word, List<Word> wordsWithFirstVowel,
            Symbol previousSymbol, Symbol symbol) {
        if (previousSymbol.getSymbolType() == SymbolType.LETTER) {
            add(word);
            if (word.startsWithVowel()) {
                wordsWithFirstVowel.add(word);
            }
            word = new Word();
        }
        add(symbol);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\t|Sentence : \n");
        getListOfElements().forEach(
                (elem) -> result.append(elem.toString())
        );
        return result.toString();
    }
}
