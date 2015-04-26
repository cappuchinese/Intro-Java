/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package week7_final_assignments.choice1_genbank_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public final class GenBankReader {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        GenBankReader mainObject = new GenBankReader();
        mainObject.start(args);
    }

    /**
     * private constructor.
     */
    private GenBankReader() { }

    /**
     * starts the application.
     * @param args the command line arguments passed from main()
     */
    private void start(String[] args) {
        //application logic goes here
    }
}