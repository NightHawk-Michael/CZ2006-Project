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


    /**
     * Constructor which construct a HDBList
     */
    public ViewHDBController(HDBCollection collection){
        this.collection = collection;
    }

    public ViewHDBController(Parcel in){
        this.collection = in.readParcelable(HDBCollection.class.getClassLoader());
    }

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
        return searchResults;
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
