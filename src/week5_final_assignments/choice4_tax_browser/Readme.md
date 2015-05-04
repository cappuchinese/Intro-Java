# Final assignment 4: Developing a Taxonomy Browser #

## Special challenge of this assignment: tree implementation and traversals (recursion) ##

## Assignment details ##
The NCBI taxonomy is the most widely used source regarding Taxonomy information.  
It holds the Taxonomic information for all living organisms that have sequence information 
associated with it. You can browse the Taxonomy Database online at [Taxonomy](http://www.ncbi.nlm.nih.gov/Taxonomy/Browser/wwwtax.cgi)
The raw data for this database can be downloaded via ftp as a zip file [here](ftp://ftp.ncbi.nih.gov/pub/taxonomy/taxdmp.zip).  
However, for testing purposes, you will need to use the archive provided as download from this project repo, 
[here](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads):
This archive contains nine files, but only three are relevant to this assignment:  

  * names.dmp
  * nodes.dmp
  * readme.txt

The readme contains useful information, but the names.dmp and nodes.dmp files contain the core Taxonomy database. 
You do not need to ectract a zip manually before reading file contents - Java can easily read from zip files.  
See for an example [here](http://www.thecoderscorner.com/team-blog/java-and-jvm/12-reading-a-zip-file-from-java-using-zipinputstream)).
You will need to extract these datafields from the archive:  

  * tax ID
  * parent tax ID
  * scientific name
  * taxonomic rank (e.g. species, class, order etc)  

It is your job to build an appropriate datamodel and functionality to be able to support the folowing use cases relating to the Taxonomy.
**PS: Use JVM arguments -Xmx and -Xms to increase heap space usage - the taxonomy DB is BIG**
**PS: RAM may be a problem on older or more basic PCs**

For instance, this will run the program with initial 512 MB and maximum of 4 GB heap space:  
```
java -Xms512m -Xmx4g -jar TaxBrowser.jar  --infile <INFILE> --tax_id 12345
```

You can also set these JVM arguments within NetBeans under project Properties --> Run --> VM options!  

Now, create an executable that can be used in these ways:  

  1. ```java -jar TaxBrowser.jar --help```  
    shows informative help/usage information
  2. ```java -jar TaxBrowser.jar  --archive <TAXDUMP ARCHIVE> --summary```  
   Creates a textual summary of the Taxonomy archive: download date, number of nodes (see example).  
  3. ```java -jar TaxBrowser.jar  --archive <TAXDUMP ARCHIVE> --tax_id 12345```  
   This will list all information available for the node with the given taxID: 
   taxID, parentTaxID and name, taxonomic rank, scientific name and number of child nodes under this node (see example).  
  4. ```java -jar TaxBrowser.jar  --infile <INFILE> --list 12345 --sort <SORT_TYPE> --omit_subspecies```
    This will list (in short format - see example) all nodes residing under this node, using the requested sorting type and omitting subspecies. 
    Options for sorting are:  
    * TAX_ID sorts on taxonomy ID (numeric sort)  
    * SCI_NAME sors on scientific name (alphabetical sort)  
    * TAX_RANK sorts on taxonomic rank (using ordering in tree, from root to leaf)  
    * CHILD_NODES sorts on number of child nodes (numerical sort)   
  5. ```java -jar TaxBrowser.jar  --infile <INFILE> --rank <TAXONOMIC RANK> --limit 10```
    This will list all nodes with the given taxonomic rank (eg. rank Order) alphabetically, 
    up to the maximum indicated with limit (if no limit is given, list all).


**Use case 2 example:**  

```
michiel@bin206: java -Xmx2g -jar TaxBrowser.jar --infile data/taxdmp.zip --summary  
file              taxdmp.zip  
download date     2015-05-04  
number of nodes   1280232
```

**Use case 3 example:**  

```
michiel@bin206: java -Xmx2g -jar TaxBrowser.jar --archive data/taxdmp.zip --tax_id 9606  
tax ID                  9606
scientific name         Homo sapiens
rank                    species
parent tax ID           9605
parent scientific name  Homo
parent rank             genus
children                2
```

**Use case 4 example:**  

```
michiel@bin206: java -Xmx2g -jar TaxBrowser.jar --archive data/taxdmp.zip --list 12345 --sort TAX_RANK --omit_subspecies   
TAX_ID;PARENT_TAX_ID;RANK;SCIENTIFIC NAME;CHILD NUMBER  
9604;314295;family;Hominidae;2
207598;9604;subfamily;Homininae;3
607660;9604;subfamily;Ponginae;1
9592;207598;genus;Gorilla;2
9596;207598;genus;Pan;2
9605;207598;genus;Homo;2
9599;607660;genus;Pongo;4
9593;9592;species;Gorilla gorilla;3
499232;9592;species;Gorilla beringei;2
9597;9596;species;Pan paniscus;0
...listing continues
```

**Use case 5 example:**  

```
michiel@bin206: java -Xmx2g -jar TaxBrowser.jar --archive data/taxdmp.zip --rank <TAXONOMIC RANK> --limit 10   
TAX_ID;PARENT_TAX_ID;RANK;SCIENTIFIC NAME;CHILD NUMBER  
```

**Use case 6 example:**  
