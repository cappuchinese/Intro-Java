/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */
package week1_3;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WeightUnitsSolverTest {
    
    /**
     * Test of convertFromGrams method, of class WeightUnitsSolver.
     */
    @Test
    public void testConvertFromGrams_A() {
        int grams = 1;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        BritishWeightUnits expResult = new BritishWeightUnits(0, 0, 1);
        BritishWeightUnits result = instance.convertFromGrams(grams);
        assertEquals(expResult.getPounds(), result.getPounds());
        assertEquals(expResult.getOunces(), result.getOunces());
        assertEquals(expResult.getGrams(), result.getGrams());
    }

    /**
     * Test of convertFromGrams method, of class WeightUnitsSolver.
     */
    @Test
    public void testConvertFromGrams_B() {
        int grams = 1000;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        BritishWeightUnits expResult = new BritishWeightUnits(2, 3, 8);
        BritishWeightUnits result = instance.convertFromGrams(grams);
        assertEquals(expResult.getPounds(), result.getPounds());
        assertEquals(expResult.getOunces(), result.getOunces());
        assertEquals(expResult.getGrams(), result.getGrams());
    }

    /**
     * Test of convertFromGrams method, of class WeightUnitsSolver.
     */
    @Test
    public void testConvertFromGrams_C() {
        int grams = 25369;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        BritishWeightUnits expResult = new BritishWeightUnits(55, 14, 7);
        BritishWeightUnits result = instance.convertFromGrams(grams);
        assertEquals(expResult.getPounds(), result.getPounds());
        assertEquals(expResult.getOunces(), result.getOunces());
        assertEquals(expResult.getGrams(), result.getGrams());
    }
    
    @Test(expected=IllegalArgumentException.class)    
    public void testConvertFromGrams_D() {
        int grams = -1;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        instance.convertFromGrams(grams);
    }

}
