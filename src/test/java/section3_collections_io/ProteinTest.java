package section3_collections_io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import section3_collections_io.part1_protein_sorting.Protein;
import section3_collections_io.part1_protein_sorting.ProteinDataSource;
import section3_collections_io.part1_protein_sorting.ProteinDataSourceInMemory;
import section3_collections_io.part1_protein_sorting.SortingType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProteinTest {
    private List<Protein> proteins = null;

    @BeforeEach
    void setup() {
        ProteinDataSource dataSource = new ProteinDataSourceInMemory();
        this.proteins = dataSource.getAllProteins();
    }

    @Test
    public void testCompareTo_A() {
        Protein o = new Protein("mannosidase alpha", "man1b1a", "MRTVALL", null);
        Protein instance = new Protein("60s ribosomal protein l35 pthr13872", "Stt3a", "MTDDLVLAW", null);
        int result = instance.compareTo(o);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareTo_B() {
        Protein instance = new Protein("mannosidase alpha", "man1b1a", "MRTVALL", null);
        Protein o = new Protein("60s ribosomal protein l35 pthr13872", "Stt3a", "MTDDLVLAW", null);
        int result = instance.compareTo(o);
        assertTrue(result > 0);
    }

    @Test
    public void testCompareTo_C() {
        Protein o = new Protein("mannosidase alpha", "man1b1a", "MRTVALL", null);
        Protein instance = new Protein("mannosidase alpha", "Stt3a", "MTDDLVLAW", null);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testGetSorter_A() {
        SortingType type = null;
        try {
            Protein.getSorter(type);
            fail(String.format("Testing fetching sorter with type %s ... expected %s", type, IllegalArgumentException.class.getName()));
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetSorter_B() {
        SortingType type = SortingType.PROTEIN_NAME;
        Comparator<Protein> sorter = Protein.getSorter(type);
        String[] expNames = new String[]{
            "60s ribosomal protein l35 pthr13872",
            "fucosyltransferase 8 (alpha (1,6) fucosyltransferase)",
            "mannosidase alpha",
            "synovial apoptosis inhibitor 1, synoviolin",
            "tumor suppressor candidate 3"};
        //sort the list
        Collections.sort(this.proteins, sorter);
        for (int i = 0; i < expNames.length; i++) {
            String expName = expNames[i];
            String obsName = this.proteins.get(i).getName();
            //System.out.println("comparing obsName = " + obsName + " with expName = " + expName);
            if (!expName.equals(obsName)) {
                fail(String.format("Testing sorting with \"%s\" failed", type.name()));
                //fail("Failed on " + type);
            }
        }

        /*Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW}
         Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM}
         Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL}
         Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT}
         Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI}*/
    }

    @Test
    public void testGetSorter_C() {
        SortingType type = SortingType.ACCESSION_NUMBER;
        Comparator<Protein> sorter = Protein.getSorter(type);
        String[] expAccnos = new String[]{
            "Fut8",
            "man1b1a",
            "Stt3a",
            "Syvn1",
            "Tusc3"};
        //sort the list
        Collections.sort(this.proteins, sorter);
        checkOrderOfAccessionNumbers(type, expAccnos);

        /*
         Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM}
         Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL}
         Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW}
         Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT}
         Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI}*/
    }

    private void checkOrderOfAccessionNumbers(SortingType type, String[] expAccnos) {
        for (int i = 0; i < expAccnos.length; i++) {
            String expAccno = expAccnos[i];
            String obsAccno = this.proteins.get(i).getAccession();
            //System.out.println("comparing obsName = " + obsName + " with expName = " + expName);
            if (!expAccno.equals(obsAccno)) {
                fail(String.format("Testing sorting with \"%s\" failed", type.name()));
            }
        }
    }

    @Test
    public void testGetSorter_D() {
        SortingType type = SortingType.PROTEIN_WEIGHT;
        Comparator<Protein> sorter = Protein.getSorter(type);
        String[] expAccnos = new String[]{
            "Syvn1",
            "Fut8",
            "Stt3a",
            "Tusc3",
            "man1b1a"};
        //sort the list
        Collections.sort(this.proteins, sorter);
        checkOrderOfAccessionNumbers(type, expAccnos);

        /*
         Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT} //1569.89
         Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM} //1127.47
         Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW} //1063.23
         Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI} //932.15
         Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL} //803.03
         */
    }

    @Test
    public void testGetSorter_E() {
        SortingType type = SortingType.GO_ANNOTATION;
        //first on biological process (3), then on cellular component (1) and last on molecular function (2)
        Comparator<Protein> sorter = Protein.getSorter(type);
        String[] expAccnos = new String[]{
            "Syvn1",
            "Tusc3",
            "man1b1a",
            "Fut8",
            "Stt3a"};
        //sort the list
        Collections.sort(this.proteins, sorter);
        checkOrderOfAccessionNumbers(type, expAccnos);

        /*
Protein{name=synovial apoptosis inhibitor 1, synoviolin, accession=Syvn1, aminoAcidSequence=MTYIILLVCDERT}
        //GOannotation(13259, "cytoplasmatic", "synoviolin-related", "cell-cycle regulation")
Protein{name=tumor suppressor candidate 3, accession=Tusc3, aminoAcidSequence=MQSVNKLI}
        //GOannotation(18269, "mitochondrial", "dolichyl-diphosphooligosaccharide--protein glycosyltransferase", "cell-cycle regulation")
Protein{name=mannosidase alpha, accession=man1b1a, aminoAcidSequence=MRTVALL}
        //GOannotation(15923, "cytoplasmatic", "beta-6-sulfate-N-acetylglucosaminidase activity", "sugar metabolism")
Protein{name=fucosyltransferase 8 (alpha (1,6) fucosyltransferase), accession=Fut8, aminoAcidSequence=MGTHIILVLM}
        //GOannotation(342989, "cytoplasmatic", "fucosyltransferase activity", "sugar metabolism")
Protein{name=60s ribosomal protein l35 pthr13872, accession=Stt3a, aminoAcidSequence=MTDDLVLAW}
        //GOannotation(18279, "membrane inserted", "protein N-linked glycosylation via asparagine", "sugar metabolism")
         */
    }

}