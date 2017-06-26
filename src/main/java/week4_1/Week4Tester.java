/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package week4_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class Week4Tester {
    /**
     * main method solely for testing purposes
     * @param args 
     */
    public static void main(String[] args) {
        String o = "mannosidase alpha";
        String instance = "60s ribosomal protein l35 pthr13872";
        System.out.println(instance.compareTo(o));
        System.exit(0);
        
        ArrayList<Protein> proteins = new ArrayList<>();
        Protein p1 = new Protein("mannosidase alpha", "man1b1a", "MRTVALL", 
                new GOannotation(15923, "cytoplasmatic", "beta-6-sulfate-N-acetylglucosaminidase activity", "sugar metabolism"));
        proteins.add(p1);

        Protein p2 = new Protein("60s ribosomal protein l35 pthr13872", "Stt3a", "MTDDLVLAW", 
                new GOannotation(18279, "membrane inserted", "protein N-linked glycosylation via asparagine", "sugar metabolism"));
        proteins.add(p2);

        Protein p3 = new Protein("tumor suppressor candidate 3", "Tusc3", "MQSVNKLI", 
                new GOannotation(18269, "mitochondrial", "dolichyl-diphosphooligosaccharide--protein glycosyltransferase", "cell-cycle regulation"));
        proteins.add(p3);

        Protein p4 = new Protein("synovial apoptosis inhibitor 1, synoviolin", "Syvn1", "MTYIILLVCDERT", 
                new GOannotation(13259, "cytoplasmatic", "synoviolin-related", "cell-cycle regulation"));
        proteins.add(p4);
        
        Protein p5 = new Protein("fucosyltransferase 8 (alpha (1,6) fucosyltransferase)", "Fut8", "MGTHIILVLM", 
                new GOannotation(342989, "cytoplasmatic", "fucosyltransferase activity", "sugar metabolism"));
        proteins.add(p5);
        
        Collections.sort(proteins, Protein.getSorter(SortingType.PROTEIN_WEIGHT));
        
        proteins.stream().forEach(System.out::println);
    }
}
