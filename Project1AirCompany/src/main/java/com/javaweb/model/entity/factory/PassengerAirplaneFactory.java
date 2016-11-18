package com.javaweb.model.entity.factory;

import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;

/**
 * PassengerAirplaneFactory.java
 * <p>
 * Class that creates instance of passenger airplanes, using
 * Abstract factory pattern
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public class PassengerAirplaneFactory implements AircraftFactory {
    /**
     * Stub
     *
     * @param initValues initialise values for aircraft.
     * @return {@link FreightAirplane} instance
     */
    @Override
    public FreightAirplane getFreightAirplane(InitializeAirplanes initValues) {
        return null;
    }

    /**
     * According to airplane type here instance of
     * passenger airplane is creating.
     *
     * @param initValues initialise values for aircraft.
     * @return {@link FreightAirplane} instance
     */
    @Override
    public PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues) {
        switch (initValues.getAirplaneType()) {
            case PASSENGER_NARROW:
                return PassengerAirplane.getInstancePassengerAirplane(initValues);
            case PASSENGER_WIDE:
                return PassengerAirplane.getInstancePassengerAirplane(initValues);
            default:
                return null;
        }
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
