package com.javaweb.view;

/**
 * View.java
 * <p>
 * It is class, which contains String constants
 * in order to show tips for user in the console.
 * In the future we can change UI by simple steps.
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */

public class View {
    /**
     * Header for cute console view.
     */
    public static final String HEADER =
            "<---------------- Airline company ---------------->";

    /* Strings for showing and entering some information. Work with console*/
    public static final String OVERALL_CARRYING_CAPACITY =
            "Summary carrying capacity in all airplanes of your company : ";
    public static final String OVERALL_PASSENGER_CAPACITY =
            "Summary passenger capacity in all airplanes of your company : ";
    public static final String ENTER_FUEL_NUMBERS =
            "Now, lets find airplanes with fuel consumption diapason!";
    public static final String LOW_LIMIT_FUEL_CONSUMPTION =
            "Enter your low limit of fuel consumption(real or int value) : ";
    public static final String HIGH_LIMIT_FUEL_CONSUMPTION =
            "Enter your high limit of fuel consumption(real or int value) : ";
    public static final String FUEL_CONSUMPTION_RESULT =
            "Result of your filter : ";
    public static final String ALL_AIRPLANES =
            "Your airplanes(Sorted by range of flight) :";
    public static final String EMPTY_AIRLINE_COMPANY =
            "Empty hangar! No airplanes in the airline company";
    /**
     * Error message while input from console
     */
    public static final String ERROR_INPUT =
            "Error input! You should enter real" +
                    " or int value! Repeat please...";

    /* Helper strings for formatting */
    public static final String TAB = "\t";
    public static final String NEXT_LINE = "\n";

    /**
     * Regular expression for checking correct input value from console
     */
    public static final String REGEX_NUMBER = "(\\d+(\\.\\d+)?)";

    /**
     * Separator string, to separate each Aircraft visually
     */
    public static final String SEPARATOR = "_________________________________";

    /**
     * @param message - array of strings for printing
     *                to console without next line symbol.
     */
    public void printMessage(Object... message) {
        for (Object str : message) {
            System.out.print(str);
        }
    }

    /**
     * @param message - array of strings for printing
     *                to console with next line symbol.
     */
    public void printlnMessage(Object... message) {
        for (Object str : message) {
            System.out.println(str);
        }
    }

    /**
     * Printing all fields from {@link com.javaweb.model.entity.Aircraft}
     *
     * @param message parameter message.
     * @param data    the actual parameter.
     */
    public void printWithUnits(String message, Object data) {
        printMessage(TAB, String.format(message, data), NEXT_LINE);
    }
}
