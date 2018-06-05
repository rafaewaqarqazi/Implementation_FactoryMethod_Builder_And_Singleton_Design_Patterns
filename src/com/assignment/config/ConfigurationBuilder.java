package com.assignment.config;

/**
 * ConfigurationBuilder class configures test
 **/
public class ConfigurationBuilder {
    // Member variables whose values are must
    private int noOfLevels = 2;
    private int noOfTries = 2;
    private int passingPercentage = 70;
    private int noOfQuestions = 5;

    //Optional variables used in levels > 2

    private int minValue;
    private int maxValue;

    /**
     * Method to build given configuration
     * @return          ConfigurationBuilder object
     * */
    public ConfigurationBuilder build(){
        return this;
    }


    /**
     * Getters And Setters for Builder
     * */
    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public ConfigurationBuilder setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
        return this;
    }

    public int getNoOfLevels() {
        return noOfLevels;
    }

    public ConfigurationBuilder setNoOfLevels(int noOfLevels) {
        this.noOfLevels = noOfLevels;
        return this;
    }

    public int getNoOfTries() {
        return noOfTries;
    }

    public ConfigurationBuilder setNoOfTries(int noOfTries) {
        this.noOfTries = noOfTries;
        return this;
    }

    public int getPassingPercentage() {
        return passingPercentage;
    }

    public ConfigurationBuilder setPassingPercentage(int passingPercentage) {
        this.passingPercentage = passingPercentage;
        return this;
    }

    public int getMinValue() {
        return minValue;
    }

    public ConfigurationBuilder setMinValue(int minValue) {
        this.minValue = minValue;
        return this;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public ConfigurationBuilder setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
