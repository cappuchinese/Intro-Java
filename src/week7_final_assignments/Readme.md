# Final assignments #

## Learning outcomes ##
* Using apache CLI to parse command-line arguments
* Creating and implementing a class design for a real-life problem


## Final Assignments details ##
These assignments are meant to test you complete set of Java skills aquired so far.
There are several assignments you can choose from, but all have comparable degrees of difficulty.
Whatever your choice may be, all solutions should adhere to these general requirements. These are all considered in the grading process!

1. You must work individually on this assignment.
2. The only library outside the JDK that you may (and must!) use is the Apache CLI library for parsing standards-adhering command-line arguments
([link to Apache CLI](http://commons.apache.org/proper/commons-cli/))  
You should perform exhaustive checks on user-provided command-line arguments (files exist, required parameters have been set and are not conflicting, etc.).
3. Adhere to Java naming conventions: see [here](http://www.oracle.com/technetwork/java/codeconventions-135099.html) or 
[here](http://java.about.com/od/javasyntax/a/nameconventions.htm) 
4. adhere to Java coding style (as verified by the Netbeans plugin Checkstyle) and these are largely the same as the Google style
guide for Java [here](https://google-styleguide.googlecode.com/svn/trunk/javaguide.html).
5. Document your code well: both Javadoc annotations and in-code comments are an absolute requirement! See below for a set of Javadoc example comments.
6. Always implement toString().
7. Override equals() and hashCode() intelligently when your objects are going to live in collections.
8. Be sure to follow these design principles:
    * Classes should adhere to the Single Responsibility Principle (SRP)
    * Be as efficient with memory and resources as possible (always think streaming).
    * Use the Exception mechanism well (especially when dealing with files), and never ever let a user see a stack trace on screen, only non-nerd messages!

Since these assignments are of a higher level, it may not possible to create tests for all requirements. 
Therefore, keep thinking for yourself and do not be blinded by the red or green bar of the test-runs!

**Important note**: your code will be scanned for duplicates on the internet, in your class and previous classes.
 If any duplicated code is found, you will BOTH fail this course and will be reported to the dean for cheating 
(this is a very serious offence at the Hanze University of Applied Science!).

Here is an example of a comment block with a minimal licence header; you should have one of these at the top of each source file:
**Note: you can easily change licence text templates and class templates in NetBeans**

```Java
/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */
}
```  

This is how you should annotate classes, with purpose of the class, the author and version:

```Java
/**
 * This class is the main controller in the AnimalSimulator application.
 * It contains the main() method and runs the simulation. 
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class AnimalSimulator {
    //class code
}
```  

This is how you should annotate methods, with purpose of the method, the author (if other than the class) and annotations for
parameters (@param), return types (@return) and thrown exceptions (@throws -- also the unchecked exceptions if explicitly thrown):

```Java
    
    /**
     * Returns all supported animals as List, alhabetically ordered, with the given substring to search for.
     * If the search string is null, all supported animals are returned, else only the animals whose name matches
     * the given search string (anywhere in the name).
     * @param searchString the search string. 
     * @return supportedAnimals the supported animals
     * @throws IllegalArgumentException ex for an empty search string
     */
    public List<String> getSupportedAnimals() {
        //method code
    }
```  
