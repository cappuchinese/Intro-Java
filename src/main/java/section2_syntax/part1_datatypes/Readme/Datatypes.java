package section2_syntax.part1_datatypes.Readme;

/**
 * Creation date: May 28, 2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
public class Datatypes {
    /*
    * For the following couple of methods, simply return the name of the datatype that best suits
    * the given use case, as efficiently as possible.
    * Choose from
    *   - boolean
    *   - char
    *   - byte
    *   - short
    *   - int
    *   - long
    *   - double
    *   - float
    *   - String
    *
    * The first one has already been implemented as example.
    */

    String correctDataType0() {
        //USE CASE / USAGE:
        //Number of days within a year
        return "short";
    }

    String correctDataType1() {
        //USE CASE / USAGE:
        //Age of the universe in whole years
        return null;
    }

    String correctDataType2() {
        //USE CASE / USAGE:
        //Turnover of ATP in a cell, in Molar per minute
        return null;
    }

    String correctDataType3() {
        //USE CASE / USAGE:
        //Molecular weight of a protein, in Daltons
        return null;
    }

    String correctDataType4() {
        //USE CASE / USAGE
        // the live/death status of a test animal
        return null;
    }

    String correctDataType5() {
        //USE CASE / USAGE
        // the name of an app user
        return null;
    }
    String correctDataType6() {
        //USE CASE / USAGE
        // encoding of human gender (Male, Female, Undefined)
        return null;
    }

    /**
     * The method below is supposed to calculate the G+C fraction of a DNA sequence.
     * It should do so case insensitive.
     * After uncommenting the method body (select the blok and press Ctrl + /), there are 3 problems and one error
     * in this method you should find and fix before the tests will pass.
     */
    double determineGCfraction(String theDNA) {
//        int gcCount;
//        for (int i = 0; i < theDNA.length(); i++) {
//            char nucleotide = theDNA.charAt(i);
//            if (nucleotide == 'C' || nucleotide == 'G') {
//                gcCount++;
//            }
//        }
//        double fraction = gcCount/theDNA.length();
        return 0;
    }

    /**
     * The method below creates a string and calls on another method to change it.
     * Something goes wrong - can you fix it?
     */
    String modifyString() {
        String input = "Waar kan ik de koffiemachine vinden in dit gebouw?";
        replaceWord(input, "koffie", "soda");
        return input;
    }

    String replaceWord(String input, String replace, String replaceWith) {
        return input.replace(replace, replaceWith);
    }

    /**
     * The method below should return a String array of length 2, with the first and last element
     * of the input array in it, converted to Strings.
     * Hint: look at the methods available to type Object
     */
    String[] getFirstAndLast(Object[] input) {
        String[] result = new String[]{input[0].toString(), input[input.length - 1].toString()};
        return result;
    }

}
