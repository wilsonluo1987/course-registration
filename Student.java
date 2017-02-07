package javacollegecourseprogram;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author UCI Java 1 - Team C
 * Members: Rhett Hartsfield, Wen Luo, Tommy lee
 */
public class Student implements Comparable, Cloneable {

    protected int id;
    protected String name;
    protected ArrayList<Course> courses = new ArrayList<Course>();
    protected final int maxCourses = 7;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
//        courses = new Course[this.maxCourses];
    }   
 //Student Drop Course
    public boolean dropCourse(Course course) {
        if (!doesCourseExist(course)) {
            return false;
        }

        return removeCourse(course);

    }
    
    protected boolean removeCourse(Course course) {
   
        for (Course cr : courses) {
            if (cr.getID() == course.getID()) {
                courses.remove(cr);
                return true;
            }
        }
        
        return false;
    }
// Student Add Course
    public boolean addCourse(Course course){      
        if(doesCourseExist(course)) {
            return false;
        }
        
        courses.add(course);
        
        return true;
    }
 // VERIFY Course Exists   
    protected boolean doesCourseExist(Course course){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getID() == course.getID()) {
                 return true;
            }
        }
        return false;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        int compareage=((Student)o).getID();
        return this.id-compareage;
    }
    
    public String getCourses() {
        
        Collections.sort(courses, Course.CourseNameComparator);
        
        return this.toString();
    }
    
    public String toString() {
        String s = "ID:" + this.id + 
                "\nName: " + this.name + 
                "\nCourses:\n";

        if (this.courses.size() == 0) {
            return s + "No courses Available! \n";
        }

        for (int i = 0; i < this.courses.size(); i++) {
            s += "Course " + i + ":\n" + this.courses.get(i).toList()+ "\n";
        }

        return s;
    }
    
    public String toList() {
        String s = "ID:" + this.id + 
                "\nName: " + this.name + 
                "\nCourses: " + this.courses.size() + "\n";                
        return s;
    }
    
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}