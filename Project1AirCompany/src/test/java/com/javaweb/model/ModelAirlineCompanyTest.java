package com.javaweb.model;

import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.Aircraft;
import com.javaweb.model.entity.agricultural.AgriculturalAirplane;
import com.javaweb.model.entity.factory.AgriculturalAirplaneFactory;
import com.javaweb.model.entity.factory.AircraftFactory;
import com.javaweb.model.entity.factory.FreightAirplaneFactory;
import com.javaweb.model.entity.factory.PassengerAirplaneFactory;
import com.javaweb.model.entity.freight.FreightAirplane;
import com.javaweb.model.entity.passenger.PassengerAirplane;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ModelAirlineCompanyTest {
    private ModelAirlineCompany<Aircraft> airlineCompany;

    @Before
    public void setUp() {
        airlineCompany = new ModelAirlineCompany<>();
    }

    @Test
    public void addAircraft() {
        AircraftFactory factory = new AgriculturalAirplaneFactory();
        AgriculturalAirplane corncob =
                factory.getAgriculturalAirplane(InitializeAirplanes.AN_2СХ);
        airlineCompany.addAircraft(corncob);
        Assert.assertSame(airlineCompany.getAllAirplanes().get(0), corncob);
    }

    @Test
    public void removeAircraft() {
        AircraftFactory factory = new PassengerAirplaneFactory();
        PassengerAirplane boeing =
                factory.getPassengerAirplane(InitializeAirplanes.BOEING_747);
        airlineCompany.addAircraft(boeing);
        airlineCompany.addAircraft(boeing);
        airlineCompany.removeAircraft(boeing);
        Assert.assertEquals(airlineCompany.getAllAirplanes().size(), 1);
    }

    @Test
    public void getOverallPassengerCapacity() {
        AircraftFactory factory = new PassengerAirplaneFactory();
        PassengerAirplane passengerAirplane =
                factory.getPassengerAirplane(InitializeAirplanes.BOEING_747);
        airlineCompany.addAircraft(passengerAirplane);
        passengerAirplane = factory.getPassengerAirplane(InitializeAirplanes.TU_154);
        airlineCompany.addAircraft(passengerAirplane);
        Assert.assertEquals(airlineCompany.getOverallPassengerCapacity(), 1228);
    }

    @Test
    public void getOverallCarryingCapacity() {
        AircraftFactory factory = new FreightAirplaneFactory();
        FreightAirplane freightAirplane =
                factory.getFreightAirplane(InitializeAirplanes.Airbus_A310_200С);
        airlineCompany.addAircraft(freightAirplane);
        freightAirplane = factory.getFreightAirplane(InitializeAirplanes.ALBATROS_L_72);
        airlineCompany.addAircraft(freightAirplane);
        Assert.assertTrue(airlineCompany.getOverallCarryingCapacity() == 134700);
    }

    @Test
    public void findAircraftWithFuelConsumption() {
        AircraftFactory factory = new PassengerAirplaneFactory();
        PassengerAirplane passengerAirplane =
                factory.getPassengerAirplane(InitializeAirplanes.BOEING_747);
        airlineCompany.addAircraft(passengerAirplane);
        passengerAirplane = factory.getPassengerAirplane(InitializeAirplanes.TU_154);
        airlineCompany.addAircraft(passengerAirplane);
        Assert.assertArrayEquals(airlineCompany
                        .findAircraftWithFuelConsumption(26, 30).toArray(),
                new Aircraft[]{passengerAirplane});
    }

    @Test
    public void getAllAirplanes() {
        AircraftFactory factory = new FreightAirplaneFactory();
        FreightAirplane airbus =
                factory.getFreightAirplane(InitializeAirplanes.Airbus_A310_200С);
        airlineCompany.addAircraft(airbus);
        FreightAirplane albatros =
                factory.getFreightAirplane(InitializeAirplanes.ALBATROS_L_72);
        airlineCompany.addAircraft(albatros);
        Assert.assertArrayEquals(airlineCompany
                        .getAllAirplanes().toArray(),
                new Aircraft[]{albatros, airbus});
    }
}