# Java Operators

## Learning outcomes
* getting to know Java operators and precedence
* getting to know classes and instances
* implementing algorithmic logic

## British Weight Units solver

This package contains two classes: `BritishWeightUnits` and `WeightUnitsSolver`. 
Class `BritishWeightUnits` is completely implemented; there is nothing to code there for you.

Class `WeightUnitsSolver` has a single method (`convertFromGrams(int grams)`) that should return a BritishWeightUnits instance
 representing the number of Pounds, Ounces, and Grams converted from a quantity expressed simply in (whole) Grams.
Note that a pound is 454 grams and an ounce is 28 grams.
For example: 1000 grams is 2 pounds and 3 ounces and 8 grams

You should also implement some error checking -- it is, for example, not possible to calculate from negative quantities! 
If the input is negative, an `IllegalArgumentException` should be thrown. 

You can `print()` instances of class `BritishWeightUnits`; it will give output like this:

```
BritishUnitsCoins{pounds=2, ounces=3, grams=8}
```

As always, you are free to create a `main()` method for testing/development purposes.
Tip: use the modulo (%) operator

You should know where to find the tests by now.