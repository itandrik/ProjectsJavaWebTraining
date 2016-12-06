package com.javaweb.controller;

import com.javaweb.model.Model;
import com.javaweb.model.entity.Text;
import com.javaweb.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Controller {
    private View view;
    private Model model;
    private Properties property;


    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    private String getProperty(String propertyName){
        Properties properties = new Properties();
        String result = null;
        try(FileInputStream stream = new FileInputStream(View.PROPERTY_PATH)) {
            properties.load(stream);
            result = properties.getProperty(propertyName);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public void run() {
        model.createDOM();
        Text text = model.getText();
        model.writeDOMToFile(
                text,
                getProperty(View.PROPERTY_FILE_PATH) +
                        getProperty(View.PROPERTY_FILE_OUTPUT_NAME)
        );

        view.printMessage(String.format(
                View.TEXT_PARSED,
                getProperty(View.PROPERTY_FILE_OUTPUT_NAME)
        ));
        view.printMessage(String.format(
                View.TEXT_WRITTEN_TO_FILE,
                getProperty(View.PROPERTY_FILE_OUTPUT_NAME)
        ));


        model.sortWordsByFirstConsonant();

    }
}
