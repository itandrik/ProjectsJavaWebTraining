package com.javaweb.model;


import com.javaweb.model.dao.DAOFactory;
import com.javaweb.model.entity.Sentence;
import com.javaweb.model.entity.Text;
import com.javaweb.model.entity.Word;
import com.javaweb.model.entity.symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Text text;
    private Word word;
    private Sentence sentence;
    private List<Word> wordsWithFirstVowel;
    private DAOFactory factory;

    private static final String ERROR_FILE_WRITE =
            "ERROR, while writing text to file. No DOM model. " +
                    "Create DOM before writing to file";
    public Model() {
        text = new Text();
        word = new Word();
        sentence = new Sentence();
        wordsWithFirstVowel = new ArrayList<>();
        factory = DAOFactory.getDAOFactory();
    }

    public boolean createDOM() {
        if(factory != null){
            String bookText = factory.getTextOfBook();
            if(bookText != null) {
                Symbol previousSymbol = null;
                for (int i = 0; i < bookText.length(); i++) {
                    Symbol symbol = Symbol.createSymbol(bookText.charAt(i));
                    if (previousSymbol == null) {
                        previousSymbol = symbol;
                    }
                    if (symbol.isSentenceSeparator()) {
                        parseSentenceSeparator(previousSymbol, symbol);
                    } else if (symbol.isWhitespace() ||
                            symbol.isPunctuation()) {
                        if (!(symbol.isWhitespace() &&
                                previousSymbol.isWhitespace())) {
                            parseWhitespaceAndPunctuation(previousSymbol, symbol);
                        }
                    } else {
                        parseLetter(symbol);
                    }
                    previousSymbol = symbol;
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void parseLetter(Symbol symbol) {
        word.add(symbol);
    }

    private void parseWhitespaceAndPunctuation(
            Symbol previousSymbol, Symbol symbol) {
        if (previousSymbol.isLetter()) {
            sentence.add(word);
            if (word.startsWithVowel()) {
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
            if (word.startsWithVowel()) {
                wordsWithFirstVowel.add(word);
            }
            word = new Word();
            sentence = new Sentence();
        }
        text.add(symbol);
    }

    public void writeDOMToFile(Text text, String filename) {
        if(text != null) {
            factory.writeTextToFile(text, filename);
        } else {
            throw new RuntimeException(ERROR_FILE_WRITE);
        }
    }

    public Text getText() {
        return text;
    }

    public void sortWordsByFirstConsonant() {
        wordsWithFirstVowel.sort((o1, o2) -> {
            char o1FirstConsonant = Character.toLowerCase(
                    o1.getFirstConsonant().getSymbol());
            char o2FirstConsonant = Character.toLowerCase(
                    o2.getFirstConsonant().getSymbol());
            return o1FirstConsonant - o2FirstConsonant;
        });
    }

    public List<Word> getWordsWithFirstVowel() {
        return wordsWithFirstVowel;
    }

    public String getInputFileName(){
        return factory.getInputFileName();
    }

    /**
     * It was method, that sorts all words in the text(not in the list)
     */
    /*public void sortWordsByFirstConsonant() {
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
    }*/
}
