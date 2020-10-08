/*
 * Copyright (c) 2014 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package section2_syntax.part3_flow_control;

import java.util.*;

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
//        asp.printAllSubstrings4("GATCG", true, false); //should print left truncated, left aligned
        asp.printSubstringsLeftAlignedLeftTruncated("GATCCG");


//        List<Object> elements = new ArrayList<>();
//        elements.contains(someObject);
//
//        Set<Object> elementsSet = new HashSet<>();
//        elementsSet.contains(someObject);
    }

    /**
     * Given a String object, it should print all possible substrings of it where
     * in each iteration the rightmost character is left out.
     * @param stringToSubstring the string to substring
     */
    public void printSubstringsLeftAlignedLeftTruncated(String stringToSubstring) {
//        int stringLen = stringToSubstring.length();
//        for (int i = 0; i < stringLen; i++) {
//            System.out.println(stringToSubstring.substring(i, stringLen));
//        }
        printAllSubstrings(stringToSubstring, true, true);
    }

    /**
     * Prints all possible substrings according to arguments. You can make use of {@link #createSpacer(int length) createSpacer} method.
     * @param stringToSubstring the string to substring
     * @param leftTruncated flag to indicate whether the substrings should be truncated from the left (or the right)
     * @param leftAligned flag to indicate whether the substrings should be printed left-aligned (or right-aligned)
     *
     * Code Jamie van Eijk (Thanks!)
     */
    public void printAllSubstrings(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        int stringLen = stringToSubstring.length();
        if(leftTruncated){
            if(leftAligned){
                //copied from printSubstringsLeftAlignedLeftTruncated()
                for(int i = 0; i < stringLen; i++) {
                    System.out.println(stringToSubstring.substring(i, stringLen));
                }
//                printSubstringsLeftAlignedLeftTruncated(stringToSubstring);
            }
            else{
                for(int i=0; i < stringLen; i++){
                    System.out.println(createSpacer(i)+stringToSubstring.substring(i, stringLen));
                }
            }
        }
        if(!leftTruncated){
            if(leftAligned){
                for(int i = stringLen; i > 0; i--){
                    System.out.println(stringToSubstring.substring(0, i));
                }
            }
            else{
                int x = 0;
                for(int i = stringLen; i > 0; i--){
                    System.out.println(createSpacer(x)+stringToSubstring.substring(0, i));
                    x += 1;
                }
            }
        }
    }

    public void printAllSubstrings2(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        if (leftTruncated) {
            for (int i = 0; i < stringToSubstring.length(); i++) {
                String spacer = "";
                if (!leftAligned) {
                    spacer = createSpacer(i);
                }
                System.out.println(spacer + stringToSubstring.substring(i));
            }
        } else {
            for (int i = 0; i < stringToSubstring.length(); i++) {
                String spacer = "";
                if (!leftAligned) {
                    spacer = createSpacer(i);
                }
                System.out.println(spacer + stringToSubstring.substring(0, stringToSubstring.length() - i));
            }
        }
    }

    public void printAllSubstrings3(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        if (leftTruncated) {
            for (int i = 0; i < stringToSubstring.length(); i++) {
                String spacer = getSpacer(leftAligned, i);
                System.out.println(spacer + stringToSubstring.substring(i));
            }
        } else {
            for (int i = 0; i < stringToSubstring.length(); i++) {
                String spacer = getSpacer(leftAligned, i);
                System.out.println(spacer + stringToSubstring.substring(0, stringToSubstring.length() - i));
            }
        }
    }

    private String getSpacer(boolean leftAligned, int length) {
        String spacer = "";
        if (!leftAligned) {
            spacer = createSpacer(length);
        }
        return spacer;
    }

    public void printAllSubstrings4(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        for (int i = 0; i < stringToSubstring.length(); i++) {
            String spacer = getSpacer(leftAligned, i);
            if (leftTruncated) {
                System.out.println(spacer + stringToSubstring.substring(i));
            } else {
                System.out.println(spacer + stringToSubstring.substring(0, stringToSubstring.length() - i));
            }
        }
    }

    public void printAllSubstrings5(String stringToSubstring, boolean leftTruncated, boolean leftAligned) {
        for (int i = 0; i < stringToSubstring.length(); i++) {
            String spacer = getSpacer(leftAligned, i);
            final int start = leftTruncated ? i : 0;
            final int end = stringToSubstring.length() - (leftTruncated ? 0 : i);
            System.out.println(spacer + stringToSubstring.substring(start, end));
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
//        String spacer = "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            sb.append(" ");
//            spacer += " ";
//            spacer = spacer + " ";
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
