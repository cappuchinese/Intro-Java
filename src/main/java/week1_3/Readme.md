# Solving weights to British units  #

## Learning outcomes ##
* getting to know Java syntax and types
* getting to know classes and instances
* implementing algorithmic logic


## Assignment details ##
Write a method that will return a BritishWeightUnits instance representing the number of 
Pounds, Ounces, and Grams converted from a quantity expressed simply in (whole) Grams.
As a courtesy: A pound is 454 grams and an ounce is 28 grams.
For example: 1000 grams is 2 pounds and 3 ounces and 8 grams
Tip: use the modulo (%) operator

**NB these examples should be viewed on Bitbucket, not within NetBeans!**

As before, you should also implement some error checking -- it is for instance not possible to calculate from negative quantities!
You will have to use the BritishWeightUnits class provided in this package - creating your own will not yield passable tests

For example, this piece of code:

```Java
WeightUnitsSolver wus = new WeightUnitsSolver();
wus.convertFromGrams(1000);
``` 

will create a BritishWeightUnits object (instance) holding 2 pounds, 3 ounces and 8 grams.
When you print this object this you will see

```
BritishUnitsCoins{pounds=2, ounces=3, grams=8}
```
