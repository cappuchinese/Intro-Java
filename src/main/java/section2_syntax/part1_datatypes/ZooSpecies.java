package section2_syntax.part1_datatypes;

import java.util.*;

public class ZooSpecies {
    private static Map<String, ZooSpecies> zooAnimals = new HashMap<>();
    private final String speciesName;
    private int individualCount;

    /**
     * serves the speces name.
     * @return
     */
    public String getSpeciesName() {
        return this.speciesName;
    }

    /**
     * serves the individual count for the species.
     * @return
     */
    public int getIndividualCount() {
        return this.individualCount;
    }

    /**
     * A private constructor; instances can only be obtained through the factory method.
     * @param speciesName
     */
    private ZooSpecies(String speciesName) {
        this.speciesName = speciesName;
    }

    /**
     * This is a static (i.e. class-level) factory method that registers ZooAnimal instances.
     * @param speciesName
     * @return
     */
    public static void registerSpeciesFromString(String speciesName) {
        if(!zooAnimals.containsKey(speciesName)) {
            ZooSpecies zooSpecies = new ZooSpecies(speciesName);
            zooAnimals.put(speciesName, zooSpecies);
        }
        ZooSpecies zooSpecies = zooAnimals.get(speciesName);
        zooSpecies.individualCount++;
    }

    /**
     * Serves all registered species in this Zoo.
     * @return
     */
    public static List<ZooSpecies> getAllSpecies() {
        List<ZooSpecies> species = new ArrayList<>();
        species.addAll(ZooSpecies.zooAnimals.values());
        return species;
    }
}
