package com.assignment.test;


import com.assignment.config.ConfigurationBuilder;

import java.util.Random;

//MTest Class which generates Random Numbers and keeps record of correct and incorrect Answers
public abstract class MTest{

    private Random random;
    private int attemptedQuestions,correctAnswers,wrongAnswers;


    //Default Constructor
    public MTest(){

        correctAnswers = 0;
        attemptedQuestions = 0;
        wrongAnswers = 0;
        random = new Random();
    }

    /**
     * Method Which generates Random Number Depending on level
     * @param level             Level number
     * @param configurationBuilder     ConfigurationBuilder Object, for getting min and max value for levels greater than 2.
     * @return                  Random Number, Depending on Level
     * */
    public int generateNumber(int level,ConfigurationBuilder configurationBuilder){
        if (level == 1){
            return (random.nextInt(100)+1);
        }
        else if (level == 2){
            return (random.nextInt(1000)+100);
        }
        else {
            return (random.nextInt(configurationBuilder.getMaxValue())+ configurationBuilder.getMinValue());
        }
    }

    /**
     * Method to Validate Test Result
     * @param questionsToPass   Questions that a student have to pass
     * @param score             how many question a student have passes
     **/
    public boolean validateResult(int questionsToPass, int score){
        if (score>=questionsToPass && questionsToPass !=0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
    * Abstract Method whose implementation is mandatory for child classes
    * @param a          First Value of the question
    * @param b          Second Value of the question
    * @param answer     Answer Given by student to validate
    * @return           true, if answer is correct. false, if answer is incorrect
    **/

    public abstract boolean validateAnswer(int a,int b,int answer,int tries);


    /**
     * Method which calculates number of questions to pass test
     * @param percentage    percentage to pass test
     * @return              number of questions to pass according to percentage
     * */
    public int getQuestionsToPass(int percentage,int totalQuestions) {
        return  ((percentage*totalQuestions)/100);
    }


    //Method to Increment Correct Answer
    protected void incrementCorrectAnswer(){
        correctAnswers++;
    }

    //Method to Increment Wrong Answers
    protected void incrementWrongAnswers(){
        wrongAnswers++;
    }

    //Method to Increment Attempted Questions
    protected void incrementAttemptedQuestions(){
        attemptedQuestions++;
    }

    //Method to reset Score
    public void resetScore(){
        correctAnswers = 0;
        attemptedQuestions = 0;
        wrongAnswers = 0;
    }

    //Getters
    public int getAttemptedQuestions() {
        return attemptedQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

}//End Of Class
