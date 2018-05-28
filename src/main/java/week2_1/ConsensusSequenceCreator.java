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
        for (int i = 0; i < this.ambiguities.length; i++) {
            String ambiguity = this.ambiguities[i];
            //System.out.println("ambiguity = " + ambiguity);
            if (this.iupac) {
                this.consensus += getIupacCode(ambiguity);
            } else {
                this.consensus += getSnpNotationCode(ambiguity);
            }
        }
    }

    private String getSnpNotationCode(String ambiguity) {
        if (ambiguity.length() > 1) {
            String[] ambiguities = ambiguity.split("");
            Arrays.sort(ambiguities);
            String joined = String.join("/", ambiguities);
            String withBrackets = "[" + joined + "]";
            return withBrackets;
        } else {
            return ambiguity;
        }
    }

    private String getIupacCode(String ambiguity) {
        if (ambiguity.length() > 1) {
            String[] ambiguities = ambiguity.split("");
            Arrays.sort(ambiguities);
            String sorted = String.join("", ambiguities);
            switch (sorted) {
                case "AC": return "M";
                case "AG": return "R";
                case "AT": return "W";
                case "CG": return "S";
                case "CT": return "Y";
                case "GT": return "K";
                case "ACG": return "V";
                case "ACT": return "H";
                case "AGT": return "D";
                case "CGT": return "B";
                case "GATC": return "N";
                default: return "X"; //a dirty hack!
            }
        } else {
            return ambiguity;
        }
    }

    private void buildAmbiguities() {
        for (int i = 0; i < this.sequences[0].length(); i++) {
            determineAmbiguity(i);
        }
    }

    private void determineAmbiguity(int msaPosition) {
        String ambiguity = "";
        for (int i = 0; i < this.sequences.length; i++) {
//            char sequencePostionCharacter = this.sequences[i].charAt(msaPosition);
//            String sequencePositionString = sequencePostionCharacter + "";
            String sequencePositionString = this.sequences[i].substring(msaPosition, msaPosition+1);
            if (! ambiguity.contains(sequencePositionString)) {
//                ambiguity += sequencePostionCharacter;
                ambiguity += sequencePositionString;
            }
        }
        this.ambiguities[msaPosition] = ambiguity;
    }
}
