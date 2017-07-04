# Final assignment 2: Developing a GFF file query app #

## Special challenge of this assignment: applying and combining filters ##

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

You can find some example files in the "data" folder of this project (they all have the extension ".gff3".  
Create a filter/parser for files in GFF3 format, and implement the given use cases.
You may notice that this assignment is all about filtering data in different filter combinations. 
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

  1. ```java -jar GffQuery --help```  
     shows informative help/usage information  
  2. ```java -jar GffQuery.jar –infile <INFILE> --summary```  
     Creates a textual summary of the parsed file: names of molecules with annotations, types and counts of features.  
  3. ```java -jar GffQuery.jar --infile  <INFILE> --fetch_type <TYPE>```  
     Returns a GFF3-type listing of all features of this type  
  4. ```java -jar GffQuery.jar --infile <INFILE> --fetch_type  <TYPE> --filter <FILTER>```  
     Returns a GFF3-type listing of all features of this type, but filtered according to the filter (see above). 
  5. ```java -jar GffQuery.jar --infile <INFILE> --fetch_children <PARENT ID>```  
     Returns a GFF3-type listing RECURSIVELY as GFF3-type listing that have the given Parent ID as ancestor (parent or parents parent!).  
  6. ```java -jar GffQuery.jar --infile <INFILE> --fetch_region <COORDINATES>```  
     Returns a GFF3-type listing of all features that lie completely between the given coordinates
  7. ```java -jar GffQuery.jar --infile <INFILE> --fetch_region <COORDINATES> --filter <FILTER>``` 
     Returns a GFF3-type listing of all features that lie completely between the given coordinates, but with the given filter applied.
  8. ```java -jar GffQuery.jar --infile <INFILE> --find_wildcard <WILDCARD STRING>```  
     Lists all features that have the given wildcard string (a regex string) in the Name attribute (part of field 9)


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
michiel@bin206: java -jar GffQuery.jar --infile data/gene_sample.gff3 --fetch_type intron --filter "*|*|*|500|*"  
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

Use case 6 example. Selects all feature between 250000 and 260000  

```
michiel@bin206: java -jar GffQuery.jar --infile data/potato_pseudomolecule_sample.gff3 --fetch_region "250000..260000"
ST4.03ch01	Cufflinks	mRNA	250845	265748	.	-	.	ID=PGSC0003DMT400058653;Parent=PGSC0003DMG400022786;Source_id=RNASEQ39.8879.0;Mapping_depth=160.298817;Class=2;name="Plasmalemma Na+/H+ antiporter"
ST4.03ch01	Cufflinks	exon	250845	251443	.	-	.	ID=PGSC0003DME400154360;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks	exon	251929	252233	.	-	.	ID=PGSC0003DME400154362;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks	exon	252918	253185	.	-	.	ID=PGSC0003DME400154365;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	253806	254012	.	-	.	ID=PGSC0003DME400154366;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	254096	254314	.	-	.	ID=PGSC0003DME400154367;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	254408	254539	.	-	.	ID=PGSC0003DME400154368;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	254827	254924	.	-	.	ID=PGSC0003DME400154369;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	255808	256110	.	-	.	ID=PGSC0003DME400154370;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	256427	256658	.	-	.	ID=PGSC0003DME400154371;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	257433	257540	.	-	.	ID=PGSC0003DME400154372;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	257653	257700	.	-	.	ID=PGSC0003DME400154373;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	257815	257999	.	-	.	ID=PGSC0003DME400154374;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	259062	259117	.	-	.	ID=PGSC0003DME400154375;Parent=PGSC0003DMT400058653
ST4.03ch01	Cufflinks/GLEAN	exon	259678	259722	.	-	.	ID=PGSC0003DME400154376;Parent=PGSC0003DMT400058653 
```

Use case example. Selects all gene features between 250000 and 300000  

```
michiel@bin206: java -jar GffQuery.jar --infile data/potato_pseudomolecule_sample.gff3 --fetch_type gene --fetch_region "250000..300000" --filter "*|*|*|500|*"
ST4.03ch01	BGI	gene	250845	265748	.	.	.	ID=PGSC0003DMG400022786;name="Plasmalemma Na+/H+ antiporter"
ST4.03ch01	BGI	gene	266476	273873	.	.	.	ID=PGSC0003DMG400022766;name="Protein kinase"
ST4.03ch01	BGI	gene	276814	280162	.	.	.	ID=PGSC0003DMG400022767;name="Transmembrane transporter"
ST4.03ch01	BGI	gene	283995	286543	.	.	.	ID=PGSC0003DMG400022768;name="UPF0497 membrane protein PIMP1"
```

Use case example. Selects all mRNA features with "kinase" or "Kinase" in the name between 250000 and 300000

```
michiel@bin206: java -jar GffQuery.jar --infile data/potato_pseudomolecule_sample.gff3 --fetch_type mRNA --fetch_region "250000..300000" --find_wildcard "[Kk]inase"
ST4.03ch01	Cufflinks	mRNA	266476	273873	.	+	.	ID=PGSC0003DMT400058597;Parent=PGSC0003DMG400022766;Source_id=RNASEQ39.8890.0;Mapping_depth=14.047011;Class=1;name="Protein kinase"
ST4.03ch01	Cufflinks	mRNA	266476	273873	.	+	.	ID=PGSC0003DMT400058598;Parent=PGSC0003DMG400022766;Source_id=RNASEQ39.8890.1;Mapping_depth=420.967308;Class=1;name="Protein kinase"
ST4.03ch01	Cufflinks	mRNA	267315	273858	.	+	.	ID=PGSC0003DMT400058600;Parent=PGSC0003DMG400022766;Source_id=RNASEQ39.8890.3;Mapping_depth=21.280509;Class=1;name="Protein kinase"
ST4.03ch01	Cufflinks	mRNA	268805	273858	.	+	.	ID=PGSC0003DMT400058601;Parent=PGSC0003DMG400022766;Source_id=RNASEQ39.8890.4;Mapping_depth=21.328241;Class=1;name="Protein kinase"
ST4.03ch01	Cufflinks	mRNA	272577	273858	.	+	.	ID=PGSC0003DMT400058602;Parent=PGSC0003DMG400022766;Source_id=RNASEQ39.8890.5;Mapping_depth=9.797389;Class=1;name="Protein kinase"
```

