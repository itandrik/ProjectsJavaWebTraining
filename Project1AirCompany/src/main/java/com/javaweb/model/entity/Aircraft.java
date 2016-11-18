package com.javaweb.model.entity;

import com.javaweb.controller.InitializeAirplanes;

/**
 * Created by Dron on 13-Nov-16.
 */
public abstract class Aircraft {
    private String name;
    //private //double weight;
    private AirplaneType airplaneType;
    private ManufacturerCountry manufacturerCountry;
    private int engineQuantity;//Inner class with engine
    private double maxSpeed;
    private boolean hasPilot;
    private long price;
    private double fuelConsumption;
    private double rangeOfFlight;
    private int passengerCapacity;
    private double carryingCapacity;

    /**
     * Created by Dron on 13-Nov-16.
     */
    public enum ManufacturerCountry {
        USSR, FRANCE, USA, GERMANY
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;

        Aircraft aircraft = (Aircraft) o;

        if (getEngineQuantity() != aircraft.getEngineQuantity()) return false;
        if (Double.compare(aircraft.getMaxSpeed(), getMaxSpeed()) != 0) return false;
        if (isHasPilot() != aircraft.isHasPilot()) return false;
        if (getPrice() != aircraft.getPrice()) return false;
        if (Double.compare(aircraft.getFuelConsumption(), getFuelConsumption()) != 0) return false;
        if (Double.compare(aircraft.getRangeOfFlight(), getRangeOfFlight()) != 0) return false;
        if (getPassengerCapacity() != aircraft.getPassengerCapacity()) return false;
        if (Double.compare(aircraft.getCarryingCapacity(), getCarryingCapacity()) != 0) return false;
        if (getName() != null ? !getName().equals(aircraft.getName()) : aircraft.getName() != null) return false;
        if (getAirplaneType() != aircraft.getAirplaneType()) return false;
        return getManufacturerCountry() == aircraft.getManufacturerCountry();

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAirplaneType() != null ? getAirplaneType().hashCode() : 0);
        result = 31 * result + (getManufacturerCountry() != null ? getManufacturerCountry().hashCode() : 0);
        result = 31 * result + getEngineQuantity();
        temp = Double.doubleToLongBits(getMaxSpeed());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isHasPilot() ? 1 : 0);
        result = 31 * result + (int) (getPrice() ^ (getPrice() >>> 32));
        temp = Double.doubleToLongBits(getFuelConsumption());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getRangeOfFlight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getPassengerCapacity();
        temp = Double.doubleToLongBits(getCarryingCapacity());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}