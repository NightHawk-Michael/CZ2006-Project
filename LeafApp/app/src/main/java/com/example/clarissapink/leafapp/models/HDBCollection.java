package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class HDBCollection implements Parcelable {

    private List<HDBFlat> collection;

    public HDBCollection() {
    }

    public HDBCollection(List<HDBFlat> collection) {
        this.collection = collection;
    }

    public HDBCollection(Parcel in){
//        collection = new ArrayList<HDBFlat>();
        this.collection = in.readArrayList(HDBFlat.class.getClassLoader());
    }

    public List<HDBFlat> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<HDBFlat> collection) {
        this.collection = collection;
    }

    // This method is required for parcelable
    // For not return 0
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(collection);

    }

    public static Parcelable.Creator<HDBCollection> CREATOR = new Parcelable.Creator<HDBCollection>(){

        @Override
        public HDBCollection createFromParcel (Parcel source){
            return new HDBCollection(source);
        }
        public HDBCollection[] newArray(int size) {
            return new HDBCollection[size];
        }
    };
}