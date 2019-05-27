# Interfaces

## Learning outcomes
* Getting to know interfaces 
* Implementing logic
* char to int conversions


## Assignment 

In this package you will find an interface called `StringCombinable` that has a single method: 
`String combine(String first, String second)`.

The other class in this package is `CombinerFactory` which has three factory methods for `StringCombiner` 
implementations. A factory method means the method serves a specific implementing class of the interface
but client code does not need to know this class, only that the interface has been implemented.

It is your task to create the described implementers according to the Javadoc comments of the three methods.  
There are several equally valid implementation possibilities: regular classes, anonymous local inner classes or 
(anonymous) member classes. Have a look at the post "Inner classes" (Part 4) if you are interested in the latter options.

The JUnit tests will tell you if the solutions are OK.
