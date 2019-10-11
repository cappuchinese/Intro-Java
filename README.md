# Introduction to programming with Java #

Assignments project for the course Introduction to programming with Java.
From September 2017 onwards, we will be using the IDE IntelliJ Idea. 
You will need a licence for this IDE, but we will provide one for you if you follow the
 bioinformatics curriculum.

### What is this repository for?

* Project with assignments and assignment stubs, with JUnit tests to check your solutions.
* Version 1.1
* (c) copyright Michiel Noback, Hanze University of Applied Science 2015-2019

### How do I get set up?

* **Fork** this repository into your own Bitbucket account (You can find this in the Actions submenu of the Bitbucket repo:
 the three dots in the left menu left)  

* **Clone** the forked repository from **_your_** bitbucket account to your local computer using IntelliJ or the command line:  
    - New &rarr; Project from Version Control &rarr; git  
    - Enter the link https://bitbucket.org/&lt;YOUR_BITBUCKET_ACCOUNT_NAME&gt;/javaintroprogrammingassignments.git 
    into the Git Repository URL field
    - You may need to enter your Bitbucket credentials
    - Follow the wizard: import the build.gradle (follow from "Importing a project from a Gradle model" of this 
    [help page](https://www.jetbrains.com/help/idea/importing-a-gradle-project-or-a-gradle-module.html?search=import%20gradle))

* You may need to configure the JDK, via the Project Structure dialog  
    - File &rarr; Project Structure &rarr; SDKs (use /usr/local/jdk&lt;CURRENT VERSION&GT;)

* Possibly, the IDE will suggest you update the Maven Repo, or you do this manually:  
    - File &rarr; Settings/Preferences (depending on OS) &rarr; Build, Execution, Deployment &rarr; Build Tools &rarr; Maven &rarr; Repositories 
    &rarr; Choose Update after selecting the https://repo1.maven.org/maven2 URL and click OK
    - This may take a while!
 
* Start working on the assignments, as specified in the chronologically organized packages under "src/main/java/".  
 Make sure you read the contents of each Readme.md Markdown file located within each package, since they outline the 
 details of that particular assignment.  

* Commit your own code to your forked repo on Bitbucket  

* To start testing a class or a single method: Select the method or class name &rarr; Right click &rarr; Go To &rarr; Test (or simply select
 the Test class in 'src/test/java/'). In the test class right-click anywhere (or select the class from the project view) 
 and select "Run ...". Alternatively, you can also run individual test methods by opening the test class in the editor 
 and selecting single methods.

* To test all your work so far: Select 'src/test/java/', right-click and select "Run 'All Tests'". 
The Gradle task  `verification/test` will do the same.

* The test view will open and all selected tests will run. The orange and red symbols indicate failures while green shows you 
solved the assignment correctly! Beware, test methods are really precise!  

### Keyboard shortcuts
It will make you much more productive if you try to learn the most important keyboard shortcuts. 
Check out the keyboard shortcuts for IntelliJ 
[here](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf))


