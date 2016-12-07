package com.javaweb.model.entity;


import java.util.List;

/**
 * Class that describes sentence in the DOM model
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Sentence implements LexicalElement {
    /**
     * List of words
     */
    private Composite words;

    /**
     * Initialising list of words
     */
    public Sentence() {
        this.words = new Composite();
    }

    @Override
    public void add(LexicalElement word) {
        words.add(word);
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        return words.getListOfElements();
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
