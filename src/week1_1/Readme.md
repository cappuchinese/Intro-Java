# Calculating the BMI  #

## Learning outcomes ##
* working with NetBeans 
* getting to know Java syntax and types
* working with user input

## Assignment details ##
In this assignment you will need to create functionality that calculates a BMI based on weight and height.  
Also, given a BMI, you will need to translate this into an appropriate textual label.  
To achieve this goal you have to write implementations for the given method stubs in class BmiCalculator.
One method, calculateBMI(), can be used to calculate the BMI of a person by asking the user for their weight and height.  
The other, getMessage(), can be used to convert a BMI value into an appropriate textual label.  
  
The main() method is already implemented, making it possible to use this class as a simple actual program. 
Run it by selecting "Run file" from the context menu. 

The string labels are already provided for you -- you must use these!
```Java
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
```

For this assignment you will need to get user input. 
In Java this can be achieved (amongst other means) by using the Scanner class to read from the console, like so:
```Java
Scanner keyboard = new Scanner(System.in);  
System.out.print("SAY SOMETHING: ");  
String input = keyboard.nextLine();  
System.out.println("INPUT=" + input);  
```
One of the methods (fetching user input) is already implemented for you.

**Please note that is it absolutely essential that you use the given method stubs to complete the assignment!**