# Language basics

## Learning outcomes
* Working with IntelliJ 
* Create and run JUnit tests
* Getting to know Java coding conventions 
* Basic OO programming

**It is essential that you use the given method stubs to complete the assignments**

## Assignments 

1. In class `LanguageBasics`, work your way through the methods and implement them according to the instructions 
stated within the methods' Javadoc and/or in the method body. 

2. Class `Point` has a method that is not implemented: `double euclideanDistanceTo(Point otherPoint)`. 
This is your task. Again, the Math class may come in handy. 
If you can't remember the definition of Euclidean distance, GIYF.

3. Class `Square` has a method that is not implemented: `int surface()`. This is your task.

4. Implement the `main()` method of class `GeometryAnalyser` so that it can deal with command-line arguments: 
A series of four numbers,
each pairwise representing the `x` and `y` value of a `Point` the last argument should be "dist" or "surf", indicating 
the desired operation. So, for example, if I would run the application with `2 5 6 2 surf` it means I want the 
surface of the square formed by `Point(2, 5)` (upperleft) and `Point(6, 2)` (lowerright) and the program output should 
simply state "12". The option "dist" should work in a similar fashion, but also round the result to 1 decimal.

See post "Basic Program Design" (Part 1) for instructions on creating and modifying run 
configurations in IntelliJ. 
Technical tips:   
    - To perform String comparisons, use `"string_one".compareTo("string_two")`.
    - To convert a String to an Integer, use `Integer.parseInt(String)`
    - To round a number, use `NumberFormat`. Here is an example:  
    
```java
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(1);
        System.out.println(numberFormat.format(3.354)); //prints "3,6" in a Dutch Locale
```   

    **_Challenge_**: With option "surf", if x1 < x2 or y1 < y2, the program should print "Illegal input".


