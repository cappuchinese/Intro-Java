package section3_apis.part2_collections;

import java.util.List;
import java.util.Map;

public class StudentAdmin {

    /**
     * Returns the students that are present in the database.
     * If the searchString is * (a wildcard), all students will be returned. Else,
     * a simple case insensitive substring match to both first name and family name will be performed.
     * @param searchString the substring string to look for
     * @return students
     */
    public List<Student> getStudents(String searchString) {
        return null;
    }

    /**
     * Returns the grade of a student for the given course
     * @param student the student
     * @param course the course
     * @return grade
     */
    public double getGrade(Student student, Course course) {
        return 0;
    }

    /**
     * returns all grades for a student, as [key=CourseID]:[value=Grade] Map
     * @param student the student to fetch grades for
     * @return grades
     */
    public Map<String, Double> getGradesForStudent(Student student) {
        return null;
    }

    /**
     * Returns all grades for a course, as [key=Student]:[value=Grade] Map
     * @param course the course
     * @return grades
     */
    public Map<Student, Double> getGradesForCourse(Course course) {
        return null;
    }
}
