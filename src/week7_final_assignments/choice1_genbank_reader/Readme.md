# Final assignment 1: Developing a GenBank reader #

## Assignment details ##
Given the GenBank sequence format (assume only one DNA sequence resides in a single file 
– if there are more, ignore these and report this to the user).  
You can find some example files in the [downloads](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads) 
section of this repo [example_genbank_files.zip](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads/example_genbank_files.zip)
Create a parser for files of this type extracting of all Features only these fields:  

  1. Source/organism
  2. CDS/coordinates
  3. CDS/product
  4. CDS/db_xref
  5. CDS/translation
  6. Gene/coordinates
  7. Gene/gene
  8. Sequence

Create an appropriate data model that extends the code you find in this package. 
Create an executable that can be used for the listed use cases. 
For all JUnit-tested use cases, example output is shown below.  
The use cases:  

  1. java -jar GenBankReader --help  
    shows informative help/usage information 
  2. java -jar GenBankReader.jar --infile &lt;INFILE&gt; --summary  
    Creates a textual summary of the parsed file: parsed file, length of the sequence,
    for genes: count and forward/reverse balance and for CDS features: count only. 
    **NB: the F/R balance is the number on the forward strand divided by the total number**
  3. java -jar GenBankReader.jar --infile &lt;INFILE&gt; --fetch_gene &lt;GENE NAME (-PATTERN)&gt;  
    Returns nucleotide sequences of the genes that match the gene name pattern, in Fasta format
  4. java -jar GenBankReader.jar --infile  &lt;INFILE&gt;--fetch_cds &lt;PRODUCT NAME (-PATTERN)&gt;
    Returns the amino acid sequences of the CDSs that match the product name pattern, in Fasta format  
  5. java -jar GenBankReader.jar --infile &lt;INFILE&gt; --fetch_features &lt;COORDINATES&gt;  
    Returns all features between the given coordinates  
  6. java -jar GenBankReader.jar --infile &lt;INFILE&gt; --find_sites &lt;DNA SEQ WITH IUPAC CODES&gt;
    Lists the locations of all the sites where the DNA pattern is found: 
    position and actual sequence and (if relevant) the element in which it resides

Use case 2 example:  
 
```
michiel@bin206: java -jar GenBankReader.jar --infile example_genbank_file.gb --summary  
file              example_genbank_file.gb  
sequence length   5028 bp  
number of genes   2  
gene F/R balance  0.5
number of CDSs    3      
```



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
