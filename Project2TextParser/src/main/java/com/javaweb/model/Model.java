package com.javaweb.model;


import com.javaweb.model.entity.*;
import com.javaweb.model.entity.symbol.Symbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {

    public void createDOM(String filename){
        try {
            FileReader fir = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fir);
            int c;

            ElementAdder adder = new ElementAdder();
            Text text = new Text();
            Word word = new Word();
            Sentence sentence = new Sentence();
            LexicalElement elementToAdd;

            while((c = reader.read()) != -1) {
                Symbol symbol = Symbol.createSymbol((char) c);
                if(symbol.isSeparateSentence()){
                    elementToAdd = sentence;
                    adder.setWhereToAdd(text);
                    sentence = new Sentence();
                }else if (symbol.isWhitespace()){
                    elementToAdd = word;
                    adder.setWhereToAdd(sentence);
                    word = new Word();
                }else{
                    elementToAdd = symbol;
                    adder.setWhereToAdd(word);
                }
                adder.add(elementToAdd);
                //System.out.print(c + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
