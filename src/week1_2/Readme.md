# Creating a listing of all substrings of a string  #

## Learning outcomes ##
* getting to know Java syntax and types
* working with user input
* getting to know Java String class
* getting to know the Java for loop


## Assignment details ##
You have to implement a method that generates (prints) all possible substrings, given as input a String object.
The given method stub takes as arguments 
    * a String to substring
    * a boolean indicating whether the String should be left-truncated or right-truncated
    * a boolean indicating whether the String should be left-aligned or right-aligned

**NB these examples should be viewed on Bitbucket, not within NetBeans!**

For example, this method call:

```Java
asp.printAllSubstrings("GATCG", true, true);
``` 

will generate the following output to console

```
GATCG
ATCG
TCG
CG
G
```

and this method call:

```Java
asp.printAllSubstrings("GATCG", true, false);
``` 

will generate the following output to console

```
GATCG
 ATCG
  TCG
   CG
    G
```

and this method call:

```Java
asp.printAllSubstrings("GATCG", false, true);
``` 

will generate the following output to console

```
GATCG
GATC
GAT
GA
G
```
As a reminder, this is the code you use for Java looping over a String object:

```Java
for(int i = 0; i < string.length(); i++) {
    //do something
}
```

