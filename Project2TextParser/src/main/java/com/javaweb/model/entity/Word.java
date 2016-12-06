package com.javaweb.model.entity;


import com.javaweb.model.entity.symbol.Symbol;

import java.util.List;

public class Word implements LexicalElement {
    private Composite symbols;

    public Word() {
        this.symbols = new Composite();
    }

    public boolean startsWithVowel() {
        List<LexicalElement> word = getListOfElements();
        return word.size() != 0 &&
                Regex.VOWEL_LETTER.matches(((Symbol) word.get(0)).getSymbol());
    }

    public Symbol getFirstConsonant(){
        for(LexicalElement symbol : getListOfElements()){
            Symbol result = (Symbol)symbol;
            if(Regex.CONSONANT_LETTER.matches(result.getSymbol())){
                return result;
            }
        }
        return null;
    }

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
