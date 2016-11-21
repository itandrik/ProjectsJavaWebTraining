package com.javaweb.model.entity.passenger;

import com.javaweb.controller.InitializeAirplanes;

/**
 * PassengerWideFuselage.java
 * <p>
 * Class that contains all basic fields and methods,
 * which is important for passenger airplane with
 * wide fuselage
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public class PassengerWideFuselage extends PassengerAirplane {
    /**
     * Has this aircraft lunch during flight or not.
     */
    private boolean hasLunch;
    /**
     * Number of stewardesses in the airplane
     */
    private int quantityOfStewardess;
    /**
     * Coefficient of stewardess quantity,
     * that we need in order to calculate 5-stars airplane
     */
    private static final byte QUANTITY_OF_STEWARDESS_5_STARS = 10;
    /**
     * Coefficient of stewardess quantity,
     * that we need in order to calculate 4-stars airplane
     */
    private static final byte QUANTITY_OF_STEWARDESS_4_STARS = 7;
    /**
     * Coefficient of stewardess quantity,
     * that we need in order to calculate 3-stars airplane
     */
    private static final byte QUANTITY_OF_STEWARDESS_3_STARS = 5;
    /**
     * Coefficient of stewardess quantity,
     * that we need in order to calculate 2-stars airplane
     */
    private static final byte QUANTITY_OF_STEWARDESS_2_STARS = 3;

    /**
     * Constructor with setting {@link #quantityOfStewardess}
     * and {@link #hasLunch}
     *
     * @param init - initialise values for some airplane
     */
    public PassengerWideFuselage(InitializeAirplanes init) {
        super(init);
        this.hasLunch = init.hasLunch();
        this.quantityOfStewardess = init.getQuantityOfStewardess();
        checkComfort();
    }

    public boolean isHasLunch() {
        return hasLunch;
    }

    public void setHasLunch(boolean hasLunch) {
        this.hasLunch = hasLunch;
    }

    public int getQuantityOfStewardess() {
        return quantityOfStewardess;
    }

    public void setQuantityOfStewardess(int quantityOfStewardess) {
        this.quantityOfStewardess = quantityOfStewardess;
    }

    /**
     * Checking comfort grade in stars and setting
     * this parameter to {@link #comfortGrade}.
     * It is based on {@link #hasLunch} and
     * {@link #quantityOfStewardess}
     */
    @Override
    public void checkComfort() {
        if (hasLunch) {
            if (quantityOfStewardess >= QUANTITY_OF_STEWARDESS_5_STARS) {
                setComfortGrade(ComfortGrade.FIVE_STAR);
            } else if (quantityOfStewardess >= QUANTITY_OF_STEWARDESS_4_STARS) {
                setComfortGrade(ComfortGrade.FOUR_STAR);
            } else if (quantityOfStewardess >= QUANTITY_OF_STEWARDESS_3_STARS) {
                setComfortGrade(ComfortGrade.THREE_STAR);
            } else {
                setComfortGrade(ComfortGrade.ONE_STAR);
            }
        } else if ((quantityOfStewardess >= QUANTITY_OF_STEWARDESS_3_STARS) &&
                (quantityOfStewardess <= QUANTITY_OF_STEWARDESS_2_STARS)) {
            setComfortGrade(ComfortGrade.TWO_STAR);
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(bundle.getString(
                        "HAS_LUNCH"), hasLunch) +
                String.format(bundle.getString(
                        "QUANTITY_OF_STEWARDESS"), quantityOfStewardess);
    }
}