/*
 * Copyright (c) 2014 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package week1_2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author michiel
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllSubstringsPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AllSubstringsPrinter asp = new AllSubstringsPrinter();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    /**
     * Test of printAllSubstrings method, of class AllSubstringsPrinter.
     */
    @Test
    public void testPrintAllSubstrings_A() {
        String stringToSubstring = "CGATCC";
        boolean leftTruncated = true;
        boolean leftAligned = true;
        String expectedPrint = 
                "GATCG" + System.lineSeparator() + 
                "ATCG" + System.lineSeparator() + 
                "TCG" + System.lineSeparator() + 
                "CG" + System.lineSeparator() + 
                "G" + System.lineSeparator();
        asp.printAllSubstrings(stringToSubstring, leftTruncated, leftAligned);
        assertEquals(expectedPrint, outContent.toString());
    }
    
    /**
     * Test of printAllSubstrings method, of class AllSubstringsPrinter.
     */
    @Test
    public void testPrintAllSubstrings_B() {
        String stringToSubstring = "CGATCC";
        boolean leftTruncated = false;
        boolean leftAligned = true;
        String expectedPrint = 
                "GATCG" + System.lineSeparator() + 
                "GATC" + System.lineSeparator() + 
                "GAT" + System.lineSeparator() + 
                "GA" + System.lineSeparator() + 
                "G" + System.lineSeparator();
        asp.printAllSubstrings(stringToSubstring, leftTruncated, leftAligned);
        assertEquals(expectedPrint, outContent.toString());
    }
    
    /**
     * Test of printAllSubstrings method, of class AllSubstringsPrinter.
     */
    @Test
    public void testPrintAllSubstrings_C() {
        String stringToSubstring = "AGCGCT";
        boolean leftTruncated = true;
        boolean leftAligned = false;
        String expectedPrint = 
                "AGCGCT" + System.lineSeparator() + 
                " AGCGC" + System.lineSeparator() + 
                "  AGCG" + System.lineSeparator() + 
                "   AGC" + System.lineSeparator() + 
                "    AG" + System.lineSeparator() + 
                "     A" + System.lineSeparator();
        asp.printAllSubstrings(stringToSubstring, leftTruncated, leftAligned);
        assertEquals(expectedPrint, outContent.toString());
    }

    /**
     * Test of printAllSubstrings method, of class AllSubstringsPrinter.
     */
    @Test
    public void testPrintAllSubstrings_D() {
        String stringToSubstring = "AGCGCT";
        boolean leftTruncated = true;
        boolean leftAligned = false;
        String expectedPrint = 
                "AGCGCT" + System.lineSeparator() + 
                " GCGCT" + System.lineSeparator() + 
                "  CGCT" + System.lineSeparator() + 
                "   GCT" + System.lineSeparator() + 
                "    CT" + System.lineSeparator() + 
                "     T" + System.lineSeparator();
        asp.printAllSubstrings(stringToSubstring, leftTruncated, leftAligned);
        assertEquals(expectedPrint, outContent.toString());
    }
    
}
