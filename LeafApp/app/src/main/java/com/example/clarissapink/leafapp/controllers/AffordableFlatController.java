package com.example.clarissapink.leafapp.controllers;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;
import com.example.clarissapink.leafapp.models.UserInputs;

import java.util.ArrayList;
import java.util.List;

/**
 * GrantController is control class which handle all the application logic for grant function.
 * @author Michael
 * Created on 19 March 2016.
 */
public class AffordableFlatController implements Parcelable {
    protected HDBCollection collection = new HDBCollection();
    protected List<HDBFlat> searchResults;
    protected UserInputs inputs;
    /**
     * Constructor instantiates AffordableFlatController.
     */
    public AffordableFlatController(){}

    public AffordableFlatController(HDBCollection collection){
        this.collection = collection;
        this.inputs = inputs;
    }

    public AffordableFlatController(Parcel in){
        this.collection = in.readParcelable(AffordableFlatController.class.getClassLoader());
    }

    public List<HDBFlat> findAffordableFlats(UserInputs inputs) {
        List<HDBFlat> searchResults = new ArrayList<HDBFlat>();
        double monthlyInstallment = inputs.getMonthlyIncome();
        int repaymentPeriod = inputs.getYearToPay();
        double totalFlatPrice = 12 * monthlyInstallment * repaymentPeriod;
        for(HDBFlat flat: collection.getCollection()){
            if(flat.getMinPrice() <= totalFlatPrice){
                searchResults.add(flat);
            }
            return searchResults;
        }

        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(collection,flags);

    }
    public static Parcelable.Creator<AffordableFlatController> CREATOR = new Parcelable.Creator<AffordableFlatController>(){

        @Override
        public AffordableFlatController createFromParcel (Parcel source){
            return new AffordableFlatController(source);
        }
        public AffordableFlatController[] newArray(int size) {
            return new AffordableFlatController[size];
        }
    };

}
