package com.javaweb.controller;

import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.AirplaneType;


public enum InitializeAirplanes {
    AN_2СХ(AirplaneType.AGRICULTURAL_BIPLANE,
            Aircraft.ManufacturerCountry.USSR, 1, 254, true, 2000,
            42.0/*140*/, 900, 1, 1980, 1400, 30, 236, 155, -1, false, false,
            -1, -1, -1, -1, false, -1, false, -1),
    CESSNA_188(AirplaneType.AGRICULTURAL_MONOPLANE,
            Aircraft.ManufacturerCountry.USA, 1, 195, true, 16000,
            39.3/*160*/, 628, 1, 921, 835, 25, 150, 183, -1, false, false,
            -1, -1, -1, -1, false, -1, false, -1),
    Airbus_A310_200С(AirplaneType.FREIGHT_HEAVY,
            Aircraft.ManufacturerCountry.FRANCE, 4, 860, true, 15032412,
            19.1/*1225*/, 6500, 10, 134000, -1, -1, -1, -1, 32834, false,
            false, 4004, 8, -1, -1, false, -1, false, -1),
    ALBATROS_L_72(AirplaneType.FREIGHT_LIGHT,
            Aircraft.ManufacturerCountry.GERMANY, 1, 160, true, 10454, 41.3,
            931, 4, 700, -1, -1, -1, -1, 700, false, true, 700, 1, -1, -1,
            false, -1, false, -1),
    BOEING_747(AirplaneType.PASSENGER_WIDE, Aircraft.ManufacturerCountry.USA,
            4, 988, true, 1231235434, /*2600*/25.5, 14815.0, 1048, 26100, -1,
            -1, -1, -1, -1, false, false, -1, -1, 6.5, 76.3, false, -1, true,
            10),
    TU_154(AirplaneType.PASSENGER_NARROW, Aircraft.ManufacturerCountry.USSR,
            3, 950, true, 35000000,/*5300*/27.5, 2650, 180, 18000, -1, -1,
            -1, -1, -1, false, false, -1, -1, 3.8, 47.9, false, 3000,
            false, 5);


    private final AirplaneType airplaneType;
    private final Aircraft.ManufacturerCountry manufacturerCountry;
    private final int engineQuantity;
    private final double maxSpeed;
    private final boolean hasPilot;
    private final long price;
    private final double fuelConsumption;
    private final double rangeOfFlight;
    private final int passengerCapacity;
    private final double carryingCapacity;
    private final double amountOfPesticides;
    private final double sprayingAreaSquare;
    private final double landingSpeed;
    private final double takeOffSpeed;
    private final double freightWeight;
    private final boolean isPostal;
    private final boolean isUsingForJumping;
    private final double unitLoadDeviceCapacity;
    private final double quantityOfULD;
    private final double fuselageDiameter;
    private final double fuselageLength;
    private final boolean hasWifi;
    private final int capacityCarryOnLuggage;
    private final boolean hasLunch;
    private final int quantityOfStewardess;


    InitializeAirplanes(AirplaneType airplaneType,
                        Aircraft.ManufacturerCountry manufacturerCountry,
                        int engineQuantity, double maxSpeed, boolean hasPilot,
                        long price, double fuelConsumption,
                        double rangeOfFlight, int passengerCapacity,
                        double carryingCapacity, double amountOfPesticides,
                        double sprayingAreaSquare, double landingSpeed,
                        double takeOffSpeed, double freightWeight,
                        boolean isUsingForJumping, boolean isPostal,
                        double unitLoadDeviceCapacity, double quantityOfULD,
                        double fuselageDiameter, double fuselageLength,
                        boolean hasWifi, int capacityCarryOnLuggage,
                        boolean hasLunch, int quantityOfStewardess) {
        this.airplaneType = airplaneType;
        this.manufacturerCountry = manufacturerCountry;
        this.engineQuantity = engineQuantity;
        this.maxSpeed = maxSpeed;
        this.hasPilot = hasPilot;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.rangeOfFlight = rangeOfFlight;
        this.passengerCapacity = passengerCapacity;
        this.carryingCapacity = carryingCapacity;
        this.amountOfPesticides = amountOfPesticides;
        this.sprayingAreaSquare = sprayingAreaSquare;
        this.landingSpeed = landingSpeed;
        this.takeOffSpeed = takeOffSpeed;
        this.freightWeight = freightWeight;
        this.isPostal = isPostal;
        this.isUsingForJumping = isUsingForJumping;
        this.unitLoadDeviceCapacity = unitLoadDeviceCapacity;
        this.quantityOfULD = quantityOfULD;
        this.fuselageDiameter = fuselageDiameter;
        this.fuselageLength = fuselageLength;
        this.hasWifi = hasWifi;
        this.capacityCarryOnLuggage = capacityCarryOnLuggage;
        this.hasLunch = hasLunch;
        this.quantityOfStewardess = quantityOfStewardess;
    }

    public Aircraft.ManufacturerCountry getManufacturerCountry() {
        return manufacturerCountry;
    }

    public int getEngineQuantity() {
        return engineQuantity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean hasPilot() {
        return hasPilot;
    }

    public long getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public double getAmountOfPesticides() {
        return amountOfPesticides;
    }

    public double getSprayingAreaSquare() {
        return sprayingAreaSquare;
    }

    public double getLandingSpeed() {
        return landingSpeed;
    }

    public double getTakeOffSpeed() {
        return takeOffSpeed;
    }

    public double getFreightWeight() {
        return freightWeight;
    }

    public boolean isPostal() {
        return isPostal;
    }

    public boolean isUsingForJumping() {
        return isUsingForJumping;
    }

    public double getUnitLoadDeviceCapacity() {
        return unitLoadDeviceCapacity;
    }

    public double getQuantityOfULD() {
        return quantityOfULD;
    }

    public double getFuselageDiameter() {
        return fuselageDiameter;
    }

    public double getFuselageLength() {
        return fuselageLength;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public int getCapacityCarryOnLuggage() {
        return capacityCarryOnLuggage;
    }

    public boolean hasLunch() {
        return hasLunch;
    }

    public int getQuantityOfStewardess() {
        return quantityOfStewardess;
    }
}
