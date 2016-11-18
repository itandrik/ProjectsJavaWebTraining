package com.javaweb.model.entity.factory;

import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.agricultural.AgriculturalBiplane;
import com.javaweb.model.entity.agricultural.AgriculturalMonoplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;

/**
 * AgriculturalAirplaneFactory.java
 * <p>
 * Class that creates instance of agricultural airplanes, using
 * Abstract factory pattern
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public class AgriculturalAirplaneFactory implements AircraftFactory {

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
     * According to airplane type here instance of
     * Agricultural airplane is creating.
     *
     * @param initValues initialise values for aircraft.
     * @return {@link FreightAirplane} instance
     */
    @Override
    public AgriculturalAirplane getAgriculturalAirplane(
            InitializeAirplanes initValues) {
        switch (initValues.getAirplaneType()) {
            case AGRICULTURAL_BIPLANE:
                return new AgriculturalBiplane(initValues);
            case AGRICULTURAL_MONOPLANE:
                return new AgriculturalMonoplane(initValues);
            default:
                return null;
        }
    }
}
