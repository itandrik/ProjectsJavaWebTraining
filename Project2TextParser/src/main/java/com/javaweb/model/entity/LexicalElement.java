package com.javaweb.model.entity;


import java.util.List;

/**
 * Interface, that shows what parser can do
 * with every class. {@link Text}, {@link Word},
 * {@link Sentence} and {@link Symbol}
 * implements this interface
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public interface LexicalElement {
    /**
     * Getting all elements from collection
     *
     * @return list of elements from another LexicalElement
     */
    List<LexicalElement> getListOfElements();

    /**
     * Adding some LexicalElement to collection
     *
     * @param element element to add
     */
    void add(LexicalElement element);

    /**
     * @return pretty string for console
     */
    @Override
    String toString();
}
