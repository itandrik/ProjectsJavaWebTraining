package com.javaweb.model.entity;


import java.util.List;

public interface LexicalElement {
    List<LexicalElement> getListOfElements();
    void add(LexicalElement element);
}
