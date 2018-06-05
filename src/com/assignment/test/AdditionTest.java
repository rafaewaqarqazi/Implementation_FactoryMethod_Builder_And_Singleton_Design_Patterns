package com.assignment.test;

/**
 * AdditionTest Class (Extended from MTest), which validates and Increments correct and wrong answers.
 * */

public class AdditionTest  extends MTest {
    //Member variable
    private int attempts;

    //Default Constructor
    public AdditionTest(){
        super();
        attempts = 0;
    }

    /**
     * Method which validates and increments correct and incorrect answers overrided from MTest class
     * @param a             First Value of a question
     * @param b             Second Value of a question
     * @param answer        Answer given by Student
     * @param tries         Tries to answer any question
     * @return              true, if answer is correct. false, if answer is incorrect
     *
     **/

    @Override
    public boolean validateAnswer(int a, int b, int answer,int tries) {
        if (answer==(a+b)){
            attempts = 0;
            incrementCorrectAnswer();

        }
        else {
            if (attempts==(tries-1)){
                incrementWrongAnswers();
                attempts= 0;
            }
            else {
                attempts++;
                return false;
            }
        }
        incrementAttemptedQuestions();
        return true;
    }




}//End of Class
