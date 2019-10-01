package section3_apis.part1_interfaces;

public class CombinerFactory {
    /**
     * This method returns a StringCombiner that will surround the given arguments with double quotes,
     * separated by spaces and the result surrounded by single quotes.
     * For example, this call combiner.combine("one", "two") will return '"one" "two"'
     * @return quotedCombiner
     */
    static StringCombiner getQuotedCombiner() {
        return null;
    }

    /**
     * This method returns a StringCombiner that will return the given arguments combined reversed and original,
     * concatenated with a space in between.
     * For example, combiner.combine("one", "two") will return "oneeno twoowt" (the quotes are not included
     * in the return value).
     * @return reversedCombiner
     */
    static StringCombiner getReversedCombiner() {
        return null;
    }

    /**
     * <strong>Challenge!</strong>
     * This method returns a StringCombiner that will return the given arguments where the characters of both
     * arguments are converted to their ASCII values and then the summed. These numbers are combined with a space
     * in between and returned.
     *
     * For example, combiner.combine("one", "two") will return "322 346" (111 + 110 + 101 and 116 + 119 + 111).
     * @return reversedCombiner
     */
    static StringCombiner getAsciiSumCombiner() {
        return null;
    }


}
