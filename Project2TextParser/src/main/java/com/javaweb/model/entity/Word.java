package com.javaweb.model.entity;


import java.util.List;

/**
 * Class that describes word in the DOM model.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Word extends Composite{
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

    /**
     * Adding letter to word
     *
     * @param symbol symbol from text
     */
    public void parse(Symbol symbol){
        add(symbol);
    }

    /* Method, that is needed for exchanging words in the (@link Text} */
    /*public void swapWith(Word word){
        symbols.swapWith(word.getListOfElements());
    }*/

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(("\t\t|Word : \n"));

        getListOfElements().forEach(
                (elem) -> result.append(elem.toString())

        );
        return result.toString();
    }


}
