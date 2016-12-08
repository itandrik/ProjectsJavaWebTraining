package com.javaweb.model;


import com.javaweb.model.dao.DAOFactory;
import com.javaweb.model.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class, that creates DOM model using all entity and DAO
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Model {
    /**
     * Text instance. Root element
     */
    private Text text;
    /**
     * Word instance
     */
    private Word word;
    /**
     * Sentence instance
     */
    private Sentence sentence;
    /**
     * Collection for sorting words according to variant #8
     */
    private List<Word> wordsWithFirstVowel;
    /**
     * Instance of DAO factory
     */
    private DAOFactory factory;

    /**
     * Error message for writing DOM to file
     */
    private static final String ERROR_FILE_WRITE =
            "ERROR, while writing text to file. No DOM model. " +
                    "Create DOM before writing to file";

    /**
     * Initialising all elements of text and creating factory
     */
    public Model() {
        text = new Text();
        word = new Word();
        sentence = new Sentence();
        wordsWithFirstVowel = new ArrayList<>();
        factory = DAOFactory.getDAOFactory();
    }

    /**
     * Main method of this class. It creates DOM model
     * from some text, according to config file
     *
     * @return is DOM created or not(was some exceptions
     */
    public boolean createDOM() {
        if (factory != null) {
            //Getting text from file or DB
            String bookText = factory.getTextOfBook();
            if (bookText != null) {
                Symbol previousSymbol = null; // For checking whitespaces, etc.
                for (int i = 0; i < bookText.length(); i++) {
                    /* Creating symbol according to its definition */
                    Symbol symbol = Symbol.createSymbol(bookText.charAt(i));
                    if (previousSymbol == null) {
                        previousSymbol = symbol;
                    }
                    if (symbol.getSymbolType() == SymbolType.SENTENCE_SEPARATOR) { // When '.', '!', '?'
                        text.parseSentenceSeparator(previousSymbol, symbol,
                                sentence,word,wordsWithFirstVowel);
                        if (!(previousSymbol.getSymbolType() == SymbolType.SENTENCE_SEPARATOR ||
                                previousSymbol.getSymbolType() == SymbolType.PUNCTUATION)) {
                            word = new Word();
                            sentence = new Sentence();
                        }
                    } else if (symbol.getSymbolType() == SymbolType.WHITESPACE || // When whitespace or comma,etc.
                            symbol.getSymbolType() == SymbolType.PUNCTUATION) {
                        if (!(symbol.getSymbolType() == SymbolType.WHITESPACE &&  // If double whitespace -> skip
                                previousSymbol.getSymbolType() == SymbolType.WHITESPACE)) {
                            sentence.parseWhitespaceAndPunctuation(
                                    word,wordsWithFirstVowel, previousSymbol, symbol);
                            if (previousSymbol.getSymbolType() == SymbolType.LETTER) {
                                word = new Word();
                            }
                        }
                    } else {
                        word.parse(symbol);
                    }
                    previousSymbol = symbol;
                }
                return true;        // DOM model created
            } else {
                return false;       // DOM model not created
            }
        } else {
            return false;           // DOM model not created
        }
    }

    /**
     * Write DOM model to file
     *
     * @param text     root element of DOM model
     * @param filename name of file, where to write DOM
     */
    public void writeDOMToFile(Text text, String filename) {
        if (text != null) {
            factory.writeTextToFile(text, filename);
        } else {
            throw new RuntimeException(ERROR_FILE_WRITE);
        }
    }

    public Text getText() {
        return text;
    }

    /**
     * Sorting, according to variant #8. In the separate list,
     * not in the text. In the list with words, which starts
     * with first vowel letter here are sorting words
     * by first consonant letter
     */
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

    public String getInputFileName() {
        return factory.getInputFileName();
    }

    public void setFactory(DAOFactory factory) {
        this.factory = factory;
    }

    /*
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
