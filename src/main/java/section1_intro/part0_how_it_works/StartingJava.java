package section1_intro.part0_how_it_works;

/**
 * Creation date: Jun 26, 2017
 *
 * @version 0.01
 * @author Michiel Noback (&copy; 2017)
 */
public class StartingJava {
    /**
     * this is a constant - a String array used for getGreeting()
     */
    public static final String[] GREETINGS = new String[]{
            "Hallo",
            "Moi",
            "Wazzup",
            "Yo!",
            "Hey"
    };

    /**
     * This method simply prints "Hello, World" to the console.
     * 1. Run the test method called testPrintHelloWorld() that you can find
     * in the test class located at /src/test/java/section1_intro/part0_how_it_works/StartingJavaTest
     * 2. Change the output of this method and run the test again (where are the "buttons" to re-run tests?). What happens?
     * 3. Correct the introduced "error" and make sure the test passes again.
     */
    public void printHelloWorld() {
        System.out.print("Hello, World");
    }

    /**
     * This method should return the sum of x and y
     * @param x
     * @param y
     * @return theSum
     */
    public int addInts(int x, int y) {
        return 0;
    }

    /**
     * This method divides x by y and returns the rounded value (rounded to nearest integer).
     * Use the Math class to get your implementation right.
     * @param x
     * @param y
     * @return dividedAndRounded
     */
    public long divideAndRound(double x, double y) {
        return 0;
    }

    /**
     * Returns the String found at the corresponding position of GREETINGS.
     * Note (a) that Java works with zero-based indexing.
     * @param index of the greeting
     * @return greeting
     */
    public String getGreeting(int index) {
        return "";
    }


    /**
     * Returns a Duck object with the given swim speed and name.
     * The Duck class is already present in this same package.
     * @param swimSpeed the swim speed
     * @param nameOfDuck the name of the Duck
     * @return duck a Duck instance
     */
    public Duck createDuck(int swimSpeed, String nameOfDuck) {
        return null;
    }

}
