package com.assignment;

import com.assignment.config.ConfigurationBuilder;
import com.assignment.factorymethod.TestFactory;
import com.assignment.filehandler.FileHandler;
import com.assignment.student.Student;
import com.assignment.test.MTest;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


    /**
     * Author: Rafae Waqar Qazi
     * Registration Number: 2968-FBAS/BSSE/F15
     * Section: C
     **/

//Main Class
public class Main {


    /**
     * Main Method aka Entry point of this program
     **/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder().build();
        TestFactory testFactory = new TestFactory();
        while (true){
            mainMenu();
            choice = scanner.nextLine();
            switch (choice){
                case "1":{
                    MTest additionTest = testFactory.getmTest("Addition");
                    startTest(configurationBuilder,additionTest,"+");
                }break;
                case "2":{
                    MTest subtractionTest = testFactory.getmTest("Subtraction");
                    startTest(configurationBuilder,subtractionTest,"-");
                }break;
                case "3":{
                    MTest multiplicationTest = testFactory.getmTest("Multiplication");
                    startTest(configurationBuilder,multiplicationTest,"*");
                }break;
                case "4":{
                    MTest divisionTest = testFactory.getmTest("Division");
                    startTest(configurationBuilder,divisionTest,"/");
                }break;
                case "5":{
                    showMessage("Enter Student's ID:");
                    String id = scanner.nextLine();
                    showReport(id);
                }break;
                case "6":{
                    configureTest(configurationBuilder);
                }break;
                case "7":{
                    System.exit(0);
                }break;
            }
        }


    }//End of main Method

    /**
     * static method to configure Test
     * @param configurationBuilder          ConfigurationBuilder object used to configure test
     *
     * */
    private static void configureTest(ConfigurationBuilder configurationBuilder) {
        while (true){
            configurationMenu();
            Scanner scanner = new Scanner(System.in);
            String  choice = scanner.nextLine();

            switch (choice){
                case "1":{
                    try{
                        showMessage("Existing Levels :" + configurationBuilder.getNoOfLevels());
                        showMessage("How many Levels do you want?");
                        int noOflevels = scanner.nextInt();
                        if (noOflevels>2){
                            configurationBuilder.setNoOfLevels(noOflevels).build();
                        }
                        else {
                            showMessage("Minimum Levels Should be 2");
                        }

                    }catch (NumberFormatException e){
                        showMessage("Please Enter Valid Input!");
                    }

                }break;
                case "2":{
                    try{
                        if (configurationBuilder.getNoOfLevels()<=2){
                            showMessage("Please Increase No of Levels to Change Values");
                        }
                        else {
                            showMessage("Minimum Value");
                            int minValue = scanner.nextInt();
                            showMessage("Maximum Value");
                            int maxValue = scanner.nextInt();
                            configurationBuilder.setMinValue(minValue).setMaxValue(maxValue).build();
                        }

                    }catch (NumberFormatException e){
                        showMessage("Please Enter Valid Input!");
                    }
                }break;
                case "3":{
                    try{
                        showMessage("Existing Tries :" + configurationBuilder.getNoOfTries());
                        showMessage("How many Tries do you want?");
                        int noOftries = scanner.nextInt();
                        configurationBuilder.setNoOfTries(noOftries).build();
                    }catch (NumberFormatException e){
                        showMessage("Please Enter Valid Input!");
                    }
                }break;
                case "4":{
                    try{
                        showMessage("Existing Passing Percentage :" + configurationBuilder.getPassingPercentage());
                        showMessage("Enter New Passing Percentage?");
                        int percentage = scanner.nextInt();
                        configurationBuilder.setPassingPercentage(percentage).build();
                    }catch (NumberFormatException e){
                        showMessage("Please Enter Valid Input!");
                    }
                }break;
                case "5":{
                    try{
                        showMessage("Existing Total Questions :" + configurationBuilder.getNoOfQuestions());
                        showMessage("Enter New Total Question?");
                        int totalQuestion = scanner.nextInt();
                        configurationBuilder.setNoOfQuestions(totalQuestion).build();
                    }catch (NumberFormatException e){
                        showMessage("Please Enter Valid Input!");
                    }
                }break;
                case "6":{
                    return;
                }
            }
        }
    }


    /**
     * showReport Method displays given student's test report
     * @param id        ID of student whose record is needed
     **/
    private static void showReport(String id) {
        FileHandler fileHandler = FileHandler.getInstance();

        //Record For Addition Test
        Student additionTestRecord = fileHandler.readFromFile(id,"+");
        if (additionTestRecord!=null){
            showMessage("***Addition Test Record***");
            showMessage("Student Name: "+additionTestRecord.getName());
            showMessage("Student ID: "+additionTestRecord.getStudentID());
            ArrayList<Integer> score = additionTestRecord.getScore();
            for (int i = 0; i < score.size(); i++) {
                showMessage("Addition Level "+(i+1)+" Test Score: "+additionTestRecord.getScore(i));
            }
        }else {
            showMessage("Addition Test Record Not Found!");
        }

            //Record For Subtraction Test
        Student subtractionTestRecord = fileHandler.readFromFile(id,"-");
        if (subtractionTestRecord!=null){
            showMessage("***Subtraction Test Record***");
            showMessage("Student Name: "+subtractionTestRecord.getName());
            showMessage("Student ID: "+subtractionTestRecord.getStudentID());
            ArrayList<Integer> score = subtractionTestRecord.getScore();
            for (int i = 0; i < score.size(); i++) {
                showMessage("Subtraction Level "+(i+1)+" Test Score: "+subtractionTestRecord.getScore(i));
            }
        }else {
            showMessage("Subtraction Test Record Not Found!");
        }

            //Record For Multiplication Test
        Student multiplicationTestRecord = fileHandler.readFromFile(id,"Multiplication");
        if (multiplicationTestRecord!=null){
            showMessage("***Multiplication Test Record***");
            showMessage("Student Name: "+multiplicationTestRecord.getName());
            showMessage("Student ID: "+multiplicationTestRecord.getStudentID());
            ArrayList<Integer> score = multiplicationTestRecord.getScore();
            for (int i = 0; i < score.size(); i++) {
                showMessage("Multiplication Level "+(i+1)+" Test Score: "+multiplicationTestRecord.getScore(i));
            }
        }else {
            showMessage("Multiplication Test Record Not Found!");
        }

            //Record For Division Test
        Student divisionTestRecord = fileHandler.readFromFile(id,"Division");
        if (divisionTestRecord!=null){
            showMessage("***Division Test Record***");
            showMessage("Student Name: "+divisionTestRecord.getName());
            showMessage("Student ID: "+divisionTestRecord.getStudentID());
            ArrayList<Integer> score = divisionTestRecord.getScore();
            for (int i = 0; i < score.size(); i++) {
                showMessage("Division Level "+(i+1)+" Test Score: "+divisionTestRecord.getScore(i));
            }
        }else {
            showMessage("Division Test Record Not Found!");
        }


    }

    /**
     * startTest Method conducts a test
     * @param configurationBuilder          Configuration for a test
     * @param test                          MTest object
     * @param testType                      type of ongoing test
     *
     **/
    private static void startTest(ConfigurationBuilder configurationBuilder, MTest test, String testType){
        int a,b,answer;

        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        showMessage("Enter your Name:");
        student.setName(scanner.nextLine());
        showMessage("Enter your School ID");
        student.setStudentID(scanner.nextLine());

        int level = 1;
        while (level <= configurationBuilder.getNoOfLevels()){
            showMessage("Level "+level+" Starts");
            showMessage("Answer The following Questions");
            a=test.generateNumber(level, configurationBuilder);
            b= test.generateNumber(level, configurationBuilder);
            while (test.getAttemptedQuestions()< configurationBuilder.getNoOfQuestions()){
                int tries = configurationBuilder.getNoOfTries();
                boolean attepts;
                if ((a+b)<=100 && level ==1) {
                    try{
                        showMessage("Question: "+a + " "+testType+" " + b + ":");
                        answer = scanner.nextInt();

                        attepts = test.validateAnswer(a,b,answer,tries);
                        while (!attepts){
                            showMessage("Wrong Answer! Try Again");
                            answer = scanner.nextInt();
                            attepts = test.validateAnswer(a,b,answer,tries);
                        }
                    }catch (InputMismatchException e){
                        showMessage("Enter Valid Input");
                        scanner.next();
                    }


                }
                else if ((a+b)<=1000 && level ==2){
                    showMessage("Question: "+a + " "+testType+" " + b + ":");
                    answer = scanner.nextInt();
                    attepts = test.validateAnswer(a,b,answer,tries);
                    if (!attepts){
                        showMessage("Wrong Answer! Try Again");
                        answer = scanner.nextInt();
                        attepts = test.validateAnswer(a,b,answer,tries);
                    }
                }
                else if((a+b)<= configurationBuilder.getMaxValue() && level >2){
                    showMessage("Question: "+a + " "+testType+" " + b + ":");
                    answer = scanner.nextInt();
                    attepts = test.validateAnswer(a,b,answer,tries);
                    if (!attepts){
                        showMessage("Wrong Answer! Try Again");
                        answer = scanner.nextInt();
                        attepts = test.validateAnswer(a,b,answer,tries);
                    }
                }
                a=test.generateNumber(level, configurationBuilder);
                b= test.generateNumber(level, configurationBuilder);
            }
            student.setScore(test.getCorrectAnswers());
            if (test.validateResult(test.getQuestionsToPass(configurationBuilder.getPassingPercentage(), configurationBuilder.getNoOfQuestions()),student.getScore(level-1))) {
                showMessage("Congratulations You Passed Level "+level+" Test");
                viewResult(test);
                test.resetScore();
            }
            else {
                showMessage("You Failed Level "+level+" Test");
                viewResult(test);
                break;
            }

            level++;
        }
        FileHandler fileHandler = FileHandler.getInstance();
        fileHandler.writeToFile(student,testType);
    }

    /**
     * Method to show Test Result of Respective Level
     * @param test      Mtest object for getting correct and incorrect answers of respective level
     **/

    public static void viewResult(MTest test){
        showMessage("Correct Answers: "+String.valueOf(test.getCorrectAnswers()));
        showMessage("Wrong Answers: "+String.valueOf(test.getWrongAnswers()));
    }


    //Static Method to Show Menu
    public static void mainMenu(){

        System.out.println("****Welcome To MTEST****");
        System.out.println("Please select any option");
        System.out.println("1. Addition Test");
        System.out.println("2. Subtraction Test");
        System.out.println("3. Multiplication Test");
        System.out.println("4. Division Test");
        System.out.println("5. View Report");
        System.out.println("6. Configure Test");
        System.out.println("7. Quit");
    }

    //Static Method to ConfigurationMenu
    public static void configurationMenu(){

        System.out.println("****Test ConfigurationBuilder****");
        System.out.println("Please select any option");
        System.out.println("1. Change No. of Levels");
        System.out.println("2. Change Min & Max Value");
        System.out.println("3. Change No. of Tries");
        System.out.println("4. Change Passing Percentage");
        System.out.println("5. Change Total No of Questions");
        System.out.println("6. Back");
    }

    //Static Method to Show Messages/Output
    public static void showMessage(String message){
        System.out.println(message);
    }

}
