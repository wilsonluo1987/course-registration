package javacollegecourseprogram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
* @author UCI Java 1 - Team C
 * Members: Rhett Hartsfield, Wen Luo, Tommy lee
 */
public class Course implements Cloneable {

    protected int id;
    protected String name;
    protected String summary;
    protected String dates;
    protected int enrollmentLimit = 30;
    protected ArrayList<Student> students = new ArrayList<Student>();

    Course(int id, String name, String summary, String dates, int enrollmentLimit) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.dates = dates;
        this.enrollmentLimit = enrollmentLimit;
    }

    public boolean isCourseFull() {

        return students.size() >= enrollmentLimit;
    }

    public boolean dropStudent(Student student) {
        if (!doesStudentExist(student)) {
            return false;
        }

        return removeStudent(student);

    }

    protected boolean removeStudent(Student student) {
       
        for (Student st : students) {
            if (st.getID() == student.getID()) {
                students.remove(st);
                return true;
            }
        }
  
        return false;
    }

    public boolean addStudent(Student student) {
        if (doesStudentExist(student)) {
            return false;
        }

        students.add(student);

        return true;
    }

    protected boolean doesStudentExist(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getID() == student.getID()) {
                return true;
            }
        }
        return false;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static Comparator<Course> CourseIDComparator = new Comparator<Course>() {

        public int compare(Course c1, Course c2) {
            int CourseID1 = c1.getID();
            int CourseID2 = c2.getID();

            return CourseID1 - CourseID2;
        }
    };

    public static Comparator<Course> CourseNameComparator = new Comparator<Course>() {

        public int compare(Course c1, Course c2) {
            String CourseName1 = c1.getName().toUpperCase();
            String CourseName2 = c2.getName().toUpperCase();

            return CourseName1.compareTo(CourseName2);
        }
    };

    public String toString() {
        String s = "ID:" + this.id
                + "\nName: " + this.name
                + "\nSummary: " + this.summary
                + "\nDates: " + this.dates
                + "\nStudents Enrolled: " + students.size()
                + "\nMax Students: " + this.enrollmentLimit
                + "\nStudents:\n";

        if (this.students.size() == 0) {
            return s + "No Students registered! \n";
        }

        for (int i = 0; i < this.students.size(); i++) {
            s += "Student " + i + ":\n" + this.students.get(i).toList() + "\n";
        }

        return s;
    }

    public String toList() {
        String s = "ID:" + this.id
                + "\nName: " + this.name
                + "\nStudents Enrolled: " + students.size()
                + "\nMax Students: " + this.enrollmentLimit + "\n";
        return s;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}