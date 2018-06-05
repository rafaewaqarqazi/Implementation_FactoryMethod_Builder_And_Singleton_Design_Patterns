package com.assignment.factorymethod;

import com.assignment.test.*;

/**
 * TestFactory is a class to implement Factory Method Design pattern.
 * is Responsible for instantiation of Tests.
 * */
public class TestFactory {
    private MTest mTest;

    //Default Constructor
    public TestFactory() {
        mTest = null;
    }


    /**
     * Method to Instantiate and return TestType
     * @param testType          Test to instantiate
     * @return                  Object of MTest depending on testType
     * */
    public MTest getmTest(String testType) {
        if (testType.equals("Addition")){
            mTest = new AdditionTest();
            return mTest;
        }
        else if (testType.equals("Subtraction")){
            mTest = new SubtractionTest();
            return mTest;
        }
        else if (testType.equals("Multiplication")){
            mTest = new MultiplicationTest();
            return mTest;
        }
        else if (testType.equals("Division")){
            mTest = new DivisionTest();
            return mTest;
        }
        else {
            return mTest;
        }
    }

}//End of class

