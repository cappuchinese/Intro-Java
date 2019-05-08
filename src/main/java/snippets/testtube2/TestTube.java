package snippets.testtube2;

class TestTube {
    Cell cell;

    public static void main(String[] args) {
        TestTube tube = new TestTube();
        tube.cell = new Cell();
        //run for 5 generations
        for (int i = 0; i < 5; i++) {
            tube.growCells();
        }
    }

    /**
     * Grows the cells, in one single iteration.
     */
    void growCells() {
        //set diameter in nanometers
        cell.diameter = 6000;
        cell.growthIncrement = 750;
        cell.grow();
        System.out.println("cell diameter = " + cell.diameter);
    }
}
