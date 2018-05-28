/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package week3_1;

import java.util.Comparator;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class Protein implements Comparable<Protein> {
    private final String name;
    private final String accession;
    private final String aminoAcidSequence;
    private GOannotation goAnnotation;

    /**
     * constructs without GO annotation;
     * @param name
     * @param accession
     * @param aminoAcidSequence 
     */
    public Protein(String name, String accession, String aminoAcidSequence) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
    }

    /**
     * construicts with main properties.
     * @param name
     * @param accession
     * @param aminoAcidSequence
     * @param goAnnotation 
     */
    public Protein(String name, String accession, String aminoAcidSequence, GOannotation goAnnotation) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
        this.goAnnotation = goAnnotation;
    }

    @Override
    public int compareTo(Protein o) {
        return 0;
    }
    
    /**
     * provides a range of possible sorters, based on the type that is requested.
     * @param type
     * @return proteinSorter
     */
    public static Comparator<Protein> getSorter(SortingType type) {
        return null;
    }

    /**
     *
     * @return name the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return accession the accession number
     */
    public String getAccession() {
        return accession;
    }

    /**
     *
     * @return aminoAcidSequence the amino acid sequence
     */
    public String getAminoAcidSequence() {
        return aminoAcidSequence;
    }

    /**
     *
     * @return GO annotation
     */
    public GOannotation getGoAnnotation() {
        return goAnnotation;
    }

    @Override
    public String toString() {
        return "Protein{" + "name=" + name + ", accession=" + accession + ", aminoAcidSequence=" + aminoAcidSequence + '}';
    }

}
