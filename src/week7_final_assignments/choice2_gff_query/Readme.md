# Final assignment 2: Developing a GFF file query app #

## Assignment details ##
The GFF3 file format is a data format used to communicate the presence and location of feature on a sequence.  
GFF3 stands for Generic Feature Format version three.  
See [here](http://www.sequenceontology.org/gff3.shtml) or [here](http://www.broadinstitute.org/annotation/argo/help/gff3.html)
 for a description of the format.

The fields are these: 

  1. seqname - The name of the sequence. Typically a chromosome or a contig.   
  2. source - The program that generated this feature.    
  3. feature - The name of this type of feature. The official GFF3 spec states that this should be a term from the SOFA ontology.  
  4. start - The starting position of the feature in the sequence. The first base is numbered 1.  
  5. end - The ending position of the feature (inclusive).  
  6. score - A score between 0 and 1000. If there is no score value, enter ".".  
  7. strand - Valid entries include '+', '-', or '.' (for don't know/don't care).  
  8. frame - If the feature is a coding exon, frame should be a number between 0-2 that 
     represents the reading frame of the first base. If the feature is not a coding exon, 
     the value should be '.'.   
  9. GFF3: grouping attributes Attribute keys and values are separated by '=' signs. 
     Values must be URI encoded.quoted. Attribute pairs are separated by semicolons. 
     Certain, special attributes are used for grouping and identification (See below). 
     This field is the one important difference between GFF flavors.  


For this assignment you will work on parsing this file type and reporting information from its contents.  
You can find some example files in the "data" folder of this NetBeans project (they all have the extension ".gff3".  
Do not remove the data from this folder -- this is where the test environment needs the test files!  
Create a parser for files in GFF3 format, extracting all annotations, and implement the following use cases
(for all JUnit-tested use cases, example output is shown below):

  1. java -jar GffQuery --help  
     shows informative help/usage information  
  2. java -jar GffQuery.jar –infile <INFILE> --summary  
     Creates a textual summary of the parsed file: names of molecules with annotations, types and counts of features.  
  3. java -jar GffQuery.jar --infile  <INFILE> --fetch_type <TYPE>  
     Returns a GFF3-type listing of all features of this type  
  4. java -jar GffQuery.jar --infile <INFILE> --fetch_type  <TYPE> --filter <SCORE, ORIENTATION OR MINIMUM LENGTH>  
     Returns a GFF3-type listing of all features of this type, but filtered according to the filter. 
     If the fetch_type argument has the value "ALL", all feature types should be included.  
       * SCORE should be defined as a double (always with at leat one decimal place)  
       * ORIENTATION should be defined using a "+", "-" or "." character  
       * MINIMUM LENGTH should be defined using an integer
  5. java -jar GffQuery.jar --infile <INFILE> --fetch_children <PARENT ID>  
     Lists all children RECURSIVELY as GFF3-type listing that have the given Parent ID as ancestor (parent or parents parent!).  
  6. java -jar GffQuery.jar --infile <INFILE> --fetch_region <COORDINATES>  
     Returns all features that lie completely between the given coordinates, as shown below  
  7. java -jar GffQuery.jar --infile <INFILE> --find_wildcard <WILDCARD STRING>  
     Lists all features that have the given wildrcard string in the Name attribute (part of field 9)


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

Use case 3 example:  

```
michiel@bin206: java -jar GffQuery.jar --infile data/gff3_sample.gff3 --fetch_type five_prime_UTR  
human15.1 . five_prime_UTR  214590  214590 . +   . Parent=HsT20207
human15.1 . five_prime_UTR  214301  214302 . +   . Parent=HsT16028
human15.1 . five_prime_UTR  215218  215233 . +   . Parent=HsT16029
```

Use case 4 example (A). Selects all mRNA features on the forward strand.
Note the use of quotes around special characters in command-line arguments:  

```
michiel@bin206: java -jar GffQuery.jar --infile data/gene_sample.gff3 --fetch_type mRNA --filter "+"  
PGSC0003DMB000000010	Cufflinks	mRNA	1242814	1245444	.	+	.	ID=PGSC0003DMT400000001;Parent=PGSC0003DMG400000001;Source_id=RNASEQ44.3678.0;Mapping_depth=48.922289;Class=1;
PGSC0003DMB000000010	Cufflinks	mRNA	1242814	1245444	.	+	.	ID=PGSC0003DMT400000002;Parent=PGSC0003DMG400000001;Source_id=RNASEQ44.3678.1;Mapping_depth=349.773769;Class=1;
PGSC0003DMB000000010	Cufflinks	mRNA	1243971	1245448	.	+	.	ID=PGSC0003DMT400000003;Parent=PGSC0003DMG400000001;Source_id=RNASEQ44.3678.2;Mapping_depth=52.447281;Class=1;
```

Use case 4 example (B). Selects all introns over 500 nucleotides long.

```
michiel@bin206: java -jar GffQuery.jar --infile data/gene_sample.gff3 --fetch_type intron --filter 500  
PGSC0003DMB000000010	Cufflinks	intron	1243737	1244205	.	+	.	ID=PGSC0003DMI400000002;Parent=PGSC0003DMT400000001,PGSC0003DMT400000002;
PGSC0003DMB000000155	Cufflinks	intron	1100470	1102032	.	-	.	ID=PGSC0003DMI400001469;Parent=PGSC0003DMT400000757,PGSC0003DMT400000756,PGSC0003DMT400000758;
PGSC0003DMB000000155	Cufflinks	intron	1098704	1100195	.	-	.	ID=PGSC0003DMI400001470;Parent=PGSC0003DMT400000757,PGSC0003DMT400000756,PGSC0003DMT400000758;
PGSC0003DMB000000155	Cufflinks	intron	1097628	1098360	.	-	.	ID=PGSC0003DMI400001472;Parent=PGSC0003DMT400000757,PGSC0003DMT400000756,PGSC0003DMT400000758;
PGSC0003DMB000000155	Cufflinks	intron	1096255	1097509	.	-	.	ID=PGSC0003DMI400001473;Parent=PGSC0003DMT400000757,PGSC0003DMT400000756,PGSC0003DMT400000758;
PGSC0003DMB000000155	Cufflinks	intron	1094731	1095403	.	-	.	ID=PGSC0003DMI400001475;Parent=PGSC0003DMT400000757,PGSC0003DMT400000756,PGSC0003DMT400000758;
PGSC0003DMB000000155	Cufflinks	intron	1093967	1094636	.	-	.	ID=PGSC0003DMI400001476;Parent=PGSC0003DMT400000757,PGSC0003DMT400000756,PGSC0003DMT400000758;
```

Use case 5 example.  

```
michiel@bin206: java -jar GffQuery.jar --infile data/gff3_sample.gff3 --fetch_children HsG8283  
human15.1 . mRNA            214360  215771 . +   . Comments=fixed+one+splice+junction;Parent=HsG8283;Evidence=7000000069743825;Transcript_type=Novel_Transcript;Name=Novel+Transcript%2C+variant+%28partial%29;ID=HsT20206
human15.1 . CDS             214360  214441 . +   . Parent=HsT20206
human15.1 . CDS             215299  215444 . +   . Parent=HsT20206
human15.1 . CDS             215641  215766 . +   . Parent=HsT20206
human15.1 . three_prime_UT  215767  215771 . +   . Parent=HsT20206
```

Use case 6 example.  

```
michiel@bin206: java -jar GffQuery.jar --infile data/gene_sample.gff3 --fetch_region "1100000.."  
```

