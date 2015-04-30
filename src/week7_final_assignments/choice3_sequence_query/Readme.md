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

  1. ">" - start of sequence header line: always at start of line and an essential part   
  2. identifiers - an optional series of identifiers as pairs of elements separated by the pipe symbol: identifier-type and identifier   
  3. sequence description or name 
  4. organism name, surrounded by square brackets 

For this assignment you will work on parsing this file type and reporting information from its contents.  
You can find some example files in the "data" folder of this NetBeans project (they all have the extension ".fa", ".fna" or ".faa".  
Do not remove the data from this folder -- this is where the test environment needs the test files!  
Create a filter/parser for files in Fasta format, and implement the given use cases.

All these selectors and filters should be supported **in any combination**:  

  * --fetch_prosite <PROSITE PATTERN>  Will report all sequences that contain the Prosite pattern, 
    with the location and actual sequence found (see below for example output).
  * find_regex <REGEX_PATTERN>   Will report all sequences that contain the Regular expression pattern, 
    with the location and actual sequence found (see below for example output).
  * --find_organism <(PART OF) ORGANISM_NAME>  Will report all sequences having this wildcard string (a regex pattern)
    in the organism name
  * --find_description <WILDCARD-STRING>  Will report all sequences having this wildcard string (a regex pattern)
    in the description / sequence name 

**Note** options find_description and find_organism should be supported in combination, 
so that sequences are only reported when both match.

Some of the possible use cases are listed below and in the example section (for most JUnit-tested use cases, example output is shown below):  

  1. java -jar SeqQuery --help
    Shows informative help/usage information  
  2. java -jar SeqQuery --input <INFILE> --summary  
    Creates a textual summary of the parsed file: number of sequences, sequence type, average length (see below for an example) 
  3. java -jar SeqQuery --input <INFILE> --to_csv ";"
    Accepts a command-line argument specifying the (multi-)sequence file.
    Generates a nicely formatted csv listing with these columns ands the given character as separator:  
    * ACCNO: First accession
    * NAME: Name / descripion
    * ORG: Organism
    * TYPE: Type (DNA, RNA, Protein)
    * LENGHT: Length
    * MOL_WEIGHT: Molecular weight
  4. java -jar SeqQuery --input <INFILE> --find_prosite <PROSITE_PATTERN>  
    Reports which sequences have the given Prosite pattern 
    Generates a nicely formatted csv listing with these columns and Tab as separator:  
    * ACCNO: First accession
    * NAME: Name / descripion
    * ORG: Organism
    * TYPE: Type (DNA, RNA, Protein)
    * POSITION: Start position of match
    * SEQ: Actual sequence of match
  5. java -jar SeqQuery --input <INFILE> --find_regex <REGEX_PATTERN>  
    Reports which sequences have the given regular expression pattern and where
    Generates a nicely formatted csv listing with these columns and Tab as separator:  
    * ACCNO: First accession
    * NAME: Name / descripion
    * ORG: Organism
    * TYPE: Type (DNA, RNA, Protein)
    * POSITION: Start position of match
    * SEQ: Actual sequence of match
  6. java -jar SeqQuery --input <INFILE> --find_organism <(PART OF) ORGANISM_NAME>  
    Returns the sequences that have the given organism name (sub) string as-is (a.g. in Fasta format)  
  7. java -jar SeqQuery --input <INFILE> --find_id <ID>  
    Returns the sequence with the given name as-is (a.g. in Fasta format)  
  8. java -jar SeqQuery --input <INFILE> --find_description <WILDCARD-STRING>  
    Returns the sequences with the given pattern in the description as-is (a.g. in Fasta format)  
    
**NB**: aspects 2, 3, 4 and 6 should generate a well-formatted csv file (or terminal output)
     while 6 and 7 should produce the sequences as-is in Fasta format!  





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

