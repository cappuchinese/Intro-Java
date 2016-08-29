# Introduction to programming with Java #

Assignments testing project for the course Introduction to programming with Java

### What is this repository for? ###

* Project with assignments and assignment stubs, with JUnit tests to check your solutions.
* Version 0.1
* (c) copyright Michiel Noback, Hanze University of Applied Science

### How do I get set up? ###

* Make sure you have the JUnit plugin installed in NetBeans!
* Download the most recent versions of JUnit and Hamcrest core from [JUnit](https://github.com/junit-team/junit/wiki/Download-and-Install) to a lib folder your local computer (e.g. <my_home>/libs/java/).  
Make sure have at least

    1. junit-4.12.jar
    2. hamcrest-core-1.3.jar

    But these can come in handy later on as well:

    4. junit-4.12-javadoc.jar
    5. junit-4.12-sources.jar
    6. hamcrest-core-1.3-javadoc.jar
    7. hamcrest-core-1.3-sources.jar

    For your convenience, I have made a downloadable zip archive holding all these testing-related jars (and some more but you can ignore these). 
You can find it in the [downloads section](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads/) of this repo. 
Here is a direct link to the [test archive](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads/test_archive.zip)

* Fork this repository into your own Bitbucket account (You can find this in the Actions submenu of the Bitbucket repo: the three dots in the left menu left)  

* Clone the forked repository from **your** bitbucket account to your local computer using NetBeans: Team -- git -- clone.  
Enter the link https://bitbucket.org/<YOUR_BITBUCKET_ACCOUNT_NAME>/javaintroprogrammingassignments.git
 into the repository URL field, leave user and password blank, click Next and select "Master branch".  
Finish.  
Close warning message ("Unresolved...").
 
* In the cloned NetBeans project, right-click on Test Libraries, select "Add Library".  
In wizard, click "Create". Name it JUnit4.XX (depending on your version) and add jars to ClassPath 
(and optionally Sources jars and Javadoc jars to respective tabs).  
Make sure the test Packages folder of the project does not show error symbols anymore!  

* It is highly recommended to also install the NetBeans Checkstyle plugin. Checkstyle-OK-ed code is a requirement for the final assignments!
This plugin is available [here](http://www.sickboy.cz/checkstyle/).  
You can customize checkstyle using an xml configuration file. 
The [downloads](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads) section of this 
repo holds a configuration file that is slightly adapted: you should take this as the coding standard. 
After installing the Checkstyle plugin, download this [checkstyle.xml](https://bitbucket.org/michiel_noback/javaintroprogrammingassignments/downloads/checkstyle.xml) 
file and place it somewhere on your hard drive. In Netbeans, go to Options (Preferences on Mac), 
go to Miscellaneous --> Tab Checkstyle --> Specify location of configuration file where you saved it.
For the red line in the editor pane to also go to the 120 column mark (in accordance with Checkstyle) 
go to Options (Preferences on Mac) --> Editor --> Formatting tab --> set Right Margin. 

* Start working on the assignments, as specified in the per-week java, per-assignment packages under "Source Packages".  
Make sure you read the contents of each Readme.md Markdown file located within each package, since they outline the details of that particular assignment.  
There is a plugin that supports Markdown in Netbeans [Markdown Support for NetBeans](https://github.com/madflow/flow-netbeans-markdown).  
It is very handy if you want to read your assignments nicely formatted from within NetBeans.  
Alternatively, you can read it on Bitbucket -- this has the advantage that the Java syntax highlighting does work correctly!.  

* Commit your own code to your Forked repo on Bitbucket  

* To start testing a single class: Select single source file and select "Test File" from context menu (right click)

* To test all your work so far: Select project and select "Test" from context menu

* Of course you better use keyboard shortcuts! (or create a custom Toolbar)

* The test view will open and all selected tests will run. The red bars indicate failures while the green bars indicate you solved the assignment correctly!

* Good luck!
