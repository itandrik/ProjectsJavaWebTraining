package com.javaweb.controller;

import com.javaweb.model.Model;
import com.javaweb.model.entity.Text;
import com.javaweb.model.entity.Word;
import com.javaweb.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * This is class, that use {@link Model} and {@link View} to
 * show how program works. Just start it with method {@link #run()}
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Controller {
    /**
     * Instance of {@link View} that uses for printing to console
     */
    private View view;

    /**
     * Instance of {@link Model} that is needed for business logic
     */
    private Model model;

    /**
     * Initialising {@link Model} and {@link View}
     *
     * @param model business logic object
     * @param view  object for printing and with text constants
     */
    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    /**
     * Get string from property file
     *
     * @param configFile   path of config file
     * @param propertyName property, which you want to get from config file
     * @return string with  property from config file
     */
    public String getProperty(String configFile, String propertyName) {
        Properties properties = new Properties();
        String result = null;
        try (FileInputStream stream = new FileInputStream(configFile)) {
            properties.load(stream);
            result = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Main method in controller. Here are parsing of text
     * file, and writing DOM model to file from config.
     */
    public void run() {
        if (model.createDOM()) {            //No file
            Text text = model.getText();    //Text is root of DOM
            model.writeDOMToFile(           //Write to file from config file
                    text,
                    getProperty(View.PROPERTY_PATH,
                            View.PROPERTY_FILE_PATH) +
                            getProperty(View.PROPERTY_PATH,
                                    View.PROPERTY_FILE_OUTPUT_NAME)
            );

            view.printlnMessage(String.format(
                    View.TEXT_PARSED,
                    model.getInputFileName()
            ));
            view.printlnMessage(String.format(
                    View.TEXT_WRITTEN_TO_FILE,
                    model.getInputFileName(),
                    getProperty(View.PROPERTY_PATH,
                            View.PROPERTY_FILE_OUTPUT_NAME)
            ));

            /* Sorting from variant #8 */
            model.sortWordsByFirstConsonant();
            showSorting(model.getWordsWithFirstVowel());
        }
    }

    /**
     * Printing sorted array
     *
     * @param words list of sorted words
     */
    private void showSorting(List<Word> words) {
        view.printlnMessage(View.SORTED_LIST);
        for (Word word : words) {
            view.printMessage(word.toString());
        }
    }
}
