package com.example.clarissapink.leafapp.controllers;


import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;
import com.example.clarissapink.leafapp.models.UserInputs;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewHDBController is control class which handle all the application logic for view HDB function.
 * @author Michael
 * Created on 19 March 2016
 */
public class ViewHDBController {
    protected HDBCollection collection = new HDBCollection();
    //    protected List<HDBFlat> HDBlist;
//    protected JSONObject userInputs = new JSONObject();
    protected List<HDBFlat> searchResults;
    protected UserInputs inputs;

    /**
     * Constructor which construct a HDBList
     */
    public ViewHDBController(HDBCollection collection, UserInputs inputs){
        this.collection = collection;
        this.inputs = inputs;
    }
//
//    /**
//     * Update all the User Inputs.
//     * @param monthlyIncome
//     * @param amtRepay
//     * @param yearToPay
//     * @param loanAmt
//     * @param typeOfGrant
//     * @param selectedSale
//     * @param selectedRoomType
//     * @param region
//     */
//    public void updateUserInput(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){
//        try {
//            userInputs.put("MonthlyIncome", monthlyIncome);
//            userInputs.put("AmountRpay", amtRepay);
//            userInputs.put("YearToPay", yearToPay);
//            userInputs.put("LoanAmount", loanAmt);
//            userInputs.put("TypeOfGrand", typeOfGrant);
//            userInputs.put("SelectedSale", selectedSale);
//            userInputs.put("SelectedRoomType", selectedRoomType);
//            userInputs.put("Region", region);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }


//    /**
//     * all values are passed into userInput Json Object.
//     * check how HDB Collection is stored.
//     * Match all the parameters with the suitable HDBFlat in the database.
//     * @param monthlyIncome
//     * @param amtRepay
//     * @param yearToPay
//     * @param loanAmt
//     * @param typeOfGrant
//     * @param selectedSale
//     * @param selectedRoomType
//     * @param region
//     */
//    public void findFlats(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){
//        updateUserInput(monthlyIncome,amtRepay,yearToPay,loanAmt,typeOfGrant,selectedSale,selectedRoomType,region);
//        ArrayList<HDBFlat> resultList = new ArrayList<HDBFlat>();
//
//        searchResults = resultList;
//    }

//    /**
//     * transfer the data to the view of HDB list.
//     * @param HDBlist
//     */
//    public void displayList(ArrayList<HDBFlat> HDBlist){
//        /* fill in the code here */
//    }

    public List<HDBFlat> findFlats(String roomType, String region, String priceRange){
        List<HDBFlat> searchResults = new ArrayList<HDBFlat>();
        for(HDBFlat flat: collection.getCollection()){
            if(flat.getRoomType()==roomType && flat.getTown()==region && Integer.parseInt(priceRange)<=Integer.parseInt(flat.getMinPrice())){
                searchResults.add(flat);
            }
        }
        if (searchResults != null){
            return searchResults;
        }
        else return null;
    }
}
