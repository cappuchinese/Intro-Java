package snippets;

class JavaTypesDemo {
    public static void main(String[] args) {
        /* INTEGER counts the number of kills */
        int killCount = 42;

        /*BOOLEAN for yes/no variables; indicates alive status*/
        boolean alive = false;

        /*DOUBLE for floating point values; indicates the average number of kills per life cycle*/
        double killAverage = 10.55;

        /*CHARACTER for single letter values;
        stores mode of the game 'N'=No mercy 'S'= Sissy*/
        char playmode = 'N';


        /*STRING for text values; the name of the player*/
        String player = "ZZZZZombie";


        System.out.println("player =       " + player);
        System.out.println("alive =        " + alive);
        System.out.println("play mode =    " + playmode);
        System.out.println("kill count =   " + killCount);
        System.out.println("kill average = " + killAverage);
    }


    void demoInitDeclare(){
        //LEGAL
        int killCount;
        killCount = 0;

        //ILLEGAL; not initialized
        int livesLived; //no compile error here
        //System.out.println("livesLived = " + livesLived); //but here!
    }


    static void usingPrimitives() {
        int x = 10;
        int y = 20;
        int squareSurface = x * y;
        System.out.println("squareSurface = " + squareSurface);
        /*Use the Math class many numeric operations and constants.
        * Note that 10^2 is NOT 10 raised by power 2, but 10 XOR 2 (bitwise)*/
        double circleSurface = Math.PI * Math.pow((0.5 * x), 2);
        System.out.println("circleSurface = " + circleSurface);
        double division = (double)x / y;
        System.out.println("division = " + division);


        double ratio = 1.234;
        int intRatio = (int)ratio;


        char nucleotide = 'A';
        //allowed, because a char is an 16-bit int under water
        System.out.println(nucleotide * 10); //650
        System.out.println((char)(nucleotide + 5));


        boolean isAlive = true;
        //not allowed; although in some languages this works just fine
        //System.out.println("isAlive * 10 = " + isAlive * 10);

        String name = "Hank";
        //surprisingly, this is allowed; the int is automatically converted (not cast!) into a String
        System.out.println(name + 10); //Hank10

        //not allowed; the * operator does not support these two types as operands
        //System.out.println("name * 10 = " + name * 10);
    }


    static void stringDemo(){
        String dnaOne = "AGAGGTCTAGCTGA";
        String dnaTwo = "GGTCTAGC";
        String dnaThree = "GGtctAGc";
        String dnaFour = dnaThree.toUpperCase();

        System.out.println("dnaOne - character at position 6 = " + dnaOne.charAt(5)); //T
        System.out.println("dnaOne contains dnaTwo" + dnaOne.contains(dnaTwo)); //true
        System.out.println("dnaTwo equals dnaThree, ignoring case " + dnaTwo.equalsIgnoreCase(dnaThree)); //true
        System.out.println("dnaOne starts with \"AGAGGT\" " + dnaOne.startsWith("AGAGGT")); //true
        System.out.println("dnaFour.toCharArray() = " + dnaFour.toCharArray()); //[C@6f3b5d16 but this changes: this is the reference value (the remote control endpoint)


    }
}
