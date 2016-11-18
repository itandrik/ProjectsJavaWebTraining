package com.javaweb.model.entity.passenger;

import com.javaweb.controller.InitializeAirplanes;

/**
 * PassengerNarrowFuselage.java
 * <p>
 * Class that contains all basic fields and methods,
 * which is important for passenger airplane with
 * narrow fuselage
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public class PassengerNarrowFuselage extends PassengerAirplane {
    /**
     * Has this airplane wifi or not.
     */
    private boolean hasWifi;
    /**
     * Total capacity of carry on luggage in this airplane
     */
    private int capacityCarryOnLuggage;
    /**
     * Coefficient of carry on capacity, that we need in order to calculate
     * 5-stars airplane
     */
    private static final byte QUANTITY_OF_CARRY_ON_5_STARS = 50;
    /**
     * Coefficient of carry on capacity, that we need in order to calculate
     * 4-stars airplane
     */
    private static final byte QUANTITY_OF_CARRY_ON_4_STARS = 40;
    /**
     * Coefficient of carry on capacity, that we need in order to calculate
     * 3-stars airplane
     */
    private static final byte QUANTITY_OF_CARRY_ON_3_STARS = 30;
    /**
     * Coefficient of carry on capacity, that we need in order to calculate
     * 2-stars airplane
     */
    private static final byte QUANTITY_OF_CARRY_ON_2_STARS = 15;

    /**
     * Constructor with setting {@link #hasWifi}
     * and {@link #capacityCarryOnLuggage}
     *
     * @param init - initialise values for some airplane
     */
    public PassengerNarrowFuselage(InitializeAirplanes init) {
        super(init);
        this.hasWifi = init.hasWifi();
        this.capacityCarryOnLuggage = init.getCapacityCarryOnLuggage();
        checkComfort();
    }

    /**
     * Checking comfort grade in stars and setting
     * this parameter to {@link #comfortGrade}.
     * It is based on {@link #hasWifi} and
     * {@link #capacityCarryOnLuggage}
     */
    @Override
    public void checkComfort() {
        if(hasWifi){
            if(capacityCarryOnLuggage >= QUANTITY_OF_CARRY_ON_5_STARS){
                setComfortGrade(ComfortGrade.FIVE_STAR);
            }else if((capacityCarryOnLuggage >= QUANTITY_OF_CARRY_ON_3_STARS) &&
                    (capacityCarryOnLuggage <= QUANTITY_OF_CARRY_ON_4_STARS)){
                setComfortGrade(ComfortGrade.THREE_STAR);
            }
        }else{
            if((capacityCarryOnLuggage >= QUANTITY_OF_CARRY_ON_2_STARS) &&
                    capacityCarryOnLuggage < QUANTITY_OF_CARRY_ON_4_STARS){
                setComfortGrade(ComfortGrade.TWO_STAR);
            }else if(capacityCarryOnLuggage <= QUANTITY_OF_CARRY_ON_2_STARS){
                setComfortGrade(ComfortGrade.ONE_STAR);
            }else{
                setComfortGrade(ComfortGrade.FOUR_STAR);
            }
        }
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public int getCapacityCarryOnLuggage() {
        return capacityCarryOnLuggage;
    }

    public void setCapacityCarryOnLuggage(int capacityCarryOnLuggage) {
        this.capacityCarryOnLuggage = capacityCarryOnLuggage;
    }

}
