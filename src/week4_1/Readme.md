# Sorting objects every way you like it #

## Learning outcomes ##
* getting to know Java Collection types, in particular ArrayList
* getting to know all Java sorting methods


## Assignment details ##
In this package you will find a Protein class. 
This class models objects of type Protein with some nice properties: name, accession number, GO annotation, and amino acid sequence.
Besides this, you may notice the Java enum SortingType, which defines the possible ways Protein objects may be sorted.
These are the sorting types that are expected for each of the possible SortingType sorts:

1. By name (SortingType.PROTEIN_NAME) -- a simple alphabetical sort
2. By accession number (ACCESSION_NUMBER) -- a simple alphabetical sort
3. By GO annotation (GO_ANNOTATION) -- a multi-step sort (see below for specifications)
4. By Protein molecular weight (PROTEN_WEIGHT)

The first sorting type should be the default implementation for protein objects. 
Provide this sorting in the correct place.
The others should be provided/supported by implementation of the static method getSorter():

```Java
Protein.getSorter(SortingType type){
    //for you to implement
}
```  
For this assignment, you may **NOT** assume all amino acid sequence strings provided to the constructor are legal
amino acid DNA sequences containing only regular amino acid characters. Do **NOT** assume only uppercase characters!
When constructing Protein objects, perform the necessary checks on the given arguments and throw an IllegalArgumentException if there is anything dodgy going on.
For this purpose, you can apply these rules:



For amino acid weights you should use the weights listed on [WebQC](http://www.webqc.org/aminoacids.php). It is essential you use these exact weights!

Sorting on GO annotation should be first on biological process, then on cellular function and last on molecular function. See a .

**NB these examples should be viewed on Bitbucket, not within NetBeans!**

See these snippets for an example usage and result:


