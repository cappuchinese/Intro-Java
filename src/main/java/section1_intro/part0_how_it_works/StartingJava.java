package section1_intro.part0_how_it_works;

/**
 * Creation date: Jun 26, 2017
 *
 * @version 0.01
 * @author Michiel Noback (&copy; 2017)
 */
public class StartingJava {

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
     * @param x the x value
     * @param y the y value
     * @return theSum
     */
    public int addInts(int x, int y) {
        /*PUT YOUR CODE HERE
         and replace the zero in the return statement (return 0;)
         with your own value.*/
        return 0;
    }

    /**
     * Given a distance in meters and a passed time in seconds, calculate the
     * speed in km/h.
     *
     * @param distanceInMeters the distance
     * @param timeInSeconds the elapsed time
     * @return speed
     */
    public double calculateSpeed(double distanceInMeters, double timeInSeconds) {
        //YOUR CODE HERE
        return 0;
    }

    /**
     * This method divides x by y and returns the rounded value (rounded to nearest integer).
     * Use the Math class to get your implementation right. Start by typing 'Math.' within
     * the method body (without the quotes of course)
     * and select a method you are interested in. Pressing 'F1' (or ctrl + q) shows the Javadoc
     * info on the selected method.
     * @param x the x value
     * @param y the y value
     * @return dividedAndRounded
     */
    public long divideAndRound(double x, double y) {
        //YOUR CODE
        return 0;
    }

    /**
     * Returns the String found at the corresponding position of GREETINGS.
     * The array GREETINGS is declared just below this method.
     * Note that Java works with zero-based indexing, using square brackets.
     * @param index of the greeting
     * @return greeting
     */
    public String getGreeting(int index) {
        //YOUR CODE
        return "";
    }

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
     * Returns a Duck object with the given swim speed and name.
     * The Duck class is already present in this same package.
     * @param swimSpeed the swim speed
     * @param nameOfDuck the name of the Duck
     * @return duck a Duck instance
     */
    public Duck createDuck(int swimSpeed, String nameOfDuck) {
        //YOUR CODE
        return null;
    }

}
