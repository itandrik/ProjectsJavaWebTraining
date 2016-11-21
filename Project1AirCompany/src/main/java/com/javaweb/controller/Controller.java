package com.javaweb.controller;

import com.javaweb.model.ModelAirlineCompany;
import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.factory.AgriculturalAirplaneFactory;
import com.javaweb.model.entity.factory.FreightAirplaneFactory;
import com.javaweb.model.entity.factory.PassengerAirplaneFactory;
import com.javaweb.view.View;

import java.util.Scanner;

/**
 * Controller.java
 * <p>
 * Class that shows all data using {@link View} and
 * takes all data from {@link ModelAirlineCompany}
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public class Controller {
    /**
     * Instance of {@link View} that uses for printing to console
     */
    private View view;

    /**
     * Our airline company. It is container for airplanes.
     */
    private ModelAirlineCompany<Aircraft> airlineCompany;
    /**
     * Instance of scanner for reading numbers from console
     */
    private Scanner scanner;

    /**
     * Constructor for creating instance of controller
     *
     * @param view           instanec of {@link View} class.
     * @param airlineCompany container for airplanes.
     */
    public Controller(View view, ModelAirlineCompany airlineCompany) {
        this.view = view;
        this.airlineCompany = airlineCompany;
        scanner = new Scanner(System.in);
    }

    /**
     * Main function on this class. Here we calling helpers
     * methods in order to show correct correctness and stability
     * of this program.
     */
    public void processUser() {
        view.printlnMessage(View.HEADER);

        /* Initializing container with airplanes*/
        initializeAirlineCompany();

        /* Print all airplanes from container */
        view.printlnMessage(View.ALL_AIRPLANES);
        if (airlineCompany.getAllAirplanes().isEmpty()) {
            view.printlnMessage(View.EMPTY_AIRLINE_COMPANY);
        } else {
            showAllAirplanesAndStatistic();
        }

        /* Filter airplanes by fuel consumption*/
        showAirplanesByFuelConsumption();

    }

    /**
     * This method shows all airplanes in the airline
     * company. Furthermore, it shows overall carrying
     * and passenger capacity
     */
    private void showAllAirplanesAndStatistic() {
        airlineCompany.getAllAirplanes().stream()
                .forEach(elem -> {
                    view.printlnMessage(elem.toString());
                    view.printlnMessage(View.SEPARATOR);
                });

            /* Print overall carrying capacity */
        view.printMessage(View.OVERALL_CARRYING_CAPACITY);
        view.printlnMessage(airlineCompany.getOverallCarryingCapacity());

            /* Print overall passenger capacity */
        view.printMessage(View.OVERALL_PASSENGER_CAPACITY);
        view.printlnMessage(airlineCompany.getOverallPassengerCapacity());
    }

    /**
     * Here are filtering airplanes by fuel consumption
     */
    private void showAirplanesByFuelConsumption() {
        view.printlnMessage(View.ENTER_FUEL_NUMBERS);

        /*Low limit of fuel consumption*/
        view.printlnMessage(View.LOW_LIMIT_FUEL_CONSUMPTION);
        double lowLimitFuelConsumption = readNumberFromConsole();

        /*High limit of fuel consumption*/
        view.printlnMessage(View.HIGH_LIMIT_FUEL_CONSUMPTION);
        double highLimitFuelConsumption = readNumberFromConsole();

        /* Filter */
        view.printlnMessage(View.FUEL_CONSUMPTION_RESULT);
        airlineCompany.findAircraftWithFuelConsumption(
                lowLimitFuelConsumption, highLimitFuelConsumption).stream()
                .forEach(elem -> view.printlnMessage(elem.getName()));
    }

    /**
     * Reading number from console using regular expression
     *
     * @return double value from console
     */
    private double readNumberFromConsole() {
        while (!scanner.hasNext(View.REGEX_NUMBER)) {
            view.printlnMessage(View.ERROR_INPUT);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Initializing our container using Abstract Factory
     * and enum {@link InitializeAirplanes}
     */
    private void initializeAirlineCompany() {
        for (InitializeAirplanes initValue : InitializeAirplanes.values()) {
            Aircraft aircraft = getAirplaneByType(initValue);
            airlineCompany.addAircraft(aircraft);
        }
    }

    /**
     * Working with abstract factory to get correct instance
     * of Aircraft, which depends on initialise value.
     *
     * @param initValue - enum for initialising
     * @return instance of aircraft
     */
    private Aircraft getAirplaneByType(InitializeAirplanes initValue) {
        switch (initValue.getAirplaneType()) {
            case FREIGHT_HEAVY:
            case FREIGHT_LIGHT:
                return new FreightAirplaneFactory()
                        .getFreightAirplane(initValue);
            case AGRICULTURAL_BIPLANE:
            case AGRICULTURAL_MONOPLANE:
                return new AgriculturalAirplaneFactory()
                        .getAgriculturalAirplane(initValue);
            case PASSENGER_NARROW:
            case PASSENGER_WIDE:
                return new PassengerAirplaneFactory()
                        .getPassengerAirplane(initValue);
            default:
                return null;
        }
    }
}
