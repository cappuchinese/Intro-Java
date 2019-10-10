# How it works


There are several methods shown in class `StartingJava` (file `StartingJava.java`). You are supposed to work through them from the top of the file to the bottom.

Study the Javadoc that accompanies each method and implement according the instructions given therein. 
Often this means you must implement the method body. Don't forget to replace the `return 0;` or `return null;` statements with your calculated values! 

Most assignments have one or more corresponding test methods that can be used to verify the correctness of your solution. 
These are found in `/src/test/java/section1_intro/part0_how_it_works/StartingJavaTest.java`). 
They have the same name as the method your are working on with the word `test` prepended. 
So, `printHelloWorld()` can be verified using `testPrintHelloWorld()`.

In class, several ways of running and interpreting tests will be demonstrated.

If you want to run the method yourself, you can add a `main()` method by typing `psvm` and then pressing the Tab character. 
Within `main()`, create an object of type `StartingJava` and call the method you wish to test. 
The result will look like the method below. 

```java
public static void main(String[] args) {
    StartingJava startingJava = new StartingJava();
    startingJava.printHelloWorld();
}
```

You can then run `main()` by pressing the small green rectangle in the code editor margin. 
