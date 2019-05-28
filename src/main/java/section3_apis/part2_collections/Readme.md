# Collections

## Learning outcomes
* Getting to know collection types 
* Processing and coupling data
* First encounter of encapsulation



## Assignment 

1. In this package you will find class `FindTheRightCollection`. 
It has a few methods that should all return a class - the class of the correct 
class. The Javadoc above the method will describe what should be returned.
The first case is already implemented so you get the gist.
The JUnit tests will tell you if the solutions are OK.

2. In the `data` folder you will find the two data files `students.txt` and `courses.csv`. 
These represent the students and their course results for three courses. 
In this current package four classes are already present: `Student`, `Course`, `StudentAdmin` and `StudentAdminDataReader`. 
Class `Student` is completely implemented. Class `Course` needs additional code to store the grades. 
Class `StudentAdmin` only publishes its public API through method stubs, without any implementation. 
Finally, class `StudentAdminDataReader` contains the basic file reader functionality. Note the use of a dedicated 
interface to abstract away all common code in this class.    
**It is your task to implement all necessary code to support the public API correctly, using the correct collection types.**

To protect your data, it is never allowed to simply return the reference to a collection type via a getter. The concept is called **_encapsulation_** and violating it looks like this:

```java
package section3_apis.part2_collections;

import java.util.ArrayList;
import java.util.List;

public class StudentCollection {
    private List<Student> students = new ArrayList<>();
    
    public List<Student> getStudents() {
        /*DANGER! data encapsulion breached!*/
        return students;
    }
}
```

Much better and safer is this already:

```java
package section3_apis.part2_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentCollection {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        /*Data is safe from external corruption*/
        return Collections.unmodifiableList(students);
    }
}
```

For largely this same reason, class `Student` has been implemented **_immutable_**.

The JUnit tests will tell you when you are finished.
