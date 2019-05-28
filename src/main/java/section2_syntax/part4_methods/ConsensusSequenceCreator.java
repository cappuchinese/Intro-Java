/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section2_syntax.part4_methods;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class ConsensusSequenceCreator {
    private String[] sequences;
    private boolean iupac;
    private String[] ambiguities;
    private String consensus = "";

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
        String consensus;
        consensus = csc.createConsensus(sequences, true);
        System.out.println("consensus = " + consensus);
        //consensus should equal "GAWH"
        consensus = csc.createConsensus(sequences, false);
        //consensus should equal "GA[A/T][A/T/C]"
        System.out.println("consensus = " + consensus);
    }

    /**
     * creates a consensus sequence from the given array of sequences.
     * @param sequences the sequences to scan for consensus
     * @param iupac flag to indicate IUPAC (true) or bracket notation (false)
     * @return consensus the consensus sequence
     */
    public String createConsensus(String[] sequences, boolean iupac) {
        this.sequences = sequences;
        this.iupac = iupac;
        this.ambiguities = new String[sequences[0].length()];
        buildAmbiguities();
        buildConsensus();
        return this.consensus;
    }

    private void buildConsensus() {
        //YOUR CODE
    }

    private void buildAmbiguities() {
        //YOUR CODE
    }

}