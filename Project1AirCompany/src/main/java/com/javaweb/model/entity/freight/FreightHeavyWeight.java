package com.javaweb.model.entity.freight;


import com.javaweb.controller.InitializeAirplanes;

/**
 * FreightHeavyWeight.java
 * <p>
 * Class that contains all basic fields and methods,
 * which is important for heavy cargo aircraft
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public class FreightHeavyWeight extends FreightAirplane {
    /**
     * total weight, that some unit load device can consist.
     */
    private double unitLoadDeviceCapacity;
    /**
     * total number of unit load devices, that
     * some aircraft can contain
     */
    private double quantityOfULD;

    /**
     * Constructor with setting {@link #unitLoadDeviceCapacity}
     * and {@link #quantityOfULD}
     *
     * @param init - initialise values for some airplane
     */
    public FreightHeavyWeight(InitializeAirplanes init) {
        super(init);
        this.unitLoadDeviceCapacity = init.getUnitLoadDeviceCapacity();
        this.quantityOfULD = init.getQuantityOfULD();
    }

    /**
     * Checking is freight weight correct of not.
     * freight weight of some cargo aircraft should be less than
     * unit load device capacity * quantity of unit load devices
     * @return is correct freight weight or not
     */
    public boolean checkCorrectWeight() {
        return unitLoadDeviceCapacity * quantityOfULD <= getFreightWeight();
    }

    public double getUnitLoadDeviceCapacity() {
        return unitLoadDeviceCapacity;
    }

    public void setUnitLoadDeviceCapacity(double unitLoadDeviceCapacity) {
        this.unitLoadDeviceCapacity = unitLoadDeviceCapacity;
    }

    public double getQuantityOfULD() {
        return quantityOfULD;
    }

    public void setQuantityOfULD(double quantityOfULD) {
        this.quantityOfULD = quantityOfULD;
    }
}
