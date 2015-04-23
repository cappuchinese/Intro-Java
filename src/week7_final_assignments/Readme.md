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
    1.	Classes should adhere to the Single Responsibility Principle (SRP)
    2.	Be as efficient with memory and resources as possible (always think streaming).
    3.	Use the Exception mechanism well (especially when dealing with files), and never ever let a user see a stack trace on screen, only non-nerd messages!

Since these assignments are of a higher level, it may not possible to create tests for all requirements. 
Therefore, keep thinking for yourself and do not be blinded by the red or green bar of the test-runs!

**Important note**: your code will be scanned for duplicates on the internet, in your class and previous classes.
 If any duplicated code is found, you will BOTH fail this course and will be reported to the dean for cheating 
(this is a very serious offence at the Hanze University of Applied Science!).


```Java
/**
 * provides a range of possible sorters, based on the type that is requested.
 * @param type
 * @return proteinSorter
 */
public static Comparator<Protein> getSorter(SortingType type) {
    //for you to implement
}
```  
For this assignment, you may **NOT** assume all amino acid sequence strings provided to the constructor are legal
amino acid DNA sequences containing only regular amino acid characters. Also, do **NOT** assume only uppercase characters!
When constructing Protein objects, perform the necessary checks on the given arguments and throw 
an IllegalArgumentException if there is anything dodgy going on.  
For this purpose, you can apply these rules:  

1. Amino acid sequence should contain only one of the twenty regular amino acid characters
2. These characters: "*" or ".", when at the last position, denote the end of a sequence and should simply be removed.

You will probably want to implement the method gerMolecularWeight() in class Protein,
and you should think carefully about the way to couple SortingType to the actual Comparator implementation 
-- there are several ways but they are not all equally nice.  
Ask yourself this: who (which class) should be responsible for creating and serving a Comparator object?

See these snippets for an example usage and result
(**NB these examples should be viewed on Bitbucket, not within NetBeans!**):

```Java
ArrayList<Protein> proteins = new ArrayList<>();
Protein p1 = new Protein("mannosidase alpha", "man1b1a", "MRTVALL", 
        new GOannotation(15923, "cytoplasmatic", "beta-6-sulfate-N-acetylglucosaminidase activity", "sugar metabolism"));
proteins.add(p1);

Protein p2 = new Protein("60s ribosomal protein l35 pthr13872", "Stt3a", "MTDDLVLAW", 
        new GOannotation(18279, "membrane inserted", "protein N-linked glycosylation via asparagine", "sugar metabolism"));
proteins.add(p2);

Protein p3 = new Protein("tumor suppressor candidate 3", "Tusc3", "MQSVNKLI", 
        new GOannotation(18269, "mitochondrial", "dolichyl-diphosphooligosaccharide--protein glycosyltransferase", "cell-cycle regulation"));
proteins.add(p3);

Protein p4 = new Protein("synovial apoptosis inhibitor 1, synoviolin", "Syvn1", "MTYIILLVCDERT", 
        new GOannotation(13259, "cytoplasmatic", "synoviolin-related", "cell-cycle regulation"));
proteins.add(p4);

Protein p5 = new Protein("fucosyltransferase 8 (alpha (1,6) fucosyltransferase)", "Fut8", "MGTHIILVLM", 
        new GOannotation(342989, "cytoplasmatic", "fucosyltransferase activity", "sugar metabolism"));
proteins.add(p5);

//sort in Protein-standard manner
Collections.sort(proteins);

//print the Java 8 way
proteins.stream().forEach(System.out::println);
```
Outputs:

```
Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW}
Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM}
Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL}
Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT}
Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI}
```

and this

```Java
/*list construction omitted*/

//sort on accession number
Collections.sort(proteins, Protein.getSorter(SortingType.ACCESSION_NUMBER));

proteins.stream().forEach(System.out::println);
```
Outputs:

```
Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM}
Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL}
Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW}
Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT}
Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI}
```

and this

```Java
/*list construction omitted*/

//sort on accession number
Collections.sort(proteins, Protein.getSorter(SortingType.PROTEIN_WEIGHT));

proteins.stream().forEach(System.out::println);
```
Outputs:

```
Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT} //1569.89 
Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM} //1127.47
Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW} //1063.23 
Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI} //932.15
Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL} //803.03
```

and lastly, this

```Java
/*list construction omitted*/

//sort on accession number
Collections.sort(proteins, Protein.getSorter(SortingType.GO_ANNOTATION));
//first on biological process (3), then on cellular component (1) and last on molecular function (2)
proteins.stream().forEach(System.out::println);
```
Outputs:

```
Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, ...} //GOannotation(13259, "cytoplasmatic", "synoviolin-related", "cell-cycle regulation")
Protein{name=tumor suppressor candidate 3, accession=Tusc3, ...} //GOannotation(18269, "mitochondrial", "dolichyl-diphosphooligosaccharide--protein glycosyltransferase", "cell-cycle regulation")
Protein{name=mannosidase alpha, accession=man1b1a, ...} //GOannotation(15923, "cytoplasmatic", "beta-6-sulfate-N-acetylglucosaminidase activity", "sugar metabolism")
Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, ...} //GOannotation(342989, "cytoplasmatic", "fucosyltransferase activity", "sugar metabolism")
Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, ...} //GOannotation(18279, "membrane inserted", "protein N-linked glycosylation via asparagine", "sugar metabolism")
```
