package com.javaweb.model.entity.passenger;


import com.javaweb.controller.InitializeAirplanes;
import com.javaweb.model.entity.Aircraft;

/**
 * PassengerAirplane.java
 * <p>
 * Class that contains all basic fields and functions
 * that any passenger airplane can have
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public abstract class PassengerAirplane extends Aircraft {
    /**
     * Diameter of fuselage in meters
     */
    private double fuselageDiameter;
    /**
     * Length of fuselage in meters
     */
    private double fuselageLength;
    /**
     * Grade of comfort for some passenger airplane in stars.
     */
    private ComfortGrade comfortGrade;
    /**
     * Coefficient, that we need in order to check low
     * diameter limit of wide fuselage
     */
    private static final double FUSELAGE_DIAMETER_WIDE1 = 5.0;
    /**
     * Coefficient, that we need in order to check high
     * diameter limit of wide fuselage
     */
    private static final double FUSELAGE_DIAMETER_WIDE2 = 10.0;
    /**
     * Coefficient, that we need in order to check
     * diameter of narrow fuselage
     */
    private static final double FUSELAGE_DIAMETER_NARROW = 4.0;

    /**
     * Enum class, that contains all 5 grades of comfort
     * and getting string information from them
     */
    protected enum ComfortGrade {
        FIVE_STAR("\u2605\u2605\u2605\u2605\u2605"),
        FOUR_STAR("\u2605\u2605\u2605\u2605"),
        THREE_STAR("\u2605\u2605\u2605"),
        TWO_STAR("\u2605\u2605"),
        ONE_STAR("\u2605");

        private final String starsString;

        ComfortGrade(String starsString) {
            this.starsString = starsString;
        }

        /**
         * @return string with quantity of stars
         */
        public String getStarsString() {
            return starsString;
        }
    }

    /**
     * Abstract method, that all passenger airplanes should
     * implement in order to check comfort grade for some
     * aircraft, according to fields.
     */
    public abstract void checkComfort();

    /**
     * Constructor with setting {@link #fuselageLength}
     * and {@link #fuselageDiameter}
     *
     * @param init - initialise values for some airplane
     */
    public PassengerAirplane(InitializeAirplanes init) {
        super(init);
        this.fuselageDiameter = init.getFuselageDiameter();
        this.fuselageLength = init.getFuselageLength();
    }

    /**
     * Create instance of passenger airplane checking
     * fuselage diameter.
     *
     * @param init initialise values for some airplane
     * @return instance of {@link PassengerAirplane}
     */
    public static PassengerAirplane getInstancePassengerAirplane(
            InitializeAirplanes init) {
        if ((init.getFuselageDiameter() >= FUSELAGE_DIAMETER_WIDE1) &&
                (init.getFuselageDiameter() <= FUSELAGE_DIAMETER_WIDE2)) {
            return new PassengerWideFuselage(init);
        } else if (init.getFuselageDiameter() <= FUSELAGE_DIAMETER_NARROW) {
            return new PassengerNarrowFuselage(init);
        } else {
            return null;
        }
    }

    public double getFuselageDiameter() {
        return fuselageDiameter;
    }

    public void setFuselageDiameter(double fuselageDiameter) {
        this.fuselageDiameter = fuselageDiameter;
    }

    public double getFuselageLength() {
        return fuselageLength;
    }

    public void setFuselageLength(double fuselageLength) {
        this.fuselageLength = fuselageLength;
    }

    public String getComfortGrade() {
        return comfortGrade.getStarsString();
    }

    public void setComfortGrade(ComfortGrade comfortGrade) {
        this.comfortGrade = comfortGrade;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(bundle.getString(
                        "FUSELAGE_DIAMETER"), fuselageDiameter) +
                String.format(bundle.getString(
                        "FUSELAGE_LENGTH"), fuselageLength) +
                String.format(bundle.getString(
                        "COMFORT_QUALITY"), comfortGrade);
    }
}
