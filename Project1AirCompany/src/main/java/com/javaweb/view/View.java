package com.javaweb.view;

/**
 * Created by Dron on 12-Nov-16.
 */
public class View {
    public static final String HEADER =
            "<---------------- Airline company ---------------->";
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
    public static final String ERROR_INPUT  =
            "Error input! You should enter real" +
                    " or int value! Repeat please...";
    public static final String TAB = "\t";
    public static final String NEXT_LINE = "\n";
    public static final String REGEX_NUMBER = "(\\d+(\\.\\d+)?)";

    public static final String NAME_OF_AIRCRAFT = "Name : %s";
    public static final String AIRPLANE_TYPE = "Type of airplane : %s";
    public static final String MANUFACTURER_COUNTRY = "Manufacturer : %s";
    public static final String ENGINE_QUANTITY = "Engine quantity : %d [pcs]";
    public static final String MAX_SPEED = "Max speed : %.1f [km/h]";
    public static final String HAS_PILOT = "Has pilot : %b";
    public static final String PRICE = "price : %d $";
    public static final String FUEL_CONSUMPTION =
            "Specific fuel consumption : %.1f [g/pass-km]";
    public static final String RANGE_OF_FLIGHT =
            "Range of flight : %.1f [km]";
    public static final String PASSENGER_CAPACITY =
            "Passenger capacity : %d [pcs]";
    public static final String CARRYING_CAPACITY =
            "Carrying capacity : %.1f [kg]";
    public static final String AMOUNT_OF_PESTICIDES =
            "Amount of pesticides inside : %.1f [kg]";
    public static final String SPRAYING_AREA_SQUARE =
            "Square of area that can cover : %.1f [square meters]";
    public static final String LANDING_SPEED =
            "Speed of landing : %.1f [km/h]";
    public static final String TAKEOFF_SPEED =
            "Speed of takeoff : %.1f [km/h]";
    public static final String FREIGHT_WEIGHT = "Cargo weight : %.1f [kg]";
    public static final String IS_POSTAL = "Is for post : %b";
    public static final String IS_USING_FOR_JUMPING =
            "Is using for jumping : %b";
    public static final String UNIT_LOAD_DEVICE_CAPACITY =
            "Unit load device capacity : %.1f [kg]";
    public static final String QUANTITY_OF_ULD =
            "Amount of unit load devices : %.1f [pcs]";
    public static final String FUSELAGE_DIAMETER =
            "Fuselage diameter : %.1f [meters]";
    public static final String FUSELAGE_LENGTH =
            "Fuselage length : %.1f [meters]";
    public static final String HAS_WIFI = "Has WiFi : %b";
    public static final String CAPACITY_CARRY_ON_LUGGAGE =
            "Capacity of carry on luggage : %d [kg]";
    public static final String HAS_LUNCH = "Has lunch : %b";
    public static final String QUANTITY_OF_STEWARDESS =
            "Amount of stewardesses : %d [pсs]";
    public static final String COMFORT_QUALITY =
            "Quality of this aircraft : %s";
    public static final String SEPARATOR = "_________________________________";

    public void printMessage(Object... message) {
        for (Object str : message) {
            System.out.print(str);
        }
    }

    public void printlnMessage(Object... message) {
        for (Object str : message) {
            System.out.println(str);
        }
    }

    public void printWithUnits(String message, Object data) {
        printMessage(TAB, String.format(message, data), NEXT_LINE);
    }
}
