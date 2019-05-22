package section2_syntax.part1_datatypes;

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
     * of the input array in it, converted to String representations.
     * Hint: look at the methods available to class Object (GIYF)
     */
    String[] getFirstAndLast(Object[] input) {
        return null;
    }


    /**
     * This method should return a new int array where all integers from the input have been cubed (power of 3).
     * For convenience, the skeleton of a for loop is already provided.
     * @param input
     * @return cubedInput
     */
    int[] cubeAll(int[] input) {
        int arrayLength = 0; //get the correct value
        for(int i = 0; i < arrayLength; i++) {
            //do your thing
        }
        return null;
    }

    /**
     * This method should return the cumulative product of all numbers in the input array.
     * @param input
     * @return cumProd the cumulative product
     */
    int cumulativeProduct(int[] input) {
        return 0;
    }

}
