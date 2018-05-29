# Java Operators

## Learning outcomes
* getting to know Java operators and precedence
* getting to know classes and instances
* implementing algorithmic logic

## Assignment details
This package contains three classes. 
The first, `Operators`, hase the same setup as before - simply work your way through the methods and implement 
them according to the instructions stated within the methods' Javadoc or in the method body.

The other two classes, `BritishWeightUnits` and `WeightUnitsSolver` should be used for the assignment outlined below.
 

### British Weight Units solver
In class `WeightUnitsSolver`, implement method `convertFromGrams()` that will return a BritishWeightUnits instance
 representing the number of Pounds, Ounces, and Grams converted from a quantity expressed simply in (whole) Grams.
As a courtesy: A pound is 454 grams and an ounce is 28 grams.
For example: 1000 grams is 2 pounds and 3 ounces and 8 grams
Tip: use the modulo (%) operator

You should implement some error checking -- it is for instance not possible to calculate from negative quantities! 
If the input is negative, an `IllegalArgumentException` should be thrown. 

You have to use the `BritishWeightUnits` class provided in this package - creating your own will not yield 
passable tests

For example, when the main() method is run with this code:

```Java
WeightUnitsSolver wus = new WeightUnitsSolver();
wus.convertFromGrams(1000);
``` 

a BritishWeightUnits object (instance) holding 2 pounds, 3 ounces and 8 grams should be created.
When you print this object this you will see

```
BritishUnitsCoins{pounds=2, ounces=3, grams=8}
```

