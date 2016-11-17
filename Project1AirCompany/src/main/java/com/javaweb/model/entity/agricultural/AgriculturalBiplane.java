package com.javaweb.model.entity.agricultural;


import com.javaweb.controller.InitializeAirplanes;

public class AgriculturalBiplane extends AgriculturalAirplane {
    private static final double COEFFICIENT_LANDING = 1.351;
    private static final double COEFFICIENT_TAKE_OFF = 1.144;

    public AgriculturalBiplane(InitializeAirplanes init) {
        super(init);
        setLandingSpeed(init.getLandingSpeed());
        setTakeOffSpeed(init.getTakeOffSpeed());
    }

    @Override
    protected void setLandingSpeed(double speed) {
        this.landingSpeed = COEFFICIENT_LANDING *
                speed * Math.sqrt(Math.PI);
    }

    @Override
    protected void setTakeOffSpeed(double speed) {
        this.takeOffSpeed = COEFFICIENT_TAKE_OFF *
                speed / Math.sqrt(Math.PI);
    }
}

