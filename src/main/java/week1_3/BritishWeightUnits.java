/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package week1_3;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class BritishWeightUnits {
    private final int pounds;
    private final int ounces;
    private final int grams;

    /**
     * constructs with relevant coins
     * @param pounds
     * @param ounces
     * @param grams 
     */
    public BritishWeightUnits(int pounds, int ounces, int grams) {
        this.pounds = pounds;
        this.ounces = ounces;
        this.grams = grams;
    }

    /**
     * returns the pounds
     * @return pounds
     */
    public int getPounds() {
        return pounds;
    }

    /**
     * returns the ounces
     * @return ounces
     */
    public int getOunces() {
        return ounces;
    }

    /**
     * returns the grams
     * @return grams
     */
    public int getGrams() {
        return grams;
    }

    @Override
    public String toString() {
        return "BritishUnitsCoins{" + "pounds=" + pounds + ", ounces=" + ounces + ", grams=" + grams + '}';
    }

}
