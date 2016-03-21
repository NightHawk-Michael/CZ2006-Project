package com.example.clarissapink.leafapp.controllers;

import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;
import com.example.clarissapink.leafapp.models.UserInputs;

import java.util.List;

/**
 * GrantController is control class which handle all the application logic for grant function.
 * @author Michael
 * Created on 19 March 2016.
 */
public class AffordableFlatController {
    protected HDBCollection collection = new HDBCollection();
    protected List<HDBFlat> searchResults;
    protected UserInputs inputs;
    /**
     * Constructor instantiates AffordableFlatController.
     */
    public AffordableFlatController(){}

    public AffordableFlatController(HDBCollection collection, UserInputs inputs){
        this.collection = collection;
        this.inputs = inputs;
    }
    /**
     * Update all user inputs
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
     * Transfer all data to the AffordableFlatResultView view
     */
    public void displayList(){

    }

}
