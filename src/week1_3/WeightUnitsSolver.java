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
public class WeightUnitsSolver {
    /**
     * main to be used for testing purposes
     * @param args 
     */
    public static void main(String[] args) {
        WeightUnitsSolver wus = new WeightUnitsSolver();
        wus.convertFromGrams(1000);
    }
    
    /**
     * will return the number of Pounds, Ounces and Grams represented by this quantity of grams, 
     * encapsulated in a BritishWeightUnits object.
     * @param grams
     * @return a BritishWeightUnits instance
     * @throws IllegalArgumentException when the Grams quantity is 
     */
    public BritishWeightUnits convertFromGrams(int grams) {
        return new BritishWeightUnits(0, 0, 0);
    }
}
