package section1_intro.part1_language_basics;

public class LanguageBasics {

    /**
     * In this method, four variables are declared and initialized.
     * Return the one that is correctly named (the value of the variable is iirelevant!).
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
     * Below this method, you will find four methods returning an int. Call the method that is correctly named and
     * return its return value.
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

    /***************************THIS ONLY SERVES AS SEPARATOR TO THE NEXT ASSIGNMENT****************************/

    /*
    * Below, you will find two classes that were shown in the presentations (simplified a bit).
    * They are not completely implemented so this is the time to do that.
    * You may want to check out the the Math class, and the definition of Euclidean distance.
    */

    public static class PointInSpace {
        int x, y;
        double distanceTo(PointInSpace otherPoint) {
            //calculate distance
            return 0;
        }
    }

    public static class SquareInSpace{
        PointInSpace upperLeft;
        PointInSpace lowerRight;

        /**
         * returns the surface defined by the rectangle with the given upper left and lower right corners.
         * It assumes two corners have been created already!
         * @return
         */
        int surface(){
            //calculate surface
            return 0;
        }
    }


}
