/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */
package week1_1;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
/**
 *
 * @author michiel
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BmiCalculatorTest {
    
    @Test
    public void testCalculateBMI_A() {
        //System.out.println("Testing calculateBMI case 1");
        BmiCalculator instance = new BmiCalculator();
        double weight = 80.0;
        double lenght = 1.80;
        double expResult = (weight / (lenght * lenght));
        double result = instance.calculateBMI(weight, lenght);
        //System.out.println(String.format("...calculating BMI from weight=%.3f & heigth=%.3f: expected BMI=%.3f; given BMI=%.3f", weight, lenght, expResult, result));
        assertEquals(String.format("Testing BMI calculation for weight=%.1f kg and length=%.2fmeter ... ", weight, lenght), expResult, result, 0.001);
    }

    @Test
    public void testCalculateBMI_B() {
        //System.out.println("Testing calculateBMI case 2");
        BmiCalculator instance = new BmiCalculator();
        double weight = 49.0;
        double lenght = 1.56;
        double expResult = (weight / (lenght * lenght));
        double result = instance.calculateBMI(weight, lenght);
        //System.out.println(String.format("...calculating BMI from weight=%.3f & heigth=%.3f: expected BMI=%.3f; given BMI=%.3f", weight, lenght, expResult, result));
        assertEquals(String.format("Testing BMI calculation for weight=%.1f kg and length=%.2fmeter ... ", weight, lenght), expResult, result, 0.001);
    }
    
    @Test//(expected=IllegalArgumentException.class)    
    public void testCalculateBMI_C() {
        //System.out.println("Testing calculateBMI case 3");
        BmiCalculator instance = new BmiCalculator();
        double weight = 80.0;
        double lenght = 0.0;
        try {
            instance.calculateBMI(weight, lenght);
            fail(String.format("Testing BMI calculation for weight=%.1f kg and length=%.2fmeter ... expected %s", weight, lenght, IllegalArgumentException.class.getName()));
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

    @Test//(expected=IllegalArgumentException.class)    
    public void testCalculateBMI_D() {
        //System.out.println("Testing calculateBMI case 4");
        BmiCalculator instance = new BmiCalculator();
        double weight = -10.0;
        double lenght = 1.75;
        try {
            instance.calculateBMI(weight, lenght);
            fail(String.format("Testing BMI calculation for weight=%.1f kg and length=%.2fmeter ... expected %s", weight, lenght, IllegalArgumentException.class.getName()));
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testGetMessage_A() {
        //System.out.println("getMessage");
        double bmi = 17.0;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Ondergewicht";
        String result = instance.getMessage(bmi);
        assertEquals(String.format("Testing BMI message for BMI=%.2f ... ", bmi), expResult, result);
    }
    
    @Test
    public void testGetMessage_B() {
        //System.out.println("getMessage");
        double bmi = 42.50;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Morbide Obesitas";
        String result = instance.getMessage(bmi);
        assertEquals(String.format("Testing BMI message for BMI=%.2f ... ", bmi), expResult, result);
    }

    @Test
    public void testGetMessage_C() {
        //System.out.println("getMessage");
        double bmi = 20.50;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Gezond gewicht";
        String result = instance.getMessage(bmi);
        assertEquals(String.format("Testing BMI message for BMI=%.2f ... ", bmi), expResult, result);
    }

    @Test
    public void testGetMessage_D() {
        //System.out.println("getMessage");
        double bmi = 28.10;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Overgewicht";
        String result = instance.getMessage(bmi);
        assertEquals(String.format("Testing BMI message for BMI=%.2f ... ", bmi), expResult, result);
    }

    @Test
    public void testGetMessage_E() {
        //System.out.println("getMessage");
        double bmi = 39.99;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Obesitas";
        String result = instance.getMessage(bmi);
        assertEquals(String.format("Testing BMI message for BMI=%.2f ... ", bmi), expResult, result);
    }

    @Test//(expected=IllegalArgumentException.class)
    public void testGetMessage_F() {
        //System.out.println("getMessage");
        double bmi = -1.0;
        BmiCalculator instance = new BmiCalculator();
        try {
            instance.getMessage(bmi);
            fail(String.format("Testing BMI message for BMI=%.2f ... expected %s", bmi, IllegalArgumentException.class.getName()));
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
}
