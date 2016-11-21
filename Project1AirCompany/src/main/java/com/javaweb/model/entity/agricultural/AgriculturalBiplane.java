package com.javaweb.model.entity.agricultural;


import com.javaweb.controller.InitializeAirplanes;

/**
 * AgriculturalBiplane.java
 * <p>
 * Class that contains all basic fields and functions
 * that any agricultural plane with 2 wings can have
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public class AgriculturalBiplane extends AgriculturalAirplane {
    /**
     * Coefficient, that we need in order to calculate
     * landing speed for biplane.
     */
    private static final double COEFFICIENT_LANDING = 1.351;
    /**
     * Coefficient, that we need in order to calculate
     * takeoff speed for biplane.
     */
    private static final double COEFFICIENT_TAKE_OFF = 1.144;

    /**
     * Constructor, that is needed to create instance of
     * biplane. Here are calculating of landing and take of speed,
     * using init speeds
     *
     * @param init initialise values
     */
    public AgriculturalBiplane(InitializeAirplanes init) {
        super(init);
        setLandingSpeed(init.getLandingSpeed());
        setTakeOffSpeed(init.getTakeOffSpeed());
    }

    /**
     * @param speed speed of landing from init value
     */
    @Override
    protected void setLandingSpeed(double speed) {
        this.landingSpeed = COEFFICIENT_LANDING *
                speed * Math.sqrt(Math.PI);
    }

    /**
     * @param speed speed of takeoff from init value
     */
    @Override
    protected void setTakeOffSpeed(double speed) {
        this.takeOffSpeed = COEFFICIENT_TAKE_OFF *
                speed / Math.sqrt(Math.PI);
    }

}

