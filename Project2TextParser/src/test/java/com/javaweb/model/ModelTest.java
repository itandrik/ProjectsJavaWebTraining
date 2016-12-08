package com.javaweb.model;

import com.javaweb.model.dao.DAOFactory;
import com.javaweb.model.entity.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Testing {@link Model}
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class ModelTest {
    /**
     * Instance of DAO factory
     */
    private DAOFactory factory;
    /**
     * Instance of Model
     */
    private Model model;

    @Before
    public void setUp() throws Exception {
        factory = mock(DAOFactory.class);
        model = new Model();
        model.setFactory(factory);
    }

    @Test
    public void createDOM() {
        when(factory.getTextOfBook()).thenReturn("Hello  ,  world.");
        model.createDOM();
        Text text = model.getText();
        Assert.assertEquals("Size of Text is not correct.",
                2, text.getListOfElements().size());

        LexicalElement helloWorldSentence = text.getListOfElements().get(0);
        Assert.assertEquals("Size of Sentence is not correct.",
                5,
                helloWorldSentence.getListOfElements().size());

        LexicalElement hello = helloWorldSentence.getListOfElements().get(0);
        Assert.assertEquals("First word parsed not correctly",
                hello.getListOfElements().toString(),
                Arrays.asList("\t\t\t|Letter : H;\n",
                        "\t\t\t|Letter : e;\n",
                        "\t\t\t|Letter : l;\n",
                        "\t\t\t|Letter : l;\n",
                        "\t\t\t|Letter : o;\n"
                ).toString());
        LexicalElement whitespace = helloWorldSentence.getListOfElements().get(1);
        Assert.assertTrue("Second symbol is whitespace",
                ((Symbol)whitespace).getSymbolType() == SymbolType.WHITESPACE);
        LexicalElement comma = helloWorldSentence.getListOfElements().get(2);
        Assert.assertTrue("Third symbol is comma.",
                (((Symbol)comma)).getSymbolType() == SymbolType.PUNCTUATION &&
                        (((Symbol) comma).getSymbol() == ','));
        Assert.assertTrue("Last symbol is '.'",
                ((Symbol)text.getListOfElements().get(1)).getSymbolType() ==
                        SymbolType.SENTENCE_SEPARATOR);
    }

    @Test
    public void sortWordsByFirstConsonant() throws Exception {
        when(factory.getTextOfBook()).thenReturn("Preface... " +
                "Anyone involved with the open source community" +
                " or using open source software knows there are tons\n" +
                "of tools available on the market.");
        model.createDOM();
        model.sortWordsByFirstConsonant();
        Assert.assertEquals("List of words, which has vowel beginning is incorrect.",
                10, model.getWordsWithFirstVowel().size());
        List<Word> sortedList = model.getWordsWithFirstVowel();
        boolean flagResultOfSorting = true;
        for (int i = 1; i < sortedList.size(); i++) {
            Symbol prev = sortedList.get(i - 1).getFirstConsonant();
            Symbol curr = sortedList.get(i).getFirstConsonant();

            if (prev.compareTo(curr) > 0) {
                flagResultOfSorting = false;
            }
        }
        Assert.assertTrue("Sorted not correctly",
                flagResultOfSorting);
    }

    @Test
    public void getInputFileName() throws Exception {
        when(factory.getInputFileName()).thenReturn("some_name_of_file.txt");
        Assert.assertEquals(model.getInputFileName(), "some_name_of_file.txt");
    }

}