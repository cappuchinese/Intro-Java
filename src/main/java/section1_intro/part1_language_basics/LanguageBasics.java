package section1_intro.part1_language_basics;

public class LanguageBasics {

    /**
     * This method should return "number" to the power of "powerUp", where the absolute value (or modulus) is
     * taken of "powerUp".
     * Next, create your own JUnit tests in class LanguageBasicsTest:
     *  1: a correct result with getThePowerAbsolute(5, 3)
     *  2: a correct result with getThePowerAbsolute(5, -3)
     *  3: an incorrect result with getThePowerAbsolute(4, -2)
     * @param number
     * @param powerUp
     * @return number^absolute(powerUp)
     */
    public double getThePowerAbsolute(int number, int powerUp) {
        return 0;
    }

    /***************************THIS ONLY SERVES AS SEPARATOR TO THE NEXT ASSIGNMENT****************************/


    /**
     * In this method, four variables are declared and initialized.
     * Only one is named according to Java naming style rules.
     * Return the one that is correctly named (the value of the variable is irrelevant!).
     * @return correctVariable
     */
    public String returnCorrectlyNamedVariable() {
        String NameOfKing = "Willem Alexander";
        String name_of_king = "George IV";
        String nameOfKing = "Louis XIV, le Roi Soleil";
        String Name_Of_King = "Franz II";

        //return the correct variable
        return null;
    }

    /**
     * Below this method, you will find five methods returning an int.
     * One of them, thisisnotthecorrectone() is certainly not correctly named, but this is the one called
     * from within callCorrectlyNamedMethod().
     * Identify the method that is correctly named and replace it for the call to thisisnotthecorrectone().
     *
     * @return theCorrectInt
     */
    public int callCorrectlyNamedMethod() {
        return thisisnotthecorrectone();
    }

    int thisisnotthecorrectone() {return 0;}
    int currentStatus() {return 1;}
    int getCurrentStatus() {return 2;}
    int returnCurrentStatus() {return 3;}
    int status() {return 4;}


}
