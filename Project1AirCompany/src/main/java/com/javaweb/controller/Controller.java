package com.javaweb.controller;

import com.javaweb.model.ModelAirlineCompany;
import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.factory.AgriculturalAirplaneFactory;
import com.javaweb.model.entity.factory.FreightAirplaneFactory;
import com.javaweb.model.entity.factory.PassengerAirplaneFactory;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.freight.FreightHeavyWeight;
import com.javaweb.model.entity.freight.FreightLightWeight;
import com.javaweb.model.entity.passenger.PassengerAirplane;
import com.javaweb.model.entity.passenger.PassengerNarrowFuselage;
import com.javaweb.model.entity.passenger.PassengerWideFuselage;
import com.javaweb.view.View;

import java.util.Scanner;

/**
 * Created by Dron on 12-Nov-16.
 */
public class Controller {
    private View view;
    private ModelAirlineCompany<Aircraft> airlineCompany;
    private Scanner scanner;

    public Controller(View view, ModelAirlineCompany airlineCompany) {
        this.view = view;
        this.airlineCompany = airlineCompany;
        scanner = new Scanner(System.in);
    }

    public void processUser() {
        view.printlnMessage(View.HEADER);
        initializeAirlineCompany();
        view.printlnMessage(View.ALL_AIRPLANES);
        if (airlineCompany.getAllAirplanes().isEmpty()) {
            view.printlnMessage(View.EMPTY_AIRLINE_COMPANY);
        } else {
            airlineCompany.getAllAirplanes().stream()
                    .forEach(this::printAircraftInfo);

            view.printMessage(View.OVERALL_CARRYING_CAPACITY);
            view.printlnMessage(airlineCompany.getOverallCarryingCapacity());

            view.printMessage(View.OVERALL_PASSENGER_CAPACITY);
            view.printlnMessage(airlineCompany.getOverallPassengerCapacity());
        }
        view.printlnMessage(View.ENTER_FUEL_NUMBERS);
        view.printlnMessage(View.LOW_LIMIT_FUEL_CONSUMPTION);
        double lowLimitFuelConsumption = readNumberFromConsole();
        view.printlnMessage(View.HIGH_LIMIT_FUEL_CONSUMPTION);
        double highLimitFuelConsumption = readNumberFromConsole();

        view.printlnMessage(View.FUEL_CONSUMPTION_RESULT);
        airlineCompany.findAircraftWithFuelConsumption(
                lowLimitFuelConsumption, highLimitFuelConsumption).stream()
                .forEach(elem -> view.printlnMessage(elem.getName()));

    }

    private double readNumberFromConsole() {

        while (!scanner.hasNext(View.REGEX_NUMBER)) {
            view.printlnMessage(View.ERROR_INPUT);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void initializeAirlineCompany() {
        for (InitializeAirplanes initValue : InitializeAirplanes.values()) {
            Aircraft aircraft = getAirplaneByType(initValue);
            airlineCompany.addAircraft(aircraft);
        }
    }

    private void printAircraftInfo(Aircraft aircraft) {
        view.printWithUnits(View.NAME_OF_AIRCRAFT, aircraft.getName());
        view.printWithUnits(View.AIRPLANE_TYPE,
                aircraft.getAirplaneType().toString());
        view.printWithUnits(View.MANUFACTURER_COUNTRY,
                aircraft.getManufacturerCountry().toString());
        view.printWithUnits(View.ENGINE_QUANTITY,
                aircraft.getEngineQuantity());
        view.printWithUnits(View.PASSENGER_CAPACITY,
                aircraft.getPassengerCapacity());
        view.printWithUnits(View.CARRYING_CAPACITY,
                aircraft.getCarryingCapacity());
        view.printWithUnits(View.MAX_SPEED, aircraft.getMaxSpeed());
        view.printWithUnits(View.HAS_PILOT, aircraft.isHasPilot());
        view.printWithUnits(View.PRICE, aircraft.getPrice());
        view.printWithUnits(View.FUEL_CONSUMPTION,
                aircraft.getFuelConsumption());
        view.printWithUnits(View.RANGE_OF_FLIGHT,
                aircraft.getRangeOfFlight());

        if (aircraft instanceof AgriculturalAirplane) {
            view.printWithUnits(View.AMOUNT_OF_PESTICIDES,
                    ((AgriculturalAirplane) aircraft).getAmountOfPesticides());
            view.printWithUnits(View.SPRAYING_AREA_SQUARE,
                    ((AgriculturalAirplane) aircraft).getSprayingAreaSquare());
            view.printWithUnits(View.LANDING_SPEED,
                    ((AgriculturalAirplane) aircraft).getLandingSpeed());
            view.printWithUnits(View.TAKEOFF_SPEED,
                    ((AgriculturalAirplane) aircraft).getTakeOffSpeed());
        } else if (aircraft instanceof FreightAirplane) {
            view.printWithUnits(View.FREIGHT_WEIGHT,
                    ((FreightAirplane) aircraft).getFreightWeight());
            if (aircraft instanceof FreightHeavyWeight) {
                view.printWithUnits(View.UNIT_LOAD_DEVICE_CAPACITY,
                        ((FreightHeavyWeight) aircraft).getUnitLoadDeviceCapacity());
                view.printWithUnits(View.QUANTITY_OF_ULD,
                        ((FreightHeavyWeight) aircraft).getQuantityOfULD());
            } else if (aircraft instanceof FreightLightWeight) {
                view.printWithUnits(View.IS_POSTAL,
                        ((FreightLightWeight) aircraft).isPostal());
                view.printWithUnits(View.IS_USING_FOR_JUMPING,
                        ((FreightLightWeight) aircraft).isUsingForJumping());
            }
        } else if (aircraft instanceof PassengerAirplane) {
            view.printWithUnits(View.FUSELAGE_DIAMETER,
                    ((PassengerAirplane) aircraft).getFuselageDiameter());
            view.printWithUnits(View.FUSELAGE_LENGTH,
                    ((PassengerAirplane) aircraft).getFuselageLength());
            view.printWithUnits(View.COMFORT_QUALITY,
                    ((PassengerAirplane) aircraft).getComfortGrade());
            if (aircraft instanceof PassengerWideFuselage) {
                view.printWithUnits(View.QUANTITY_OF_STEWARDESS,
                        ((PassengerWideFuselage) aircraft).getQuantityOfStewardess());
                view.printWithUnits(View.HAS_LUNCH,
                        ((PassengerWideFuselage) aircraft).isHasLunch());
            } else if (aircraft instanceof PassengerNarrowFuselage) {
                view.printWithUnits(View.CAPACITY_CARRY_ON_LUGGAGE,
                        ((PassengerNarrowFuselage) aircraft).getCapacityCarryOnLuggage());
                view.printWithUnits(View.HAS_WIFI,
                        ((PassengerNarrowFuselage) aircraft).isHasWifi());
            }
        }
        view.printlnMessage(View.SEPARATOR);
    }

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
