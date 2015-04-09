# Introduction to programming with Java #

Assignments testing project for the course Introduction to programming with Java

### What is this repository for? ###

* Project with assignments and assignment stubs, with JUnit tests to check your solutions.
* Version 0.01
* (c) copyright Michiel Noback, Hanze University of Applied Science

### How do I get set up? ###

* Make sure you have the JUnit plugin installed in NetBeans!
* Download the most recent versions of JUnit and Hamcrest core from [JUnit](https://github.com/junit-team/junit/wiki/Download-and-Install) to a lib folder your local computer (e.g. <my_home>/libs/java/).  
Make sure have at least

    1. junit-4.12.jar
    2. hamcrest-core-1.3.jar

    But these can come in handy later on as well:

    3. junit-4.12-javadoc.jar
    4. junit-4.12-sources.jar
    5. hamcrest-core-1.3-javadoc.jar
    6. hamcrest-core-1.3-sources.jar

* Clone this repository to your local computer using NetBeans: Team -- git -- clone.  
Enter the link [https://bitbucket.org/michiel_noback/javaintroprogrammingassignments.git](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments.git)
 into the repository URL field, leave user and password blank, click Next and select "Master branch".  
Finish.  
Close warning message ("Unresolved...").
 
* In the cloned NetBeans project, right-click on Test Libraries, select "Add Library".  
In wizard, click "Create". Name it JUnit4.XX (depending on your version) and add jars to ClassPath 
(and optionally Sources jars and Javadoc jars to respective tabs).  
Make sure the test Packages folder of the project does not show error symbols anymore!  

* Start working on the assignments, as specified in the per-week java, per-assignment packages under "Source Packages".  
Make sure you read the contents of each Readme.md Markdown file located within each package, since they outline the details of that particular assignment.  
There is a plugin that supports Markdown in Netbeans [Markdown Support for NetBeans](https://github.com/madflow/flow-netbeans-markdown).  
It is very handy if you want to read your assignments nicely formatted from within NetBeans.  
Alternatively, you can read it on Bitbucket -- this has the advantage that the Java syntax highlighting does work correctly!.  

* To start testing a single class: Select single source file and select "Test File" from context menu (right click)

* To test all your work so far: Select project and select "Test" from context menu

* Of course you better use keyboard shortcuts! (or create a custom Toolbar)

* The test view will open and all selected tests will run. The red bars indicate failures while the green bars indicate you solved the assignment correctly!

* Good luck!
