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
You can find some example files in the "data" folder of this NetBeans project.  
Do not remove the data from this folder -- this is where the test environment needs the test files!  
Create a parser for files in GFF3 format, extracting all annotations, and implement the following use cases
(for all JUnit-tested use cases, example output is shown below):

  1. java -jar GffQuery --help  
     shows informative help/usage information  
  2. java -jar GffQuery.jar –infile <INFILE> --summary  
     Creates a textual summary of the parsed file: length of the sequence, number and types of annotations.  
     Average lengths of the genes, and forward/reverse balance.  
     **NB: the F/R balance is the number on the forward strand divided by the total number**  
  3. java -jar GffQuery.jar --infile  <INFILE> --fetch_type <TYPE>  
     Returns a GFF3-type listing of all features of this type   
  4. java -jar GffQuery.jar --infile <INFILE> --fetch_type  <TYPE> --filter <SCORE, ORIENTATION OR MINIMUM LENGTH >  
     Lists all features that have the given wildrcard string in the Name attribute (part of field 9)
  5. java -jar GffQuery.jar --infile <INFILE> --fetch_children <PARENT ID>  
     Lists all children (as shown below) that have the given Parent ID as parent.    
  6. java -jar GffQuery.jar --infile <INFILE> --fetch_region <COORDINATES>  
     Returns all features that lie completely between the given coordinates, as shown below  
  7. java -jar GffQuery.jar --infile <INFILE> --find_wildcard <WILDCARD STRING>  
     Lists all features that have the given wildrcard string in the Name attribute (part of field 9)


 
```
michiel@bin206: java -jar GenBankReader.jar --infile example_genbank_file.gb --find_sites AAARTTT 
site search: AAARTTT (regex: AAA[AG]TTT)
POSITION;SEQUENCE;GENE  
2109;AAAATTT;AXL2  
3022;AAAATTT;AXL2  
3358;AAAATTT;REV7  
4138;AAAGTTT;INTERGENIC  
```

