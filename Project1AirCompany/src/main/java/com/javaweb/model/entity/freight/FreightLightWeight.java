package com.javaweb.model.entity.freight;


import com.javaweb.controller.InitializeAirplanes;
/**
 * FreightLightWeight.java
 * <p>
 * Class that contains all basic fields and methods,
 * which is important for light cargo aircraft
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 18 Nov 2016
 */
public class FreightLightWeight extends FreightAirplane {
    /**
     * Is this aircraft people use for skydiving
     */
    private boolean isUsingForJumping;
    /**
     * Is this aircraft people use for post services
     */
    private boolean isPostal;

    /**
     * Constructor with setting {@link #isUsingForJumping}
     * and {@link #isPostal}
     *
     * @param init - initialise values for some airplane
     */
    public FreightLightWeight(InitializeAirplanes init) {
        super(init);
        this.isPostal = init.isPostal();
        this.isUsingForJumping = init.isUsingForJumping();
    }

    public boolean isUsingForJumping() {
        return isUsingForJumping;
    }

    public void setUsingForJumping(boolean usingForJumping) {
        isUsingForJumping = usingForJumping;
    }

    public boolean isPostal() {
        return isPostal;
    }

    public void setPostal(boolean postal) {
        isPostal = postal;
    }
}
