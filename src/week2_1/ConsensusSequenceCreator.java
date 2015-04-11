/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package week2_1;

import java.util.Arrays;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class ConsensusSequenceCreator {
    /**
     * testing main.
     * @param args 
     */
    public static void main(String[] args) {
        String[] sequences = new String[4];
        sequences[0] = "GAAT";
        sequences[1] = "GAAA";
        sequences[2] = "GATT";
        sequences[3] = "GAAC";
        
        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
        String consensus = csc.createConsensus(sequences, true);
        //consensus should equal "GAWH"
        consensus = csc.createConsensus(sequences, false);
        //consensus should equal "GA[A/T][A/T/C]"
    }

    /**
     * creates a consensus sequence from the given array of sequences.
     * @param sequences the sequences to scan for consensus
     * @param iupac flag to indicate IUPAC (true) or bracket notation (false)
     * @return consensus the consensus sequence
     */
    public String createConsensus(String[] sequences, boolean iupac) {
        return "";
    }
}
