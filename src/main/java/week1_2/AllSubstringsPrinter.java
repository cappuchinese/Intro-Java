/*
 * Copyright (c) 2014 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package week1_2;

/**
 *
 * @author michiel
 */
public class AllSubstringsPrinter {
    /**
     * main method serves development purposes only.
     * @param args the args
     */
    public static void main(final String[] args) {
        AllSubstringsPrinter asp = new AllSubstringsPrinter();
        asp.printAllSubstrings("GATCG", true, true); //should print left truncated, left aligned
    }

    /**
     * will print all possible substrings according to arguments.
     * @param stringToSubstring the string to substring
     * @param leftTruncated flag to indicate whether the substrings should be truncated from the left (or the right)
     * @param leftAligned flag to indicate whether the substrings should be printed left-aligned (or right-aligned)
     */
    public void printAllSubstrings(
            final String stringToSubstring,
            final boolean leftTruncated,
            final boolean leftAligned) {
        //your code
    }
}
