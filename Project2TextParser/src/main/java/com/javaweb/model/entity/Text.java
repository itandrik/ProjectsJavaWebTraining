package com.javaweb.model.entity;


import java.util.List;

/**
 * Class that describes text in the DOM model.
 * It is root for DOM.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Text extends Composite {
    private Word word;
    private Sentence sentence;
    /**
     * Add sentence and sentence separators to Text
     *
     * @param previousSymbol previous symbol from text
     * @param symbol         symbol from text
     */
    public void parseSentenceSeparator(
            Symbol previousSymbol, Symbol symbol,
            Sentence sentence, Word word, List<Word> wordsWithFirstVowel) {
        if (!(previousSymbol.getSymbolType() == SymbolType.SENTENCE_SEPARATOR ||
                previousSymbol.getSymbolType() == SymbolType.PUNCTUATION)) {
            sentence.add(word);
            add(sentence);
            if (word.startsWithVowel()) {
                wordsWithFirstVowel.add(word);
            }
            word = new Word();
            sentence = new Sentence();
        }
        add(symbol);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Programming book : \n");
        getListOfElements().forEach(
                (elem) -> result.append(elem.toString())
        );
        return result.toString();
    }
}
