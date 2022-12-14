/*
 * Copyright (c) 2014 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package section2_syntax.part3_flow_control;

/**
 *
 * @author michiel
 */
public class AllSubstringsPrinter {
    /**
     * main method serves development purposes only.
     * @param args the args
     */
    public static void main(String[] args) {
        final AllSubstringsPrinter asp = new AllSubstringsPrinter();
        asp.printAllSubstrings("GATCG", true, false); //should print left truncated, left aligned
    }

    /**
     * Given a String object, it should print all possible substrings of it where
     * in each iteration the rightmost character is left out.
     * @param stringToSubstring the string to substring
     */
    public void printSubstringsLeftAlignedLeftTruncated(String stringToSubstring) {
        for (int i = 0; i < stringToSubstring.length(); i++) {
            System.out.println(stringToSubstring.substring(i));
        }
    }

    /**
     * Prints all possible substrings according to arguments. You can make use of {@link #createSpacer(int length) createSpacer} method.
     * @param stringToSubstring the string to substring
     * @param leftTruncated flag to indicate whether the substrings should be truncated from the left (or the right)
     * @param leftAligned flag to indicate whether the substrings should be printed left-aligned (or right-aligned)
     */
    public void printAllSubstrings(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        if (leftAligned & leftTruncated) {
            printSubstringsLeftAlignedLeftTruncated(stringToSubstring);
        } else if (leftAligned & !leftTruncated) {
            for (int i = stringToSubstring.length(); i > 0; i--) {
                System.out.println(stringToSubstring.substring(0, i));
            }
        } else if (!leftTruncated) {
            for (int i = stringToSubstring.length(); i > 0; i--) {
                String spacer = createSpacer(stringToSubstring.length() - i);
                System.out.println(spacer + stringToSubstring.substring(0, i));
            }
        } else {
            for (int i = 0; i < stringToSubstring.length(); i++) {
                String spacer = createSpacer(i);
                System.out.println(spacer + stringToSubstring.substring(i));
            }
        }
    }

    /**
     * Creates a spacer of given length. This solution uses a StringBuilder which is the correct way to concatenate
     * Strings in Java.
     *
     * @param length the spacer length, in number of spaces
     * @return spacer
     */
    public String createSpacer(int length) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
//        return spacer;
        return sb.toString();
    }

    /**
     * THIS IS AN EXAMPLE OF HOW NOT TO DO IT!!
     * String concatenation in for-loops is *evil*
     * @param length
     * @return spacer
     */
    private String createSpacerTheWrongWay(int length) {
        String spacer = "";
        for (int i = 0; i < length; i++) {
            spacer += " ";
        }
        return spacer;
    }
}
