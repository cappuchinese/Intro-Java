package section2_syntax.part1_datatypes.Readme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Creation date: May 28, 2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
class DatatypesTest {
    private Datatypes datatypes;

    @BeforeEach
    void setup() {
        this.datatypes = new Datatypes();
    }

    @Test
    void correctDataType0() {
        assertEquals("short", datatypes.correctDataType0());
    }

    @Test
    void correctDataType1() {
        assertEquals("long", datatypes.correctDataType1());
    }

    @Test
    void correctDataType2() {
        assertEquals("float", datatypes.correctDataType2());
    }

    @Test
    void correctDataType3() {
        assertEquals("float", datatypes.correctDataType3());
    }

    @Test
    void correctDataType4() {
        assertEquals("boolean", datatypes.correctDataType4());
    }

    @Test
    void correctDataType5() {
    }

    @Test
    void correctDataType6() {
    }
}