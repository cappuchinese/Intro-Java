# Sorting objects every way you like it #

## Learning outcomes ##
* getting to know Java Collection types, in particular ArrayList
* getting to know all Java sorting methods


## Assignment details ##
In this package you will find a Protein class. 
This class models the Protein properties: name, accession number, GO annotation, and amino acid sequence.
Besides this there is the Java enum SortingType which defines the possible ways Protein objects may be sorted.
These are the sorting types that are expected for each of the possible SortingType sorts:

1. By name (SortingType.PROTEIN_NAME) -- a simple alphabetical sort, ascending
2. By accession number (ACCESSION_NUMBER) -- a simple alphabetical sort, ascending, but **case insensitive**
3. By GO annotation (GO_ANNOTATION) -- a multi-step sort. 
Sorting on GO annotation should be first on biological process, then on cellular component and last on molecular function. 
All alphabetically ascending
4. By Protein molecular weight (PROTEN_WEIGHT) -- this sorts on the summed molecular weight of all amino acids, descending.
For amino acid weights you should use the weights listed on [WebQC](http://www.webqc.org/aminoacids.php). It is essential you use these exact weights!

The "By name" sorting type should be the default implementation for protein objects. 
The others should be provided/supported by implementing the static method `getSorter()` defined in class `Protein`:

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

You will probably want to implement the method gerMolecularWeight() in class Protein if you want to support sorting on 
molecular weight.

**Challenge aspects**  

- Think carefully about the way to couple SortingType to the actual Comparator implementation. Ask yourself this: 
who (which class) should be responsible for 
creating and serving a Comparator object?
- Can you implement the interface `ProteinDataSource` to read from actual textual data? There is a text representation
of the same data here: `data/proteins.fa`

See these snippets for an example usage and result.

```Java
ProteinDataSource proteinDataSource = new ProteinDataSourceInMemory();
List<Protein> proteins = proteinDataSource.getAllProteins();

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
