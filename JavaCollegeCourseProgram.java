package javacollegecourseprogram;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.lang.model.util.Elements;

/**
* @author UCI Java 1 - Team C
 * Members: Rhett Hartsfield, Wen Luo, Tommy lee
 */
public class JavaCollegeCourseProgram {
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Manager manager = new Manager();
        
        java.util.Scanner userInput;

        while (true) {
            userInput = new java.util.Scanner(System.in);
            System.out.println("Welcome to Course Manager!");
            System.out.println("Select an action based on the following menu:");
            System.out.println("e - Exit");
            System.out.println("s - Manage Students");
            System.out.println("c - Manage Courses");
            System.out.println("f - Generate Fake Records(Test)");
            String cmd = userInput.next();

            if (cmd.equalsIgnoreCase("e")) {
                System.out.println("GoodBye!");
                break;
            }

            switch (cmd) {
                case "s":
                    processStudent(manager);
                    break;
                case "f":
                    manager.dataFaker();
                    break;
                case "c":
                    processCourse(manager);
                    break;
                default:
                    System.out.println("Oops, the option not valid!");
                    continue;
            }

        }
    }

    public static void processStudent(Manager manager) {

        java.util.Scanner userInput;
        String result;

        while (true) {
            userInput = new java.util.Scanner(System.in);
            System.out.println("Welcome to Student Manager!");
            System.out.println("Select an action based on the following menu:");
            System.out.println("mm - Main Menu");
            System.out.println("lsc - List Student Courses");
            System.out.println("ans - Add New Student");
            System.out.println("pas - Print All Students");
            String cmd = userInput.next();

            if (cmd.equalsIgnoreCase("mm")) {
                System.out.println("Main Menu!");
                break;
            }

            result = "";
            try {
                switch (cmd) {
                    case "pas":
                        result = manager.getStudentsDetails();
                        break;
                    case "ans":
                        System.out.println("Enter Student Name:");
                        String name = userInput.next();
                        result = manager.addNewStudent(name);
                        break;
                    case "lsc":
                        System.out.println(manager.getStudentsList());
                        System.out.println("Enter Student ID:");
                        int studentID = userInput.nextInt();
                        result = manager.getStudentCoursesByID(studentID);
                        break;
                    default:
                        System.out.println("Oops, the option not valid!");
                        continue;
                }
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Oops, something went wrong!" + e.toString());
            }

        }
    }

    public static void processCourse(Manager manager) {

        java.util.Scanner userInput;
        String result;

        while (true) {
            userInput = new java.util.Scanner(System.in);
            System.out.println("Welcome to Course Manager!");
            System.out.println("Select an action based on the following menu:");
            System.out.println("mm - Main Menu");            
            System.out.println("as - Add Student To Course");
            System.out.println("ds - Drop Student From Course");
            System.out.println("anc - Add New Course");
            System.out.println("pac - Print All Courses");
            String cmd = userInput.next();

            if (cmd.equalsIgnoreCase("mm")) {
                System.out.println("Main Menu!");
                break;
            }

            result = "";
            try {
                switch (cmd) {
                    case "pac":
                        result = manager.getCoursesDetails();
                        break;
                    case "anc":
                        System.out.println("Enter Course Name:");
                        String name = userInput.next();
                        
                        System.out.println("Enter Course Summary:");
                        String summary = userInput.next();
                        
                        System.out.println("Enter Course Dates:");
                        String dates = userInput.next();
                        
                        System.out.println("Enter Course Limit:");
                        int limit = userInput.nextInt();
                        
                        result = manager.addNewCourse(name, summary, dates, limit);
                        
                        break;
                    case "as":
                        System.out.println(manager.getStudentsList());
                        System.out.println("Enter Student ID:");
                        int sid = userInput.nextInt();
                        System.out.println(manager.getCoursesList());
                        System.out.println("Enter Course ID:");
                        int cid = userInput.nextInt();
                        result = manager.addStudentToCourse(sid, cid);
                        break;
                    case "ds":
                        System.out.println(manager.getCoursesDetails());
                        System.out.println("Enter Student ID:");
                        int dsid = userInput.nextInt();
                        System.out.println("Enter Course ID:");
                        int dcid = userInput.nextInt();
                        result = manager.dropStudentFromCourse(dsid, dcid);
                        break;                    
                    default:
                        System.out.println("Oops, the option not valid!");
                        continue;
                }
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Oops, something went wrong!");
            }

        }
    }

}