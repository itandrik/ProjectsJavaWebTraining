package com.javaweb.model.entity.factory;


import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;

/**
 * AircraftFactory.java
 * <p>
 * Interface that we need to implement Abstract Factory pattern
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public interface AircraftFactory {
    /**
     * Creating instance of {@link FreightAirplane}
     *
     * @param initValues initialise values for some Aircraft
     * @return instance of {@link FreightAirplane}
     */
    FreightAirplane getFreightAirplane(InitializeAirplanes initValues);

    /**
     * Creating instance of {@link PassengerAirplane}
     *
     * @param initValues initialise values for some Aircraft
     * @return instance of {@link PassengerAirplane}
     */
    PassengerAirplane getPassengerAirplane(InitializeAirplanes initValues);

    /**
     * Creating instance of {@link AgriculturalAirplane}
     *
     * @param initValues initialise values for some Aircraft
     * @return instance of {@link AgriculturalAirplane}
     */
    AgriculturalAirplane getAgriculturalAirplane(
            InitializeAirplanes initValues);
}
