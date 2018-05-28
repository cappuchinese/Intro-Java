package section1_intro.part0_how_it_works;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Creation date: Jun 26, 2017
 *
 * @version 0.01
 * @autor Michiel Noback (&copy; 2017)
 */
public class StartingJavaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private StartingJava startingJava;

    @BeforeEach
    public void setUpStreams() {
        startingJava = new StartingJava();
    }

    @Test
    public void testPrintHelloWorld() throws Exception {
        PrintStream sysOut = System.out;
        System.setOut(new PrintStream(outContent));
        startingJava.printHelloWorld();
        String printedResult = outContent.toString();
        sysOut.print(printedResult);
        assertEquals("Hello, World", printedResult);
        System.setOut(null);
    }

    @Test
    public void testAddInts() throws Exception {
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
    public void testDivideAndRound() throws Exception {
        double x = 4.999;
        double y = 1.999;
        long result = 3;
        assertEquals(result, startingJava.divideAndRound(x, y));

        y = 2.001;
        result = 2;
        assertEquals(result, startingJava.divideAndRound(x, y));
    }

    @Test
    public void testGetGreeting() throws Exception {
        assertEquals("Wazzup", startingJava.getGreeting(2));
        assertEquals("Yo!", startingJava.getGreeting(3));
    }

    @Test
    public void testCreateDuck() throws Exception {
        int speed = 7;
        String name = "Shelduck";
        Duck duck = startingJava.createDuck(speed, name);

        assertEquals(7, duck.swimSpeed);
        assertEquals(name, duck.name);

        speed = 2;
        name = "Common Mallard";
        duck = startingJava.createDuck(speed, name);

        assertEquals(2, duck.swimSpeed);
        assertEquals(name, duck.name);
    }
}