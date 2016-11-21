package com.javaweb.model.entity.factory;

import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;

/**
 * FreightAirplaneFactory.java
 * <p>
 * Class that creates instance of {@link FreightAirplane}
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public class FreightAirplaneFactory implements AircraftFactory {
    /**
     * According to airplane type here instance of
     * cargo airplane is creating.
     *
     * @param initValues initialise values for aircraft.
     * @return {@link FreightAirplane} instance
     */
    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        switch (initValues.getAirplaneType()) {
            case FREIGHT_HEAVY:
                return FreightAirplane.getInstanceFreightAirplane(initValues);
            case FREIGHT_LIGHT:
                return FreightAirplane.getInstanceFreightAirplane(initValues);
            default:
                return null;
        }
    }

    /**
     * Stub
     *
     * @param initValues initialise values for aircraft.
     * @return {@link PassengerAirplane} instance
     */
    @Override
    public PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues) {
        return null;
    }

    /**
     * Stub
     *
     * @param initValues initialise values for aircraft.
     * @return {@link AgriculturalAirplane} instance
     */
    @Override
    public AgriculturalAirplane getAgriculturalAirplane(InitializeAirplanes initValues) {
        return null;
    }
}
