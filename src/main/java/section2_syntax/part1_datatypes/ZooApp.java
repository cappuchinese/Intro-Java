package section2_syntax.part1_datatypes;

import java.util.List;

public class ZooApp {

    public static void main(String[] args) {
        ZooApp zooApp = new ZooApp();
        zooApp.processZooData(args);
        zooApp.printZooSummary();
    }

    /**
     * Processes the command line data.
     * @param args
     */
    void processZooData(String[] args) {
        //YOUR CODE HERE
    }

    /**
     * Prints a summary of the zoo.
     */
    void printZooSummary() {
        final List<ZooSpecies> allSpecies = null; //YOUR CODE HERE
        //YOUR CODE HERE
        for (ZooSpecies species : allSpecies) {
            //YOUR CODE HERE
        }
    }
}
