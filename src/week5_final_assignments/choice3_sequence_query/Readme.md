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
  * --find_regex <REGEX_PATTERN>   Will report all sequences that contain the Regular expression pattern, 
    with the location and actual sequence found (see below for example output).
  * --find_organism <(PART OF) ORGANISM_NAME>  Will report all sequences having this wildcard string (a regex pattern)
    in the organism name
  * --find_description <WILDCARD-STRING>  Will report all sequences having this wildcard string (a regex pattern)
    in the description / sequence name 

Some of the possible use cases are listed below and in the example section (for most JUnit-tested use cases, example output is shown below):  

  1. ```java -jar SeqQuery --help```  
    Shows informative help/usage information  
  2. ```java -jar SeqQuery --input <INFILE> --summary```  
    Creates a textual summary of the parsed file: number of sequences, sequence type, average length (see below for an example) 
  3. ```java -jar SeqQuery --input <INFILE> --to_csv ";"```  
    Accepts a command-line argument specifying the (multi-)sequence file.
    Generates a nicely formatted csv listing with these columns ands the given character as separator:  
    * ACCNO: First accession
    * NAME: Name / descripion
    * ORGANISM: Organism
    * TYPE: Type (DNA, RNA, Protein)
    * LENGHT: Length
    * MOL_WEIGHT: Molecular weight
  4. ```java -jar SeqQuery --input <INFILE> --find_prosite <PROSITE_PATTERN>```  
    Reports which sequences have the given Prosite pattern.  
    Generates a nicely formatted csv listing with these columns and Tab as separator:  
    * ACCNO: First accession
    * NAME: Name / descripion
    * ORGANISM: Organism
    * TYPE: Type (DNA, RNA, Protein)
    * POSITION: Start position of match
    * SEQ: Actual sequence of match
  5. ```java -jar SeqQuery --input <INFILE> --find_regex <REGEX_PATTERN>```  
    Reports which sequences have the given regular expression pattern.
    Generates a nicely formatted csv listing with these columns and Tab as separator:  
    * ACCNO: First accession
    * NAME: Name / descripion
    * ORGANISM: Organism
    * TYPE: Type (DNA, RNA, Protein)
    * POSITION: Start position of match
    * SEQ: Actual sequence of match
  6. ```java -jar SeqQuery --input <INFILE> --find_organism <(PART OF) ORGANISM_NAME>```  
    Returns the sequences that have the given organism name (sub) string as-is (e.g. in Fasta format)  
  7. ```java -jar SeqQuery --input <INFILE> --find_id <ID>```  
    Returns the sequence with the given name as-is (e.g. in Fasta format)  
  8. ```java -jar SeqQuery --input <INFILE> --find_description <WILDCARD-STRING>```  
    Returns the sequences with the given pattern in the description as-is (e.g. in Fasta format)  
    


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
