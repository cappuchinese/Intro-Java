# Java data types

## Learning outcomes
* getting to know Java primitive types
* getting to know arrays
* basic programming (with `for`)
* Object-oriented design

## Assignments

1. In class `Datatypes`, work your way through the methods and implement them according to the instructions 
stated within the methods' Javadoc and/or in the method body. The tests are in class `DatatypesTest` and have the same name 
as the ones they test.

2. This assignment is partly for you to implement and learn about types and partly as a demonstration of 
Object Oriented Programming in Java.

This package has a two-class program that can be used to process zoo information and print a zoo summary. 

There are two classes involved: `ZooApp` and `ZooSpecies`. Class `ZooSpecies` has been completely implemented. 
You only task there is to study its code and figure out what is happening. This class demonstrated quite a few 
coding patterns that are common in Java - don't skip that!

The second class is `ZooApp`. It is the **_controller_** of the application, and it is the "main class" as well: it has the 
`main()` method that is required to be an executable application. Within this class there are a few (parts of) methods
that you should implement. Just follow the steps below.

1. The `main()` method receives from the command line and array: `String[] args`. The array should have this structure: 
`Bonobo Giraffe Lion Lion Chimpanzee Giraffe`. Create such a **_run configuration_**.

2. The `main()` method creates and instance of `ZooApp` and passes the args array to the method `processZooData()`. 
Within this method you should process the command line arguments. Note that class ZooSpecies does most of the work!

3. Method `printZooSummary()` is already partly implemented. It should print a species summary that looks like this:

```
The zoo has 4 species.
These are the species counts:
	Bonobo: 1
	Chimpanzee: 1
	Lion: 2
	Giraffe: 2
```

There is only a test for `processZooData()`.

Hint: To find out which methods are available on an object, type the variable and a dot and IntelliJ will give suggestions.
Hint: To find out which method are available on a class, type the class name and a dot and IntelliJ will give suggestions.
Hint: have a look at the String class on how to split strings into elements.