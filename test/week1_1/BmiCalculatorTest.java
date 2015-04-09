/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_1;


import week1_1.BmiCalculator;
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
    
    public BmiCalculatorTest() {
    }

    /**
     * Test of calculateBMI method, of class BmiCalculator.
     */
    @Test
    public void testCalculateBMI_A() {
        //System.out.println("Testing calculateBMI case 1");
        BmiCalculator instance = new BmiCalculator();
        double weight = 80.0;
        double lenght = 1.80;
        double expResult = (weight / (lenght * lenght));
        double result = instance.calculateBMI(weight, lenght);
        //System.out.println(String.format("...calculating BMI from weight=%.3f & heigth=%.3f: expected BMI=%.3f; given BMI=%.3f", weight, lenght, expResult, result));
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calculateBMI method, of class BmiCalculator.
     */
    @Test
    public void testCalculateBMI_B() {
        //System.out.println("Testing calculateBMI case 2");
        BmiCalculator instance = new BmiCalculator();
        double weight = 49.0;
        double lenght = 1.56;
        double expResult = (weight / (lenght * lenght));
        double result = instance.calculateBMI(weight, lenght);
        //System.out.println(String.format("...calculating BMI from weight=%.3f & heigth=%.3f: expected BMI=%.3f; given BMI=%.3f", weight, lenght, expResult, result));
        assertEquals(expResult, result, 0.001);
    }
    
    @Test(expected=IllegalArgumentException.class)    
    public void testCalculateBMI_C() {
        //System.out.println("Testing calculateBMI case 3");
        BmiCalculator instance = new BmiCalculator();
        double weight = 80.0;
        double lenght = 0.0;
        instance.calculateBMI(weight, lenght);
    }

    @Test(expected=IllegalArgumentException.class)    
    public void testCalculateBMI_D() {
        //System.out.println("Testing calculateBMI case 4");
        BmiCalculator instance = new BmiCalculator();
        double weight = -10.0;
        double lenght = 1.75;
        instance.calculateBMI(weight, lenght);
    }
    
    @Test
    public void testGetMessage_A() {
        //System.out.println("getMessage");
        double bmi = 17.0;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Ondergewicht";
        String result = instance.getMessage(bmi);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMessage_B() {
        //System.out.println("getMessage");
        double bmi = 42.50;
        BmiCalculator instance = new BmiCalculator();
        String expResult = "Morbide Obesitas";
        String result = instance.getMessage(bmi);
        assertEquals(expResult, result);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testGetMessage_C() {
        //System.out.println("getMessage");
        double bmi = -1.0;
        BmiCalculator instance = new BmiCalculator();
        instance.getMessage(bmi);
    }
}
