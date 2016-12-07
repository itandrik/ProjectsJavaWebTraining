package com.javaweb.model.entity;


import java.util.List;

/**
 * Class that describes text in the DOM model.
 * It is root for DOM.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Text implements LexicalElement {
    /**
     * List of sentences
     */
    private Composite sentences;

    /**
     * Initialising list of sentences
     */
    public Text() {
        this.sentences = new Composite();
    }

    @Override
    public void add(LexicalElement element) {
        sentences.add(element);
    }

    @Override
    public List<LexicalElement> getListOfElements() {
        return sentences.getListOfElements();
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
