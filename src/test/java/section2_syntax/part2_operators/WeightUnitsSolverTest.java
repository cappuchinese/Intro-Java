package section2_syntax.part2_operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightUnitsSolverTest {

    @Test
    public void testConvertFromGrams_A() {
        int grams = 1;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        BritishWeightUnits expResult = new BritishWeightUnits(0, 0, 1);
        BritishWeightUnits result = instance.convertFromGrams(grams);
        assertEquals(expResult.getPounds(), result.getPounds());
        assertEquals(expResult.getOunces(), result.getOunces());
        assertEquals(expResult.getGrams(), result.getGrams());
    }

    @Test
    public void testConvertFromGrams_B() {
        int grams = 1000;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        BritishWeightUnits expResult = new BritishWeightUnits(2, 3, 8);
        BritishWeightUnits result = instance.convertFromGrams(grams);
        assertEquals(expResult.getPounds(), result.getPounds());
        assertEquals(expResult.getOunces(), result.getOunces());
        assertEquals(expResult.getGrams(), result.getGrams());
    }

    @Test
    public void testConvertFromGrams_C() {
        int grams = 25369;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        BritishWeightUnits expResult = new BritishWeightUnits(55, 14, 7);
        BritishWeightUnits result = instance.convertFromGrams(grams);
        assertEquals(expResult.getPounds(), result.getPounds());
        assertEquals(expResult.getOunces(), result.getOunces());
        assertEquals(expResult.getGrams(), result.getGrams());
    }

    @Test//(expected=IllegalArgumentException.class)
    public void testConvertFromGrams_D() {
        int grams = -1;
        WeightUnitsSolver instance = new WeightUnitsSolver();
        try {
            instance.convertFromGrams(grams);
            fail(String.format("Testing unit conversion with %d; grams ... expected %s", grams, IllegalArgumentException.class.getName()));
        } catch (IllegalArgumentException ex) {
            return;
        }
    }
}