package com.javaweb.controller;

import com.javaweb.model.Model;
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
    }
}
