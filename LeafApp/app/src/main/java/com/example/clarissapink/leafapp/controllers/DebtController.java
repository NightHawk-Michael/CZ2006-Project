package com.example.clarissapink.leafapp.controllers;

/**
 * GrantController is control class which handle all the application logic for grant function.
 * @author Michael
 * Created on 19 March 2016.
 */
public class DebtController {

    /**
     * Constructor instantiate the DebtController.
     */
    public DebtController(){}

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
     * Calculate the debt that user have to bear according to the user inputs and the choice of flat.
     * @return debt debt that is calculated from the user input
     */
    public double calculateDebt(){
        double debt = 0; // will be changed to be a formular returning debt as a double result

        return debt;
    }

    /**
     * transfer the data to the ViewDebtRepayment view.
     */
    public void displayDebt(){

    }
}
