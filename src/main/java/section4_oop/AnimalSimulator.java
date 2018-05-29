/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section4_oop;

import java.util.List;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class AnimalSimulator {
    public static void main(String[] args) {
        AnimalSimulator anSim = new AnimalSimulator();
        anSim.start(args);
    }

    
    private void start(String[] args) {
        //start processing command line arguments
    }
    
    /**
     * returns all supported animals as List, alhabetically ordered
     * @return supportedAnimals the supported animals
     */
    public List<String> getSupportedAnimals() {
        return null;
    }
}
