# Final assignment 4: Developing a Taxonomy Browser #

## Special challenge of this assignment: algorithm development ##

## Assignment details ##
Finding conserved patterns in biological sequences is by no means a trivial task. Therefore, for this assignment I do 
not expect you to deliver something perfect. However, I do expect you to give it your best shot.
One application for this problem is finding conserved patterns that can be used for designing (q)PCR primers or array
 probes. These primers or probes are usually between 17 and 25 nucleotides long.  

As input you should require Multiple Sequence Alignment (MSA) files in Nucleotide Fasta format, 
like [this](http://emboss.sourceforge.net/docs/themes/alnformats/align.fasta). 
The downloads section and data directory of this repo have one such file: rdp_download_20seqs.fa. 
Use Clustal Omega [here](http://www.ebi.ac.uk/Tools/msa/clustalo/) to generate more test and sample data, 
or fetch them from the [Ribosomal Database Project](http://rdp.cme.msu.edu/).
Study this format well before proceeding!

In this assignment, I suggest you start with building a \"conservation profile\" using the 
[IUPAC ambiguity codes](http://droog.gs.washington.edu/parc/images/iupac.html) and from this, select the best 
region suitable as probe. You do not need to take into account probe design parameters such as GC content,
 melting temperature etc.  Simply find the most specific region that may be suitable for detecting the sequences 
 in the given collection with PCR or array.  

 
It is your job to build an appropriate datamodel and functionality to be able to support the described use cases.

Now, create an executable that can be used in the ways outlined below.   

  1. ```java -jar ProbeDesigner.jar --help```  
    shows informative help/usage information
  2. ```java -jar ProbeDesigner.jar  --input <input file> --summary```  
   Creates a textual summary of the input file: number of sequences, length of the MSA (e.g. the number of aligned 
   positions), number of unchanged residues and number of conserved residues, split out into all possible IUPAC
    ambiguity codes.  
  3. ```java -jar ProbeDesigner.jar  --input <input file> --design```  
   Using the input file, list the best possible probe sequences using default settings.  
  4. ```java -jar ProbeDesigner.jar  --input <input file> --design <DESIGN OPTIONS>```  
   As above, but with specified options for:  

    * --max_number Maximum nuber of probes to report (default = 5)  
    * --min_length The minimum length of probes (default = 12) 
    * --max_length The maximum length of probes (default = 27)  


**Use case 2 example:**  

```
michiel@bin206: java -jar ProbeDesigner.jar --input data/some_MSA_file.fa --summary  
file                 some_MSA_file.fa  
download date        2016-05-04  
length               120
unchanged residues   42
R residues (A/G)     18
N residues (G/A/T/C) 13
W residues (A/T)     12
Y residues (C/T)     11
...
```

**Use case 3 example:**  

```
michiel@bin206: java -jar ProbeDesigner.jar --input data/some_MSA_file.fa --design  
START   LENGTH  PROBE_SEQ  
22      16      GTRTTYNGAWCTTTGC
...
```

