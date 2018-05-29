# Exercises combining all the stuff

## Learning outcomes
* getting to know Java syntax and types, in particular Array
* implementing algorithmic logic
* working with user input


## Assignment: BMI calculator
In this assignment you will need to create functionality that calculates a BMI based on weight and height.  
Also, given a BMI, you will need to convert this into an appropriate textual label.  
To achieve this goal you have to write implementations for the given method stubs in class BmiCalculator.
One method, `calculateBMI()`, can be used to calculate the BMI of a person by asking the user for their weight and height.  
The other, `getMessage()`, can be used to convert a BMI value into an appropriate textual label.  
  
The main() method is already implemented, making it possible to use this class as a simple actual program. 

The string labels are already provided for you -- **you must use these**!

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
In Java this can be achieved (amongst other means) by using the Scanner class 
to read from the console, like this:

```Java
Scanner keyboard = new Scanner(System.in);  
System.out.print("SAY SOMETHING: ");  
String input = keyboard.nextLine();  
System.out.println("INPUT=" + input);  
```

One of the methods (fetching user input for height) is already implemented for you as an example.

Of course, the Java Exception mechanism has not been dealt with in the course. 
Therefore, an example of its use is given in the method calculateBMI(), already providing you 
with two passed tests!
You can use this example to create the implementation of method getMessage().


## Assignment: Creating a consensus sequence  

Implement a method that will determine the consensus of a given set of sequences (of the same length).
The input sequences are provided as an Array of Strings.
For this assignment, you may assume all DNA strings provided are legal DNA sequences containing ONLY G, A, T or C characters,  in uppercase.

The consensus sequence can be created in two ways, specified by the second argument to the method.
If the iupac flag is set to true, IUPAC-type encoding will be used, else a bracket-type notation should be used.
With bracket notation, the nucleotides should be ordered alphabetically! So this is wrong: "GA[A/T/C]" and this is right: "GA[A/C/T]"

IUPAC encoding is explained [here](http://en.wikipedia.org/wiki/Nucleic_acid_notation)

See this snippet for an example usage and result:

```Java
String[] sequences = new String[4];
sequences[0] = "GAAT";
sequences[1] = "GAAA";
sequences[2] = "GATT";
sequences[3] = "GAAC";
ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
String consensus = csc.createConsensus(sequences, true);
//consensus should equal "GAWH"
consensus = csc.createConsensus(sequences, false);
//consensus should equal "GA[A/T][A/C/T]"
``` 

**NOTE: this problem can be solved in many ways, some hard and some easy -- so think before you start!**

- *Tip 1*: use String.join("+", sequences) to join array elements into a single string (if you think you need this feature)
- *Tip 2*: use String.split("delimiter") to split a String into separate elements. Leaving the delimiter empty will split on all characters!
- *Tip 3*: use Arrays.sort() to sort a String[] alphabetically
- *Tip 4*: you will need to use some kind of nested for-loop to get this done

