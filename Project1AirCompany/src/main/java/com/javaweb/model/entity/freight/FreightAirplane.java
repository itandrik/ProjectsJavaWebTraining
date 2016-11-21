package com.javaweb.model.entity.freight;


import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.Aircraft;

/**
 * FreightAirplane.java
 * <p>
 * Class that contains all basic fields and functions
 * that any cargo airplane can have
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public abstract class FreightAirplane extends Aircraft {
    /**
     * Weight, that some cargo airplane can consist
     */
    private double freightWeight;
    /**
     * Coefficient that defines heavy aircraft
     */
    private static final int WEIGHT_OF_HEAVY_AIRCRAFT = 136;
    /**
     * Coefficient that defines light aircraft
     */
    private static final int WEIGHT_OF_LIGHT_AIRCRAFT = 7;

    /**
     * Constructor with setting {@link #freightWeight}
     *
     * @param init - initialise values for some airplane
     */
    public FreightAirplane(InitializeAirplanes init) {
        super(init);
        this.freightWeight = init.getFreightWeight();
    }

    /**
     * Create instance of cargo airplane checking freight weight
     *
     * @param init initialise values for some airplane
     * @return instance of {@link FreightAirplane}
     */
    public static FreightAirplane getInstanceFreightAirplane(
            InitializeAirplanes init) {
        if (init.getFreightWeight() >= WEIGHT_OF_HEAVY_AIRCRAFT) {
            return new FreightHeavyWeight(init);
        } else if (init.getFreightWeight() <= WEIGHT_OF_LIGHT_AIRCRAFT) {
            return new FreightLightWeight(init);
        } else {
            return null;
        }
    }

    public double getFreightWeight() {
        return freightWeight;
    }

    public void setFreightWeight(double freightWeight) {
        this.freightWeight = freightWeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(bundle.getString("FREIGHT_WEIGHT"), freightWeight);
    }
}
