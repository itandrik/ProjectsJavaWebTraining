package com.javaweb.model.entity.agricultural;


import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.Aircraft;

/**
 * AgriculturalAirplane.java
 * <p>
 * Class that contains all basic fields and functions
 * that any agricultural airplane can have
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public abstract class AgriculturalAirplane extends Aircraft {
    /**
     * Total number of pesticides, that airplane can contain
     */
    private double amountOfPesticides;
    /**
     * Total are, that airplane can cover during spraying
     */
    private double sprayingAreaSquare;
    /**
     * Speed of landing
     */
    protected double landingSpeed;
    /**
     * Speed to take off
     */
    protected double takeOffSpeed;

    /**
     * Constructor to create instance of any agricultural
     * airplane.
     *
     * @param init - values with all data, that we need
     */
    public AgriculturalAirplane(InitializeAirplanes init) {
        super(init);
        this.amountOfPesticides = init.getAmountOfPesticides();
        this.sprayingAreaSquare = init.getSprayingAreaSquare();
    }

    public void setAmountOfPesticides(double amountOfPesticides) {
        this.amountOfPesticides = amountOfPesticides;
    }

    public void setSprayingAreaSquare(double sprayingAreaSquare) {
        this.sprayingAreaSquare = sprayingAreaSquare;
    }

    /**
     * All agricultural airplanes' landing speed should be
     * calculated by different formulas
     *
     * @param speed speed of landing from init value
     */
    protected abstract void setLandingSpeed(double speed);

    /**
     * All agricultural airplanes' takeoff speed should be
     * calculated by different formulas
     *
     * @param speed speed of takeoff from init value
     */
    protected abstract void setTakeOffSpeed(double speed);

    public double getLandingSpeed() {
        return landingSpeed;
    }

    public double getTakeOffSpeed() {
        return takeOffSpeed;
    }

    public double getSprayingAreaSquare() {
        return sprayingAreaSquare;
    }

    public double getAmountOfPesticides() {
        return amountOfPesticides;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(bundle.getString("AMOUNT_OF_PESTICIDES"), amountOfPesticides) +
                String.format(bundle.getString("SPRAYING_AREA_SQUARE"), sprayingAreaSquare) +
                String.format(bundle.getString("LANDING_SPEED"), landingSpeed) +
                String.format(bundle.getString("TAKEOFF_SPEED"), takeOffSpeed);
    }
}
