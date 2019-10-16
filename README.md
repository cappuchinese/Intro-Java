# Introduction to programming with Java #

Assignments project for the course Introduction to programming with Java.
We will be using the IDE IntelliJ Idea Ultimate, from JetBrains. 
You will need a licence for this IDE, but we will provide one for you if you follow the
 Bioinformatics curriculum.

### What is this repository for?

* Project with assignments and JUnit tests that can check your solutions.
* Version 1.1
* (c) copyright Michiel Noback, Hanze University of Applied Science 2015-2019

### How do I get set up?

* **Fork** this repository into your own Bitbucket account (You can find this in the Actions submenu of the Bitbucket repo:
 the three dots in the left menu left)  

* **Clone** the forked repository from **_your_** bitbucket account to your local computer. 

* **Open** the project in IntelliJ (simply select the folder and follow the wizard).
 You may need to configure the JDK, via the Project Structure dialog  
    - File &rarr; Project Structure &rarr; SDKs (use /usr/local/jdk&lt;CURRENT VERSION&GT;)

* Start working on the assignments, as specified in the chronologically organized packages under "src/main/java/".  
 Make sure you read the contents of each `Readme.md` Markdown file located within each package. These outline the 
 details of that particular assignment. For easier reading, you can use the HTML version of the Javadoc located under `/build/docs`. 

* To start testing a class or a single method: Select the method or class name &rarr; Right click &rarr; Go To &rarr; Test (or simply select
 the Test class in `src/test/java/`). In the test class right-click anywhere (or select the class from the project view) 
 and select "Run ...". Alternatively, you can also run individual test methods by opening the test class in the editor 
 and selecting single methods.

* To test all your work so far: Select `src/test/java/`, right-click and select "Run 'All Tests'". 
The Gradle task  `verification/test` will do the same.

* The test view will open and all selected tests will run. The orange and red symbols indicate failures while green shows you 
solved the assignment correctly! Beware, test methods are really precise!  

### Keyboard shortcuts
It will make you much more productive if you try to learn the most important keyboard shortcuts. 
Check out the keyboard shortcuts for IntelliJ 
[here](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf))


