/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

/**
 *
 * @author michiel
 */
public class BmiCalculator {
    /**
     * The string messages to accompany BMI categories
     */
    public static final String[] MESSAGES = new String[]{
        "Ondergewicht",
        "Gezond gewicht",
        "Overgewicht",
        "Obesitas",
        "Morbide Obesitas"
    };
    
    /**
     * Returns the BMI given a weight in kilograms and a height in meters.
     * @param weight the weight in kilograms
     * @param lenght the length in kilograms
     * @return bmi the body mass index
     * @throws IllegalArgumentException when illegal (zero or below) values are provided for weight and/or length
     */
    public double calculateBMI(double weight, double lenght) {
        //Gewicht in kilogram / (Lengte in meter * Lengte in meter)
        return 0;
    }
    
    /**
     * Will return an appropriate String representation belonging to a given BMI.
     * 
     * BMI index    Categorie
     * &lt;18.5     Ondergewicht
     * 18.5 - 25.0  Gezond gewicht
     * 25.0 - 30.0  Overgewicht
     * 30.0 - 40.0  Obesitas
     * &gt;40       Morbide Obesitas
     * 
     * @param bmi the BMI
     * @return message
     * @throws IllegalArgumentException when illegal (zero or below) BMI value is provided
     */
    public String getMessage(double bmi) {
        return null;
    }
}
