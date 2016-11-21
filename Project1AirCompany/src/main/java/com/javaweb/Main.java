package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.model.ModelAirlineCompany;
import com.javaweb.model.entity.Aircraft;
import com.javaweb.view.View;

/**
 * Main.java
 * <p>
 * Start point of the Electronic Notebook.
 * Here we will start controller {@link Controller}
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public class Main {
    public static void main(String[] args) {
        /*ResourceBundle bundle = ResourceBundle.getBundle("com/javaweb/AircraftParameters");
        System.out.println(MessageFormat.format(bundle.getString("NAME_OF_AIRCRAFT"),"fsdf"));
        System.exit(0);*/
        /* Creating instance of view */
        View view = new View();

        /* Creating instance of airline company container*/
        ModelAirlineCompany<Aircraft> airlineCompany =
                new ModelAirlineCompany<>();

        /* Creating instance of controller*/
        Controller controller = new Controller(view, airlineCompany);

        /* Run */
        controller.processUser();
    }
}
