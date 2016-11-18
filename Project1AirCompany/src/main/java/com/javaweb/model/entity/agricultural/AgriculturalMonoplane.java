package com.javaweb.model.entity.agricultural;


import com.javaweb.controller.InitializeAirplanes;

public class AgriculturalMonoplane extends AgriculturalAirplane {
    /**
     * Coefficient, that we need in order to calculate
     * landing speed for monoplane.
     */
    private static final double COEFFICIENT_LANDING = 0.75;
    /**
     * Coefficient, that we need in order to calculate
     * takeoff speed for monoplane.
     */
    private static final double COEFFICIENT_TAKE_OFF = 0.245;

    /**
     * Constructor, that is needed to create instance of
     * monoplane. Here are calculating of landing and take of speed,
     * using init speeds.
     *
     * @param init initialise values
     */
    public AgriculturalMonoplane(InitializeAirplanes init) {
        super(init);

        setLandingSpeed(init.getLandingSpeed());
        setTakeOffSpeed(init.getTakeOffSpeed());
    }

    /**
     *
     * @param speed speed of landing from init value
     */
    @Override
    protected void setLandingSpeed(double speed) {
        this.landingSpeed = COEFFICIENT_LANDING *
                speed - Math.sqrt(Math.PI);
    }

    /**
     *
     * @param speed speed of takeoff from init value
     */
    @Override
    protected void setTakeOffSpeed(double speed) {
        this.takeOffSpeed = COEFFICIENT_TAKE_OFF *
                speed + Math.sqrt(Math.PI);
    }
}
