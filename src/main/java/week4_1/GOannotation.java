/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package week4_1;

/**
 * Models the GO annotation of a protein.
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class GOannotation {
    private final int ID;
    private final String cellularComponent;
    private final String molecularFunction;
    private final String biologicalProcess;

    /**
     * constructs with all three GO components.
     * @param ID the GO identifyer.
     * @param cellularComponent
     * @param molecularFunction
     * @param biologicalProcess 
     */
    public GOannotation(int ID, String cellularComponent, String molecularFunction, String biologicalProcess) {
        this.ID = ID;
        this.cellularComponent = cellularComponent;
        this.molecularFunction = molecularFunction;
        this.biologicalProcess = biologicalProcess;
    }

    /**
     * 
     * @return ID the GO ID
     */
    public int getID() {
        return ID;
    }

    /**
     * 
     * @return cellularComponent the cellular component
     */
    public String getCellularComponent() {
        return cellularComponent;
    }

    /**
     * 
     * @return molecularFunction the molecular function
     */
    public String getMolecularFunction() {
        return molecularFunction;
    }

    /**
     * 
     * @return biologicalProcess the biological process
     */
    public String getBiologicalProcess() {
        return biologicalProcess;
    }
}
