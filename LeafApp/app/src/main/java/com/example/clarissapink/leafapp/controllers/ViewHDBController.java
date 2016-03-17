package com.example.clarissapink.leafapp.controllers;

/**
 * Created by Michael on 18/3/2016.
 */

import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;
public class ViewHDBController {
    protected HDBCollection HDBcollection = new HDBCollection();
    protected ArrayList<HDBFlat> HDBlist;
    protected JSONObject userInputs = new JSONObject();
    protected ArrayList<HDBFlat> searchResults;

    public ViewHDBController(){
        HDBlist = HDBcollection.getCollection();
    }

    public void updateUserInput(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType){
        try {
            userInputs.put("MonthlyIncome", monthlyIncome);
            userInputs.put("AmountRpay", amtRepay);
            userInputs.put("YearToPay", yearToPay);
            userInputs.put("LoanAmount", loanAmt);
            userInputs.put("TypeOfGrand", typeOfGrant);
            userInputs.put("SelectedSale", selectedSale);
            userInputs.put("SelectedRoomType", selectedRoomType);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void locateRegion(String region){
        try {
            userInputs.put("Region", region);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void findFlats(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){
        updateUserInput(monthlyIncome,amtRepay,yearToPay,loanAmt,typeOfGrant,selectedSale,selectedRoomType);
        locateRegion(region);
        // all values are passed into userInput Json Object
        // check how HDB Collection is stored.
        // Match all the parameters with the suitable HDBFlat in the database
        ArrayList<HDBFlat> resultList = new ArrayList<HDBFlat>();
        /* fill in the code here */
        searchResults = resultList;
    }

    public void displayList(ArrayList<HDBFlat> HDBlist){
        /* fill in the code here */
    }
}
