package com.javaweb.controller;

import com.javaweb.model.Model;
import com.javaweb.model.entity.Text;
import com.javaweb.view.View;


public class Controller {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        model.createDOM(View.FILENAME);
        Text text = model.getText();
        model.writeDOMToFile(View.OUTPUT_FILENAME);
        view.printMessage(text.toString());

        model.sortWordsByFirstConsonant();
    }
}
