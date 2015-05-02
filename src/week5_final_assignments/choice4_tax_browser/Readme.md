# Final assignment 3: Developing a Taxonomy Browser #

## Special challenge of this assignment: tree implementation and traversals (recursion) ##

## Assignment details ##
The NCBI taxonomy is the most widely used source regarding Taxonomy information.  
It holds the Taxonomic information for all living organisms that have sequence information 
associated with it. You can browse the Taxonomy Database online at [Taxonomy](http://www.ncbi.nlm.nih.gov/Taxonomy/Browser/wwwtax.cgi)
The raw data for this database can be downloaded via ftp as a zip file [here](ftp://ftp.ncbi.nih.gov/pub/taxonomy/taxdmp.zip).
This archive contains nine files, but only three are relevant to this assignment:  

  * names.dmp
  * nodes.dmp
  * readme.txt

The readme contains useful information, but the names and nodes files contain the core Taxonomy database. 
You do not need to ectract a zip - Java can easily read from zip files.  
See an example [here](http://www.thecoderscorner.com/team-blog/java-and-jvm/12-reading-a-zip-file-from-java-using-zipinputstream)):
You will need to extract these datafields from the archive:  

  * tax ID
  * parent tax ID
  * scientific name
  * only the number of subspecies for a species node (RAM may be a problem on older PCs)
  * taxonomic rank (e.g. species, class, order etc)  

It is your job to build an appropriate datamodel and functionality to be able to support the folowing use cases relating to the Taxonomy.
**PS  use JVM arguments -Xmx and -Xms to increase heap space usage - the taxonomy DB is BIG**

Finally, create an executable that can be used in these ways:  
  1. ```java -jar TaxonomyBrowser --help```  
    shows informative help/usage information 
  2. ```java -jar TaxonomyBrowser.jar  --infile <INFILE> --tax_id 12345```  
   This will list all information available for the node with the given taxID: 
   taxID, parentTaxID, taxonomic rank, scientific name and number of child nodes under this node  
  3. ```java -jar TaxonomyBrowser.jar  --infile <INFILE> --list 12345 --sort <SORT_TYPE>```
    This will list (in short format) all nodes residing under this node, using the requested sorting type. 
    Options for sorting are:  taxID, scientific name, taxonomic rank and number of child nodes.  
  4. ```java -jar TaxonomyBrowser.jar  --infile <INFILE> --rank <TAXONOMIC RANK> --limit 10```
    This will list all nodes with the given taxonomic rank (eg. rank Order) alphabetically, 
    up to the maximum indicated with limit (if no limit is given, list all).


**Use case 2 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit.fasta --summary  
file                     fhit.fasta  
sequence types           PROTEIN  
number of sequences      22  
average sequence length  149.0  
```

**Use case 3 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit_sample.fasta --to_csv ";"  
ACCNO;NAME;ORGANISM;TYPE;LENGHT;MOL_WEIGHT  
gi|21595364;FHIT protein;Homo sapiens;PROTEIN;147;16829.6  
gi|15215093;Fhit protein;Mus musculus;PROTEIN;150;17206.7  
gi|151554847;FHIT protein;Bos taurus;PROTEIN;149;16922.6  
gi|256665365;fragile histidine triad protein;Ovis aries;PROTEIN;149;16858.5  
gi|11120730;bis(5'-adenosyl)-triphosphatase;Rattus norvegicus;PROTEIN;150;17318.8  
```


**Use case 4 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit_sample.faa --find_prosite "H-x-H-x-H-[VI]"    
ACCNO;NAME;ORGANISM;TYPE;POSITION;SEQ  
gi|21595364;FHIT protein;Homo sapiens;PROTEIN;94;HVHVHV  
gi|15215093;Fhit protein;Mus musculus;PROTEIN;94;HVHVHV  
gi|151554847;FHIT protein;Bos taurus;PROTEIN;94;HVHVHI  
gi|256665365;fragile histidine triad protein;94;HVHIHV 
gi|11120730;bis(5'-adenosyl)-triphosphatase;Rattus norvegicus;PROTEIN;HVHVHI  
```

**Use case 5 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit_sample.faa --find_regex "H.H.H[VI]"    
ACCNO;NAME;ORGANISM;TYPE;POSITION;SEQ  
gi|21595364;FHIT protein;Homo sapiens;PROTEIN;94;HVHVHV  
gi|15215093;Fhit protein;Mus musculus;PROTEIN;94;HVHVHV  
gi|151554847;FHIT protein;Bos taurus;PROTEIN;94;HVHVHI  
gi|256665365;fragile histidine triad protein;94;HVHIHV 
gi|11120730;bis(5'-adenosyl)-triphosphatase;Rattus norvegicus;PROTEIN;HVHVHI  
```

**Use case 6 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit.faa --find_organism "sulfov"    
>gi|283850734|ref|ZP_06368021.1| histidine triad (HIT) protein [Desulfovibrio sp. FW1012B]
MEVLWAPWRMDYILGPKPDACVFCLPENRDEDRDRLVLARGCHTFVIMNKFPYNSGHLMVTPVRHVSCLT
ELAAAESGELTAGLAYCTRVLKEALRPQGINIGLNLGEAAGAGIAAHLHFQIVPRWNGDSSFMAVFGETR
IVPQLLLSTYDRLLPFFTDYPATVTS
>gi|332704143|ref|ZP_08424231.1| histidine triad (HIT) protein [Desulfovibrio africanus str. Walvis Bay]
MDVLWAPWRMDYILGPKPDECVFCVPSNTAEDEERKILARGRLCYVIMNKYPYNSGHLMVAPYRHVSCLT
DLTAEERQEVMEYVTRCVSVIKEAMRPQGVNAGLNLGEAAGAGIAAHLHFQLVPRWNGDASFMAVFGETR
VIPDHLMATYSRLKPYFETSRN
>gi|317153259|ref|YP_004121307.1| histidine triad (HIT) protein [Desulfovibrio aespoeensis Aspo-2]
MEVLWAPWRLNYILGPKPDECVFCIPEDQAQDEERCILARGRYCFVIMNKFPYNNGHLMVTPYRHVSSLL
DLSLEESNDCMLWLRHSTSVLEQAFHPHGINMGLNLGEAAGAGIAQHMHFQIVPRWNGDASFMAVFGETT
VIPEHLSSTYARLRPLFDAITS
...30 more matches omitted
```

**Use case 7 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit.faa --find_id "gb|ADE57962.1"    
>gi|293617808|gb|ADE57962.1| histidine triad (HIT) protein [Aminobacterium colombiense DSM 12261]
MESIFAPWRMTYIADADKQKTCIFCEFPKKNEDEKNLILHRGTMCFVICNAFPYNPGHLMVAPYRHTAVY
EELSDEELLEMHRLGGVCLKVLKKVMHPQGFNLGINLGKVGGAGFDGHLHLHIVPRWNGDTNFMPVLAET
RVIAESLEQTYKRLRDEWPLNDC
```

**Use case 8 example:**  

```
michiel@bin206: java -jar SeqQuery.jar --infile data/fhit.faa --find_description "[Hh]istidine"    
>gi|3243136|gb|AAC23967.1| fragile histidine triad protein [Mus musculus]
MSFRFGQHLIKPSVVFLKTELSFALVNRKPVVPGHVLVCPLRPVERFRDLHPDEVADLFQVTQRVGTVVE
KHFQGTSITFSMQDGPEAGQTVKHVHVHVLPRKAGDFPRNDNIYDE
>gi|9587672|gb|AAF89328.1|AF170064_1 fragile histidine triad protein [Rattus norvegicus]
MSFKFGQHLIKPSVVFLKTELSFALVNRKPVVPGHVLMCPLRPVERFRDLRPDEVADLFQVTQRVGTVVE
KHFQGTSITFSMQDGPEAGQTVKHVHVHILPRKSGDFRRNDNIYDELQKHDREEEDSPAFWRSEEEMAAE
AEVLRAYFQA
>gi|3264590|gb|AAC24566.1| fragile histidine triad protein [Mus musculus]
MSFRFGQHLIKPSVVFLKTELSFALVNRKPVVPGHVLVCPLRPVERFRDLHPDEVADLFQVTQRVGTVVE
KHFQGTSITFSMQDGPEAGQTVKHVHVHVLPRKAGDFPRNDNIYDELQKHDREEEDSPAFWRSEKEMAAE
AEALRVYFQA
...710 more matches omitted
```
