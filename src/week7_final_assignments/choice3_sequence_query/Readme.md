# Final assignment 3: Developing a Fasta sequence query app #

## Special challenge of this assignment: pattern search and applying filters ##

## Assignment details ##
The Fasta sequence format is the most widely used format around. It looks like this:  

```
>gi|119896293|ref|YP_931506.1|TAXID=62928| chromosomal replication initiation protein [Azoarcus sp. BH72] 
MNQDFWPFCLARLEQELPQQQFNTWIKTLQAAESDADGAVALTLTAPNRFVLQWVRERYMRRIGELGEEF
QVAMWLAKELTPMSLPAIGEAFGGRDHTTVLHACRTITELRLGDHQLNHDVHVLTQVLRG
>gi|119896294|ref|YP_931507.1|TAXID=62928| DNA-directed DNA polymerase [Azoarcus sp. BH72]
MLLLNTTRDALLAPLQSVAGIVEKRHTLPILSNVLIEKRGDQLTLLATDIEIQIRTTTAGHIGGEDSSIT
VGARKLQDILRALSDSVDIVLTLEDKRLTVKAGKSRFQLQTLPAADYPRMNLPDGDAVRFSVPQRAFKRQ
```

The NCBI-type Fasta sequence header knows multiple elements. In general, the header elements can be defined as this:  

  1. > - start of sequence header line: always at start of line and an essential part   
  2. identifiers - an optional series of identifiers as pairs of elements separated by the pipe symbol: identifier-type and identifier   
  3. sequence description or name 
  4. organism name, surrounded by square brackets 

For this assignment you will work on parsing this file type and reporting information from its contents.  
You can find some example files in the "data" folder of this NetBeans project (they all have the extension ".fa", ".fna" or ".faa".  
Do not remove the data from this folder -- this is where the test environment needs the test files!  
Create a filter/parser for files in Fasta format, and implement the given use cases.
You may notice that this assignment is also about filtering data in different filter combinations. 
This is the aspect of this assignment that will weight extra heavily!
All these selectors and filters should be supported **in any combination**:  




  * --fetch_type <TYPE>     Will fetch a certain type of feature (e.g. gene, CDS)
  * --fetch_region <COORDINATES>    Will select all features that are included completely within the given coordinates
  * --filter <SOURCE, SCORE, ORIENTATION MAXIMUM AND/OR MINIMUM LENGTH> Will filter on any of these data fields, in any combination:
       * SOURCE should filter on source attribute   
       * SCORE should filter on score attribute   
       * ORIENTATION should be defined using a "+", "-" or "." character  
       * MINIMUM LENGTH should be defined using an integer
       * MAXIMUM LENGTH should be defined using an integer
    The filter should be specified using the format "source|score|orientation|maximum_length|minimum_length", 
    where suppression of an individual filter is indicated using an asterisk (*).  

    For instance, this will select all genes of over 10000 nucleotides long:
    ```
    java -jar GffQuery.jar --infile potato_pseudomolecule_sample.gff3 --fetch_type gene --filter "*|*|*|10000|*"  
    ```

    And this will select all features on the + strand with unspecified score:
    ```
    java -jar GffQuery.jar --infile potato_pseudomolecule_sample.gff3 --filter "*|.|+|*|*"  
    ```

    One last example, this will select all CDS features defined by the program BestORF on the minus strand, of at least 250 and at most 1000 nucleotides:
    ```
    java -jar GffQuery.jar --infile potato_pseudomolecule_sample.gff3 --fetch_type CDS --filter "BestORF|*|-|250|1000"  
    ```

Some of the possible use cases are listed below and in the example section (for most JUnit-tested use cases, example output is shown below):
1)	java -jar SeqQuery --help
shows informative help/usage information
2)	java -jar SeqQuery --input <INFILE> --output <OUTFILE>
accepts a command-line argument specifying the (multi-)sequence file and output file. Generates a nicely formatted csv file listing relevant properties (e.g. length, molecular weight,) of the sequences.
3)	java -jar SeqQuery --input <INFILE> --find_prosite <PROSITE_PATTERN>
Reports which sequences have the given Prosite pattern 
4)	java -jar SeqQuery --input <INFILE> --find_regex <REGEX_PATTERN>
Reports which sequences have the given regular expression pattern and where
5)	java -jar SeqQuery --input <INFILE> --find_organism <(PART OF) ORGANISM_NAME>
Reports which sequences belong to the given organism as-is (a.g. in Fasta format)
6)	java -jar SeqQuery --input <INFILE> --find_id <ID>
Returns the sequence with the given name as-is (a.g. in Fasta format)
7)	java -jar SeqQuery --input <INFILE> --find_description <WILDCARD-STRING>
Returns the sequences with the given pattern in the description as-is (a.g. in Fasta format)
NB: aspects 2, 3, 4 and 6 should generate a well-formatted csv file (or terminal output) while 6 and 7 should produce the sequences as-is in Fasta format!




Use case 2 example:  

```
michiel@bin206: java -jar GffQuery.jar --infile data/gff3_sample.gff3 --summary  
file                     gff3_sample.gff3  
molecules with features  human15.1  
number of features       22  
feature counts:
    gene            1
    mRNA            4
    CDS             10
    three_prime_UT  4
    five_prime_UTR  3
```

