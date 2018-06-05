package com.assignment.student;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Student Class contains student's name, id and tests score.
 * Implements Serializable to read and write into a file
 **/

public class Student implements Serializable{
    private String name;
    private String studentID;
    private ArrayList<Integer> score;

    //Default Constructor
    public Student(){
        name = "";
        studentID = "";
        score = new ArrayList<>();
    }

    /**
     * Method to get Score of given level
     * @param level         level of which test score is required
     * @return              Score of a given level
     * */
    public int getScore(int level) {
        return score.get(level);
    }

    /**
     * Method to set Score of a level
     * @param score         Score of a level
     * */
    public void setScore(int score) {
        this.score.add(score);
    }


    //Getters & Setters Started
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public void setScore(ArrayList<Integer> score) {
        this.score = score;
    }

    //Getters & Setters Ended

}//End of Class
