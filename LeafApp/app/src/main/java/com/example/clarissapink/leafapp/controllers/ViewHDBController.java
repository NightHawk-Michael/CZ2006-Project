package com.example.clarissapink.leafapp.controllers;


import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * ViewHDBController is control class which handle all the application logic for view HDB function.
 * @author Michael
 * Created on 19 March 2016
 */
public class ViewHDBController {
    protected HDBCollection HDBcollection = new HDBCollection();
    protected List<HDBFlat> HDBlist;
    protected JSONObject userInputs = new JSONObject();
    protected List<HDBFlat> searchResults;

    /**
     * Constructor which construct a HDBList
     */
    public ViewHDBController(){
        HDBlist = HDBcollection.getCollection();
    }

    /**
     * Update all the User Inputs.
     * @param monthlyIncome
     * @param amtRepay
     * @param yearToPay
     * @param loanAmt
     * @param typeOfGrant
     * @param selectedSale
     * @param selectedRoomType
     * @param region
     */
    public void updateUserInput(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){
        try {
            userInputs.put("MonthlyIncome", monthlyIncome);
            userInputs.put("AmountRpay", amtRepay);
            userInputs.put("YearToPay", yearToPay);
            userInputs.put("LoanAmount", loanAmt);
            userInputs.put("TypeOfGrand", typeOfGrant);
            userInputs.put("SelectedSale", selectedSale);
            userInputs.put("SelectedRoomType", selectedRoomType);
            userInputs.put("Region", region);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * all values are passed into userInput Json Object.
     * check how HDB Collection is stored.
     * Match all the parameters with the suitable HDBFlat in the database.
     * @param monthlyIncome
     * @param amtRepay
     * @param yearToPay
     * @param loanAmt
     * @param typeOfGrant
     * @param selectedSale
     * @param selectedRoomType
     * @param region
     */
    public void findFlats(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){
        updateUserInput(monthlyIncome,amtRepay,yearToPay,loanAmt,typeOfGrant,selectedSale,selectedRoomType,region);
        ArrayList<HDBFlat> resultList = new ArrayList<HDBFlat>();
        /* fill in the code here */
        searchResults = resultList;
    }

    /**
     * transfer the data to the view of HDB list.
     * @param HDBlist
     */
    public void displayList(ArrayList<HDBFlat> HDBlist){
        /* fill in the code here */
    }
}
