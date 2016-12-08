package com.javaweb.model.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Class, that demonstrates "Composite" pattern.
 * It is separate class and every LexicalElement
 * should aggregate it. E.G : Text can aggregate Sentence
 * and Sentence separator, so that is why this pattern is so
 * unusual.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public abstract class Composite implements LexicalElement {
    /**
     * List of elements in another element
     */
    private List<LexicalElement> elements;

    /**
     * Initialising list with elements
     */
    public Composite() {
        this.elements = new LinkedList<>();
    }

    /*
     * This method was for exchanging elements in the text
     */
    /*public void swapWith(List<LexicalElement> elements){
        List<LexicalElement> temp = new LinkedList<>(this.elements);

        this.elements.clear();
        for (LexicalElement element:elements) {
            this.elements.add(element);
        }

        elements.clear();
        for (LexicalElement element:temp) {
            elements.add(element);
        }
    }*/

    /**
     * Adding element to List
     *
     * @param element some lexical element
     */
    @Override
    public void add(LexicalElement element) {
        elements.add(element);
    }

    /**
     * @return list with aggregated elements
     */
    @Override
    public List<LexicalElement> getListOfElements() {
        return elements;
    }
}
