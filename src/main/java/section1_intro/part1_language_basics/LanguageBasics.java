package section1_intro.part1_language_basics;

public class LanguageBasics {

    /**
     * This method should return "number" to the power of "powerUp", where the absolute value (or modulus) is
     * taken of "powerUp". Again, the Math class may come in handy.
     * @param number the number to power up
     * @param powerUp the power up value
     * @return number^absolute(powerUp)
     */
    public double getTheAbsolutePower(int number, int powerUp) {
        //YOUR CODE HERE
        return 0;
    }

    /**
     * In this method, four variables are declared and initialized.
     * Only one of the variables is named according to Java naming style rules.
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

    /***************************THIS SERVES AS SEPARATOR TO THE NEXT ASSIGNMENT****************************/

    /**
     * Below the method "callCorrectlyNamedMethod()" you will find five methods returning an int.
     * One of them, thisisnotthecorrectone() is certainly not correctly named, but this one is called
     * from within callCorrectlyNamedMethod().
     * Which of the other 4 methods is correctly named? Replace it for the call to thisisnotthecorrectone().
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
