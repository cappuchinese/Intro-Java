/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */
package week7_final_assignments.choice1_genbank_reader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import week1_2.AllSubstringsPrinter;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenBankReaderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testMain_use_case_2() {
        String[] args = new String[]{"--infile", "data/example_genbank_file.gb", "--summary"};
        String expectedPrint = 
                "file              example_genbank_file.gb" + System.lineSeparator() + 
                "organism          Saccharomyces cerevisiae" + System.lineSeparator() + 
                "accession         U49845" + System.lineSeparator() + 
                "sequence length   5028 bp" + System.lineSeparator() + 
                "number of genes   2" + System.lineSeparator() +
                "gene F/R balance  0.5" + System.lineSeparator() +
                "number of CDSs    3" + System.lineSeparator();
        GenBankReader.main(args);
        assertEquals("Testing command line \"java -jar GenBankReader.jar --infile data/example_genbank_file.gb --summary\"", expectedPrint, outContent.toString());
    }

    @Test
    public void testMain_use_case_3() {
        String[] args = new String[]{"--infile", "data/example_genbank_file.gb", "--fetch_gene", "AXL2"};
        String expectedPrintStart = 
                ">gene AXL2 sequence" + System.lineSeparator() + 
                "atgacacagcttcagatttcattattgctgacagctactatatcactactccatctagtagtggccacgccctatgaggc" + System.lineSeparator() + 
                "atatcctatcggaaaacaataccccccagtggcaagagtcaatgaatcgtttacatttcaaatttccaatgatacctata" + System.lineSeparator();
        
        String expectedPrintEnd = 
                "cggttaaagatggtgaaaatttttgctgggtccatagcatggaaccagacagaagaccaagtaagaaaaggttagtagat" +
                "ttttcaaataagagtaatgtcaatgttggtcaagttaaggacattcacggacgcatcccagaaatgctgtga";
        
        GenBankReader.main(args);
        assertTrue("Testing command line \"java -jar GenBankReader.jar --infile data/example_genbank_file.gb --fetch_gene AXL2\"", outContent.toString().startsWith(expectedPrintStart));
        assertTrue("Testing command line \"java -jar GenBankReader.jar --infile data/example_genbank_file.gb --fetch_gene AXL2\"", outContent.toString().endsWith(expectedPrintEnd));
    }

    @Test
    public void testMain_use_case_4() {
        String[] args = new String[]{"--infile", "data/example_genbank_file.gb", "--fetch_cds", "Rev7p"};
        String expectedPrint = 
                ">CDS REV7 sequence" + System.lineSeparator() + 
                "MNRWVEKWLRVYLKCYINLILFYRNVYPPQSFDYTTYQSFNLPQFVPINRHPALIDYIEELILDVLSKLTHVYRFSICII" + System.lineSeparator() + 
                "NKKNDLCIEKYVLDFSELQHVDKDDQIITETEVFDEFRSSLNSLIMHLEKLPKVNDDTITFEAVINAIELELGHKLDRNR" + System.lineSeparator() +
                "RVDSLEEKAEIERDSNWVKCQEDENLPDNNGFQPPKIKLTSLVGSDVGPLIIHQFSEKLISGDDKILNGVYSQYEEGESI" +
                "FGSLF";
        
        GenBankReader.main(args);
        assertEquals("Testing command line \"java -jar GenBankReader.jar --infile data/example_genbank_file.gb --fetch_cds Rev7p\"", expectedPrint, outContent.toString());
    }

    @Test
    public void testMain_use_case_5() {
        String[] args = new String[]{"--infile", "data/Haloarcula_marismortui_genome.gb", "--fetch_features", "5000..10000"};
        String expectedPrint = 
                "FEATURE;TYPE;START;STOP;ORIENTATION" + System.lineSeparator() + 
                "rrnB0003;gene;6187;6450;F" + System.lineSeparator() + 
                "hypothetical protein;CDS;6187;6450;F" + System.lineSeparator() +
                "cdc6b;gene;6826;8064;R" + System.lineSeparator() +
                "cell division control protein 6 homolog 1;CDS;6826;8064;R" + System.lineSeparator() +
                "rrnB0005;gene;9123;9221;F" + System.lineSeparator() +
                "hypothetical protein;CDS;9123;9221;F";
        
        GenBankReader.main(args);
        assertEquals("Testing command line \"java -jar GenBankReader.jar --infile data/Haloarcula_marismortui_genome.gb --fetch_features 5000..10000\"", expectedPrint, outContent.toString());
    }

    @Test
    public void testMain_use_case_6() {
        String[] args = new String[]{"--infile", "data/example_genbank_file.gb", "--find_sites", "AAARTTT"};
        String expectedPrint = 
                "POSITION;SEQUENCE;GENE" + System.lineSeparator() + 
                "2109;AAAATTT;AXL2" + System.lineSeparator() + 
                "3022;AAAATTT;AXL2" + System.lineSeparator() +
                "3358;AAAATTT;REV7" + System.lineSeparator() +
                "4138;AAAGTTT;INTERGENIC" + System.lineSeparator();
        
        GenBankReader.main(args);
        assertEquals("Testing command line \"java -jar GenBankReader.jar --infile data/example_genbank_file.gb --find_sites AAARTTT\"", expectedPrint, outContent.toString());
    }
}
