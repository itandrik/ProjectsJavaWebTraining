package com.javaweb.model;


import com.javaweb.model.entity.Sentence;
import com.javaweb.model.entity.Text;
import com.javaweb.model.entity.Word;
import com.javaweb.model.entity.symbol.Symbol;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Model {
    private Text text;
    private Word word;
    private Sentence sentence;
    private List<Word> wordsWithFirstVowel;

    public Model() {
        text = new Text();
        word = new Word();
        sentence = new Sentence();
        wordsWithFirstVowel = new LinkedList<>();
    }

    public void createDOM(String filename) {
        try (FileReader fir = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fir)) {

            int c;
            Symbol previousSymbol = null;
            while ((c = reader.read()) != -1) {
                Symbol symbol = Symbol.createSymbol((char) c);
                if (previousSymbol == null) {
                    previousSymbol = symbol;
                }
                if (symbol.isSentenceSeparator()) {
                    parseSentenceSeparator(previousSymbol, symbol);
                } else if (symbol.isWhitespace() ||
                        symbol.isPunctuation()) {
                    if (symbol.isWhitespace() &&
                            previousSymbol.isWhitespace()) {
                        continue;
                    } else {
                        parseWhitespaceAndPunctuation(previousSymbol, symbol);
                    }
                } else {
                    parseLetter(previousSymbol, symbol);
                }
                previousSymbol = symbol;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLetter(Symbol previousSymbol, Symbol symbol) {
        word.add(symbol);
    }

    private void parseWhitespaceAndPunctuation(
            Symbol previousSymbol, Symbol symbol) {
        if (previousSymbol.isLetter()) {
            sentence.add(word);
            if(word.startsWithVowel()){
                wordsWithFirstVowel.add(word);
            }
            word = new Word();
        }
        sentence.add(symbol);
    }

    private void parseSentenceSeparator(Symbol previousSymbol, Symbol symbol) {
        if (!(previousSymbol.isSentenceSeparator() ||
                previousSymbol.isPunctuation())) {
            sentence.add(word);
            text.add(sentence);
            if(word.startsWithVowel()){
                wordsWithFirstVowel.add(word);
            }
            word = new Word();
            sentence = new Sentence();
        }
        text.add(symbol);
    }

    public void writeDOMToFile(String filename) {
        try (PrintWriter out =
                     new PrintWriter(new FileWriter(new File(filename)))) {
            out.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Text getText() {
        return text;
    }

    public void sortWordsByFirstConsonant() {
        for (Word word:wordsWithFirstVowel) {
            System.out.print(word);
        }
        for (int i = 0; i < wordsWithFirstVowel.size(); i++) {
            Symbol minSymbol = wordsWithFirstVowel.get(i).getFirstConsonant();
            // If min symbol has consonant letter
            if(minSymbol != null) {
                char min = minSymbol.getSymbol();
                int minIndex = i;
                for (int j = i + 1; j < wordsWithFirstVowel.size(); j++) {
                    Symbol firstConsonantSymbol = wordsWithFirstVowel.get(j).getFirstConsonant();
                    // If word has consonant letter
                    if (firstConsonantSymbol != null) {
                        char curSymbol = wordsWithFirstVowel.get(j).getFirstConsonant().getSymbol();
                        if (curSymbol < min) {
                            min = curSymbol;
                            minIndex = j;
                        }
                    }
                }

                if (i != minIndex)
                    wordsWithFirstVowel.get(i).swapWith(wordsWithFirstVowel.get(minIndex));
            }
        }
        for (Word word:wordsWithFirstVowel) {
            System.out.print(word);
        }
    }
}
