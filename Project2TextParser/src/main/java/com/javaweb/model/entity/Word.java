package com.javaweb.model.entity;


import com.javaweb.model.entity.symbol.Symbol;

import java.util.List;

/**
 * Class that describes word in the DOM model.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Word implements LexicalElement {
    /**
     * List of symbols in the word
     */
    private Composite symbols;

    /**
     * Initialising list of symbols
     */
    public Word() {
        this.symbols = new Composite();
    }

    /**
     * Checking if word has vowel beginning
     *
     * @return is word starts withVowel or not
     */
    public boolean startsWithVowel() {
        List<LexicalElement> word = getListOfElements();
        return word.size() != 0 &&
                Regex.VOWEL_LETTER.matches(((Symbol) word.get(0)).getSymbol());
    }

    /**
     * Getting first consonant letter in the word
     *
     * @return instance of {@link Symbol} with consonant letter
     */
    public Symbol getFirstConsonant() {
        for (LexicalElement symbol : getListOfElements()) {
            Symbol result = (Symbol) symbol;
            if (Regex.CONSONANT_LETTER.matches(result.getSymbol())) {
                return result;
            }
        }
        return Symbol.createSymbol('z');
    }
    /* Method, that is needed for exchanging words in the (@link Text} */
    /*public void swapWith(Word word){
        symbols.swapWith(word.getListOfElements());
    }*/

    @Override
    public void add(LexicalElement element) {
        symbols.add(element);
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        return symbols.getListOfElements();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(("\t\t|Word : \n"));

        getListOfElements().forEach(
                (elem) -> result.append(elem.toString())

        );
        return result.toString();
    }


}
