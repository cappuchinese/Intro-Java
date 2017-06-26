/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */
package all;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author michiel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    week1_1.BmiCalculatorTest.class, 
    week1_2.AllSubstringsPrinterTest.class, 
    week1_3.WeightUnitsSolverTest.class,
    week2_1.ConsensusSequenceCreatorTest.class,
    week4_1.ProteinTest.class
})
public class CompleteTestSuite {
    
}
