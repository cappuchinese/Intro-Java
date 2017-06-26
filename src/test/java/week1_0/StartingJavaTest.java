package week1_0;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Creation date: Jun 26, 2017
 *
 * @version 0.01
 * @autor Michiel Noback (&copy; 2017)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StartingJavaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private StartingJava startingJava;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        startingJava = new StartingJava();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void test1_printHelloWorld() throws Exception {
        startingJava.printHelloWorld();
        assertEquals("Hello, World", outContent.toString());
    }

    @Test
    public void test2_addInts() throws Exception {
        int x = 2;
        int y = 4;
        int result = x + y;
        assertEquals(result, startingJava.addInts(x, y));

        x = -10;
        y = 6;
        result = x + y;
        assertEquals(result, startingJava.addInts(x, y));
    }

    @Test
    public void test3_divideAndRound() throws Exception {
        double x = 4.999;
        double y = 1.999;
        long result = 3;
        assertEquals(result, startingJava.divideAndRound(x, y));

        y = 2.001;
        result = 2;
        assertEquals(result, startingJava.divideAndRound(x, y));
    }

    @Test
    public void test4_getGreeting() throws Exception {
        assertEquals("Wazzup", startingJava.getGreeting(2));
        assertEquals("Yo!", startingJava.getGreeting(3));
    }

}