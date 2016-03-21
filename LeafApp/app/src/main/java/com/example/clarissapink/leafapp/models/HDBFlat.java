package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class HDBFlat implements Parcelable {

    private int id;
    private int year;
    private String town;
    private String roomType;
    private String minPrice;
    private String maxPrice;
    private String minPriceLess;
    private String maxPriceLess;

    public HDBFlat(){
    }

    public HDBFlat(int id, int year, String town, String roomType, String minPrice, String maxPrice, String minPriceLess, String maxPriceLess) {
        this.id = id;
        this.year = year;
        this.town = town;
        this.roomType = roomType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minPriceLess = minPriceLess;
        this.maxPriceLess = maxPriceLess;
    }

    /**
     * Contructor for when using parcelable to pass object between activities
     * @param in
     */
    public HDBFlat(Parcel in){
        this.id = in.readInt();
        this.year = in.readInt();
        this.town = in.readString();
        this.roomType = in.readString();
        this.minPrice = in.readString();
        this.maxPrice = in.readString();
        this.minPriceLess = in.readString();
        this. maxPriceLess = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPriceLess() {
        return minPriceLess;
    }

    public void setMinPriceLess(String minPriceLess) {
        this.minPriceLess = minPriceLess;
    }

    public String getMaxPriceLess() {
        return maxPriceLess;
    }

    public void setMaxPriceLess(String maxPriceLess) {
        this.maxPriceLess = maxPriceLess;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(year);
        dest.writeString(town);
        dest.writeString(roomType);
        dest.writeString(minPrice);
        dest.writeString(maxPrice);
        dest.writeString(minPriceLess);
        dest.writeString(maxPriceLess);
    }

    public static Parcelable.Creator<HDBFlat> CREATOR = new Parcelable.Creator<HDBFlat>(){

        @Override
        public HDBFlat createFromParcel (Parcel source){
            return new HDBFlat(source);
        }
        public HDBFlat[] newArray(int size) {
            return new HDBFlat[size];
        }
    };
}