package section3_apis.part1_interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinerFactoryTest {

    @Test
    void getQuotedCombiner1() {
        final StringCombiner quotedCombiner = CombinerFactory.getQuotedCombiner();
        final String actual = quotedCombiner.combine("foo", "bar");
        final String expected = "'\"foo\" \"bar\"'";
        assertEquals(expected, actual);
    }

    void getQuotedCombiner2() {
        final StringCombiner quotedCombiner = CombinerFactory.getQuotedCombiner();
        final String actual = quotedCombiner.combine("how", "dy");
        final String expected = "'\"how\" \"dy\"'";
        assertEquals(expected, actual);
    }

    @Test
    void getReversedCombiner1() {
        //reversedCombiner.combine("one", "two") will return "oneeno twoowt"
        final StringCombiner reversedCombiner = CombinerFactory.getReversedCombiner();
        final String actual = reversedCombiner.combine("foo", "bar");
        final String expected = "foooof barrab";
        assertEquals(expected, actual);
    }

    @Test
    void getReversedCombiner2() {
        //reversedCombiner.combine("one", "two") will return "oneeno twoowt"
        final StringCombiner reversedCombiner = CombinerFactory.getReversedCombiner();
        final String actual = reversedCombiner.combine("how", "zow");
        final String expected = "howwoh zowwoz";
        assertEquals(expected, actual);
    }

    @Test
    void getAsciiSumCombiner() {
        //reversedCombiner.combine("one", "two") will return "322 346" (111 + 110 + 101 and 116 + 119 + 111).

    }
}