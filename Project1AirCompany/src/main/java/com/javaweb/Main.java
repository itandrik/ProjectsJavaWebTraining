package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.model.ModelAirlineCompany;
import com.javaweb.model.entity.Aircraft;
import com.javaweb.view.View;

/**
 * Created by Dron on 12-Nov-16.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        ModelAirlineCompany<Aircraft> airlineCompany =
                new ModelAirlineCompany<>();
        Controller controller = new Controller(view, airlineCompany);
        controller.processUser();
    }
}
