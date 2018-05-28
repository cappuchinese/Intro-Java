///*
// * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
// * All rights reserved.
// */
//package week2_1;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Arrays;
//
//import static org.junit.Assert.assertEquals;
//
///**
// *
// * @author Michiel Noback [michiel.noback@gmail.com]
// */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ConsensusSequenceCreatorTest {
//
//    @Test
//    public void testCreateConsensus_A() {
//        String[] sequences = new String[4];
//        sequences[0] = "GAAT";
//        sequences[1] = "GAAA";
//        sequences[2] = "GATT";
//        sequences[3] = "GAAC";
//        String expResult = "GAWH";
//        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
//        String result = csc.createConsensus(sequences, true);
//        assertEquals(String.format("Testing consensus sequence creation with %s; ... ", Arrays.toString(sequences)), expResult, result);
//    }
//
//    @Test
//    public void testCreateConsensus_B() {
//        String[] sequences = new String[4];
//        sequences[0] = "GAAT";
//        sequences[1] = "GAAA";
//        sequences[2] = "GATT";
//        sequences[3] = "GAAC";
//        String expResult = "GA[A/T][A/C/T]";
//        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
//        String result = csc.createConsensus(sequences, false);
//        assertEquals(String.format("Testing consensus sequence creation with %s; ... ", Arrays.toString(sequences)), expResult, result);
//    }
//
//    @Test
//    public void testCreateConsensus_C() {
//        String[] sequences = new String[5];
//        sequences[0] = "CGAATA";
//        sequences[1] = "CGAAAA";
//        sequences[2] = "GGATTA";
//        sequences[3] = "GGAACA";
//        sequences[4] = "TGAACA";
//        String expResult = "[C/G/T]GA[A/T][A/C/T]A";
//        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
//        String result = csc.createConsensus(sequences, false);
//        assertEquals(String.format("Testing consensus sequence creation with %s; ... ", Arrays.toString(sequences)), expResult, result);
//    }
//
//    @Test
//    public void testCreateConsensus_D() {
//        String[] sequences = new String[5];
//        sequences[0] = "CGAATA";
//        sequences[1] = "CGAAAA";
//        sequences[2] = "GGACTA";
//        sequences[3] = "GGAACA";
//        sequences[4] = "TGAACA";
//        String expResult = "BGAMHA";
//        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
//        String result = csc.createConsensus(sequences, true);
//        assertEquals(String.format("Testing consensus sequence creation with %s; ... ", Arrays.toString(sequences)), expResult, result);
//    }
//}
