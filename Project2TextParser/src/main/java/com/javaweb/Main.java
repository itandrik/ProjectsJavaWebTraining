package com.javaweb;


import com.javaweb.controller.Controller;
import com.javaweb.model.Model;
import com.javaweb.view.View;

/**
 * Start point of the Text Parser.
 * Here we will start controller {@link Controller}
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class Main {
    public static void main(String[] args) {
        /* Creating instance of model */
        Model model = new Model();
        /* Creating instance of view */
        View view = new View();
        /* Creating instance of controller */
        Controller controller = new Controller(model, view);
        /* Start the program */
        controller.run();
    }
}
