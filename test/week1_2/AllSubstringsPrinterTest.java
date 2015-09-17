/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
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
    private final AllSubstringsPrinter asp = new AllSubstringsPrinter();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testPrintAllSubstrings_A() {
        String stringToSubstring = "GATCG";
        boolean leftTruncated = true;
        boolean leftAligned = true;
        String expectedPrint = 
                "GATCG" + System.lineSeparator() + 
                "ATCG" + System.lineSeparator() + 
                "TCG" + System.lineSeparator() + 
                "CG" + System.lineSeparator() + 
                "G" + System.lineSeparator();
        asp.printAllSubstrings(stringToSubstring, leftTruncated, leftAligned);
        assertEquals(String.format("Testing substring printing with %s; leftTruncated=%b; leftAligned=%b ... ", stringToSubstring, leftTruncated, leftAligned), expectedPrint, outContent.toString());
    }

    @Test
    public void testPrintAllSubstrings_B() {
        String stringToSubstring = "GATCG";
        boolean leftTruncated = false;
        boolean leftAligned = true;
        String expectedPrint = 
                "GATCG" + System.lineSeparator() + 
                "GATC" + System.lineSeparator() + 
                "GAT" + System.lineSeparator() + 
                "GA" + System.lineSeparator() + 
                "G" + System.lineSeparator();
        asp.printAllSubstrings(stringToSubstring, leftTruncated, leftAligned);
        assertEquals(String.format("Testing substring printing with %s; leftTruncated=%b; leftAligned=%b ... ", stringToSubstring, leftTruncated, leftAligned), expectedPrint, outContent.toString());
    }
    
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
        assertEquals(String.format("Testing substring printing with %s; leftTruncated=%b; leftAligned=%b ... ", stringToSubstring, leftTruncated, leftAligned), expectedPrint, outContent.toString());
    }

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
        assertEquals(String.format("Testing substring printing with %s; leftTruncated=%b; leftAligned=%b ... ", stringToSubstring, leftTruncated, leftAligned), expectedPrint, outContent.toString());
    }
}
