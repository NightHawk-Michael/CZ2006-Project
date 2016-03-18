package com.example.clarissapink.leafapp.controllers;

/**
 * GrantController is control class which handle all the application logic for grant function.
 * @author Michael
 * Created on 19 March 2016
 */
public class GrantController {

    /**
     * Constructor
     */
    public GrantController(){}

    /**
     * Update all the user inputs
     * @param monthlyIncome
     * @param amtRepay
     * @param yearToPay
     * @param loanAmt
     * @param typeOfGrant
     * @param selectedSale
     * @param selectedRoomType
     * @param region
     */
    public void updateUserInputs(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){

    }

    /**
     * Generate grant value according to the user inputs.
     * @return grant grant amount that user should receive according to their inputs
     */
    public double generateGrant(){
        double grantCalculated = 0; // will be changed to be a formular later

        return grantCalculated;
    }

    /**
     * transfer the data to the ApplicableGrantResult view.
     */
    public void displayGrant(){

    }

}
