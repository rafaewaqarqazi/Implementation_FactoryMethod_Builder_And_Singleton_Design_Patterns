package com.assignment.filehandler;


import com.assignment.student.Student;
import com.assignment.test.AdditionTest;
import com.assignment.test.MTest;
import com.assignment.test.SubtractionTest;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
    /**
     * FileHandler is a Singleton Class
     * Handle File's read and write operations
     * */
public class FileHandler {

    //Member Variables
    static FileHandler instance;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    /**
     * private Default Constructor
     * */
    private FileHandler(){
        fileOutputStream = null;
        objectOutputStream = null;
        fileInputStream = null;
        objectInputStream = null;
    }

    /**
     * Method to get an Instance of FileHandler class
     * @return          Instance of FileHandler class
     * */
    public static FileHandler getInstance() {
        if (instance == null){
            instance = new FileHandler();
            return instance;
        }
        else {
            return instance;
        }
    }

    /**
     * Method to Read Object From File of a Student
     * @param student           Student object to write in File
     * @param testType          Test Type of student to name file e.g add, sub etc
     * */
    public void writeToFile(Student student,String testType){

        if (testType.equals("*")){
            testType = "Multiplication";
        }
        else if(testType.equals("/")){
            testType = "Division";
        }
        try {
            fileOutputStream = new FileOutputStream(student.getStudentID()+testType+".txt",false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to Read Object From File of a Student
     * @param studentID         Id of student whose file to be read
     * @param testType          Test Type of student e.g add, sub etc
     * @return                  Object of Type Student
     * */

    public Student readFromFile(String studentID,String testType) {
        Student student = null;
        File file = new File(studentID+testType+".txt");
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                student = (Student) objectInputStream.readObject();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return student;
    }



}//End of class
