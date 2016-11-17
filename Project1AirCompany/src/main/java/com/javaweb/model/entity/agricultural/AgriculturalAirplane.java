package com.javaweb.model.entity.agricultural;


import com.javaweb.model.entity.Aircraft;
import com.javaweb.controller.InitializeAirplanes;

public abstract class AgriculturalAirplane extends Aircraft {
    protected double amountOfPesticides;
    protected double sprayingAreaSquare;
    protected double landingSpeed;
    protected double takeOffSpeed;

    public AgriculturalAirplane(InitializeAirplanes init) {
        super(init);
        this.amountOfPesticides = init.getAmountOfPesticides();
        this.sprayingAreaSquare = init.getSprayingAreaSquare();
    }

    public double getAmountOfPesticides() {
        return amountOfPesticides;
    }

    public void setAmountOfPesticides(double amountOfPesticides) {
        this.amountOfPesticides = amountOfPesticides;
    }

    public double getSprayingAreaSquare() {
        return sprayingAreaSquare;
    }

    public void setSprayingAreaSquare(double sprayingAreaSquare) {
        this.sprayingAreaSquare = sprayingAreaSquare;
    }

    protected abstract void setLandingSpeed(double speed);

    protected abstract void setTakeOffSpeed(double speed);

    public double getLandingSpeed() {
        return landingSpeed;
    }

    public double getTakeOffSpeed() {
        return takeOffSpeed;
    }
}
