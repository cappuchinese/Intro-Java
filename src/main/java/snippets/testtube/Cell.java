package snippets.testtube;

public class Cell {
    /**
     * Instance variable "size"; 5 micrometer is the default diameter when Cell objects are instantiated
     */
    int diameter = 5;
    /**
     * Lets this cell grow in a single increment
     */
    public void grow() {
        //grow by 1 micrometer
        this.diameter += 1;
        System.out.println("I am a Cell. My size is " + this.diameter);
    }
}