package javacollegecourseprogram;


import java.io.FileWriter;
import java.io.IOException;

/**
* @author UCI Java 1 - Team C
 * Members: Rhett Hartsfield, Wen Luo, Tommy lee
     */

// Storage Class used to store registration success in text file
public class Storage {

    protected final String filename = "registered-students.txt";

    Storage(String info) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(info);
            //fw.write(System.getProperty("line.separator"));
            fw.close();
        } catch (IOException ioe) {
            System.err.println("Unable to save data into file.");
        }
    }

}
