package com.javaweb.model.entity;

import com.javaweb.controller.InitializeAirplanes;

/**
 * Aircraft.java
 * <p>
 * Abstract class that is parent for all
 * airplanes in this factory. Here are initialization
 * of all basic parameters of airplane.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public abstract class Aircraft {
    /**
     * Name of some airplane
     */
    private String name;
    /**
     * Type of airplane from hierarchy {@link AirplaneType}
     */
    private AirplaneType airplaneType;
    /**
     * Country, that produced airplane {@link ManufacturerCountry}
     */
    private ManufacturerCountry manufacturerCountry;
    /**
     * Amount of engines, that airplane can have
     */
    private int engineQuantity;
    /**
     * Maximal speed of airplane
     */
    private double maxSpeed;
    /**
     * Is this aircraft has pilot or not
     */
    private boolean hasPilot;
    /**
     * Price of aircraft in dollars
     */
    private long price;
    /**
     * Fuel consumption of aircraft in g/pass-km
     */
    private double fuelConsumption;
    /**
     * Range, that airplane can fly in km
     */
    private double rangeOfFlight;
    /**
     * Total passenger capacity in aircraft
     */
    private int passengerCapacity;
    /**
     * Total carrying capacity in aircraft
     */
    private double carryingCapacity;

    /**
     * Enum class, that defines all countries, that can
     * produce some aircraft
     */
    public enum ManufacturerCountry {
        USSR, FRANCE, USA, GERMANY
    }

    /**
     * Constructor, that initialise all fields using
     * parameter init.
     *
     * @param init - initialise values for some airplane
     */
    public Aircraft(InitializeAirplanes init) {
        setName(init.name());
        setAirplaneType(init.getAirplaneType());
        setManufacturerCountry(init.getManufacturerCountry());
        setEngineQuantity(init.getEngineQuantity());
        setPassengerCapacity(init.getPassengerCapacity());
        setCarryingCapacity(init.getCarryingCapacity());
        setMaxSpeed(init.getMaxSpeed());
        setHasPilot(init.hasPilot());
        setPrice(init.getPrice());
        setFuelConsumption(init.getFuelConsumption());
        setRangeOfFlight(init.getRangeOfFlight());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturerCountry(ManufacturerCountry manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public void setEngineQuantity(int engineQuantity) {
        this.engineQuantity = engineQuantity;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setHasPilot(boolean hasPilot) {
        this.hasPilot = hasPilot;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setRangeOfFlight(double rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getName() {
        return name;
    }

    public ManufacturerCountry getManufacturerCountry() {
        return manufacturerCountry;
    }

    public int getEngineQuantity() {
        return engineQuantity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isHasPilot() {
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
}