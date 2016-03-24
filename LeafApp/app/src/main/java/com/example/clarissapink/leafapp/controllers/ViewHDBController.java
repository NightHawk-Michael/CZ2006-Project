package com.example.clarissapink.leafapp.controllers;


import android.os.Parcel;
import android.os.Parcelable;

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
public class ViewHDBController implements Parcelable {
    protected HDBCollection collection = new HDBCollection();
    //    protected List<HDBFlat> HDBlist;
//    protected JSONObject userInputs = new JSONObject();
    protected List<HDBFlat> searchResults;

    /**
     * Constructor which construct a HDBList
     */
    public ViewHDBController(HDBCollection collection){
        this.collection = collection;
    }

    public ViewHDBController(Parcel in){
        this.collection = in.readParcelable(HDBCollection.class.getClassLoader());
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

    public List<HDBFlat> findFlats(UserInputs inputs){
        List<HDBFlat> searchResults = new ArrayList<HDBFlat>();
        String roomType = inputs.getSelectedRoomType();
        String region = inputs.getRegion();
        String priceRange = inputs.getPriceRange();
        for(HDBFlat flat: collection.getCollection()){
            if(flat.getTown().equals(region)){
                switch (priceRange) {
                    case "50,001 - 200,000":
                        if (flat.getMinPrice() >= 50000 && flat.getMaxPrice() <= 200000) {
                            if (flat.getRoomType().equals(roomType)) {
                                searchResults.add(flat);
                            }
                        }
                        break;
                    case "200,001 - 400,000":
                        if (flat.getMinPrice() >= 200001 && flat.getMaxPrice() <= 400000) {
                            if (flat.getRoomType().equals(roomType)) {
                                searchResults.add(flat);
                            }
                        }
                        break;
                    case "400,001 - 600,000":
                        if (flat.getMinPrice() >= 400001 && flat.getMaxPrice() <= 600000) {
                            if (flat.getRoomType().equals(roomType)) {
                                searchResults.add(flat);
                            }
                        }
                        break;
                    case ">600000":
                        if (flat.getMinPrice() > 600000) {
                            if (flat.getRoomType().equals(roomType)) {
                                searchResults.add(flat);
                            }
                        }
                        break;
                }


            }
        }
        if (searchResults != null){
            return searchResults;
        }
        else return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(collection,flags);

    }
    public static Parcelable.Creator<ViewHDBController> CREATOR = new Parcelable.Creator<ViewHDBController>(){

        @Override
        public ViewHDBController createFromParcel (Parcel source){
            return new ViewHDBController(source);
        }
        public ViewHDBController[] newArray(int size) {
            return new ViewHDBController[size];
        }
    };
}
