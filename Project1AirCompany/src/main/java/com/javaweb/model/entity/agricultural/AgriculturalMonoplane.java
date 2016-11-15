package com.javaweb.model.entity.agricultural;


import com.javaweb.controller.InitializeAirplanes;

public class AgriculturalMonoplane extends AgriculturalAirplane {
    private static final double COEFFICIENT_LANDING = 0.75;
    private static final double COEFFICIENT_TAKE_OFF = 0.245;

    public AgriculturalMonoplane(InitializeAirplanes init) {
        super(init);

        setLandingSpeed(init.getLandingSpeed());
        setTakeOffSpeed(init.getTakeOffSpeed());
    }

    @Override
    protected void setLandingSpeed(double speed) {
        this.landingSpeed = COEFFICIENT_LANDING *
                takeOffSpeed - Math.sqrt(Math.PI);
    }

    @Override
    protected void setTakeOffSpeed(double speed) {
        this.takeOffSpeed = COEFFICIENT_TAKE_OFF *
                landingSpeed + Math.sqrt(Math.PI);
    }

    @Override
    protected double getLandingSpeed() {
        return landingSpeed;
    }

    @Override
    protected double getTakeOffSpeed() {
        return takeOffSpeed;
    }
}