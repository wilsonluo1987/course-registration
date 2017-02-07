package javacollegecourseprogram;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @author UCI Java 1 - Team C
 * Members: Rhett Hartsfield, Wen Luo, Tommy lee
 */
public class Manager {

    protected ArrayList<Course> courses = new ArrayList<Course>();
    protected ArrayList<Student> students = new ArrayList<Student>();

//  Add data
    public void dataFaker() {
        for (int i = 1; i < 20; i++) {
            students.add(new Student(generateStudentID(), this.generateName()));
        }
// COURSES
        courses.add(new Course(generateCourseID(), "Web Developer", this.generateName(), "Summer 2016", 5));
        courses.add(new Course(generateCourseID(), "Java I", this.generateName(), "Summer 2016", 3));
        courses.add(new Course(generateCourseID(), "Intro to C++ ", this.generateName(), "Summer 2016", 2));
        courses.add(new Course(generateCourseID(), "Intro to Swift", this.generateName(), "Fall 2016", 4));

    }
// GENERATE Random Description
    public String generateName() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }
// Drop Student from Course
    public String dropStudentFromCourse(int studentID, int courseID) {
        Student st = getStudentByID(studentID);

        if (st == null) {
            return "Please Enter a valid student Id.\n";
        }

        Course cr = getCourseByID(courseID);

        if (cr == null) {
            return "Please Enter a valid course Id.\n";
        }

        if (st.dropCourse(cr) && cr.dropStudent(st)) {
            return "Successfully dropped student from course.\n" + cr.toString();
        }

        return "unable to drop student from course.\n";
    }
 //Add Student to Course

    public String addStudentToCourse(int studentID, int courseID) {
        Student st = getStudentByID(studentID);

//Verify Student ID
        if (st == null) {
            return "Please Enter a valid student Id.\n";
        }
//Verify Course Exists
        Course cr = getCourseByID(courseID);

        if (cr == null) {
            return "Please Enter a valid course Id.\n";
        }
//Verify Course Limit
        if (cr.isCourseFull()) {
            return "Course is Full, Please choose diffrent course Id.\n";
        }
//Store Registration Sucess in Text File
        if (st.addCourse(cr) && cr.addStudent(st)) {
            Storage storage = new Storage("Successfully added student {" + st.getName() + "} #" + st.getID() + " To the course {" + cr.getName() + " #" + cr.getID() + "}, ");
            return "Successfully added student to course.\n" + cr.toString();
        }

        return "Student already enrolled in course!\n";//Verify not already enrolled

    }


    public Student getStudentByID(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == id) {
                return students.get(i);
            }
        }
        return null;
    }

    public String getStudentCoursesByID(int studentID) {
        Student st = getStudentByID(studentID);

        if (st == null) {
            return "Please Enter a valid student Id.\n";
        }

        return st.getCourses();
    }

    public Course getCourseByID(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getID() == id) {
                return courses.get(i);
            }
        }
        return null;
    }

    public String addNewStudent(String name) {
        String s = "Successfully added student.\n";
        students.add(new Student(this.generateStudentID(), name));
        return s + students.get(students.size() - 1).toString();
    }

    public String addNewCourse(String name, String summary, String dates, int limit) {
        String s = "Successfully added course.\n";
        courses.add(new Course(this.generateCourseID(), name, summary, dates, limit));
        return s + courses.get(courses.size() - 1).toString();
    }

    public int generateCourseID() {
        if (courses.size() == 0) {
            return 0;
        }
        Collections.sort(courses, Course.CourseIDComparator);
        return courses.get(courses.size() - 1).getID() + 1;
    }

    public int generateStudentID() {
        if (students.size() == 0) {
            return 0;
        }
        Collections.sort(students);
        return students.get(students.size() - 1).getID() + 1;
    }

    public String getStudentsDetails() {
        String s = "";
        for (int i = 0; i < students.size(); i++) {
            s += "--------------------------------------";
            s += "\n" + students.get(i).toString();
        }
        return s;
    }

    public String getStudentsList() {
        String s = "";
        for (int i = 0; i < students.size(); i++) {
            s += "--------------------------------------";
            s += "\n" + students.get(i).toList();
        }
        return s;
    }

    public String getCoursesDetails() {

        Collections.sort(courses, Course.CourseNameComparator);

        String s = "";
        for (int i = 0; i < courses.size(); i++) {
            s += "--------------------------------------";
            s += "\n" + courses.get(i).toString();
        }
        return s;
    }

    public String getCoursesList() {
        String s = "";
        for (int i = 0; i < courses.size(); i++) {
            s += "--------------------------------------";
            s += "\n" + courses.get(i).toList();
        }
        return s;
    }
}
