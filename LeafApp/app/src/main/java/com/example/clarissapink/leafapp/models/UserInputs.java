package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Michael on 18/3/2016.
 */
public class UserInputs implements Parcelable{
    private double monthlyIncome;
    private double amtRepay;
    private int yearToPay;
    private double loanAmt;
    private String typeOfGrant;
    private boolean selectedSale;
    private String[] selectedRoomType;
    private String region;
    private String priceRange;

    public UserInputs(){}

    public UserInputs(String region, String[] selectedRoomType, String priceRange){
        this.region = region;
        this.selectedRoomType = selectedRoomType;
        this.priceRange = priceRange;
    }
    public UserInputs(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String[] selectedRoomType, String region,String priceRange){
        this.monthlyIncome = monthlyIncome;
        this.amtRepay = amtRepay;
        this.yearToPay = yearToPay;
        this.loanAmt = loanAmt;
        this.typeOfGrant = typeOfGrant;
        this.selectedSale = selectedSale;
        this.selectedRoomType = selectedRoomType;
        this.region = region;
        this.priceRange = priceRange;
    }

    public UserInputs (Parcel in){
        this.monthlyIncome = in.readDouble();
        this.amtRepay = in.readDouble();
        this.yearToPay  = in.readInt();
        this.loanAmt = in.readDouble();
        this.typeOfGrant = in.readString();
        this.selectedSale = in.readByte() != 0;
        this.selectedRoomType = in.readStringArray();
        this.region = in.readString();
        this.priceRange = in.readString();
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getAmtRepay() {
        return amtRepay;
    }

    public void setAmtRepay(double amtRepay) {
        this.amtRepay = amtRepay;
    }

    public int getYearToPay() {
        return yearToPay;
    }

    public void setYearToPay(int yearToPay) {
        this.yearToPay = yearToPay;
    }

    public double getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(double loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getTypeOfGrant() {
        return typeOfGrant;
    }

    public void setTypeOfGrant(String typeOfGrant) {
        this.typeOfGrant = typeOfGrant;
    }

    public boolean isSelectedSale() {
        return selectedSale;
    }

    public void setSelectedSale(boolean selectedSale) {
        this.selectedSale = selectedSale;
    }

    public String[] getSelectedRoomType() {
        return selectedRoomType;
    }

    public void setSelectedRoomType(String[] selectedRoomType) {
        this.selectedRoomType = selectedRoomType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    @Override
    public int describeContents() {
        return 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(monthlyIncome);
        dest.writeDouble(amtRepay);
        dest.writeInt(yearToPay);
        dest.writeDouble(loanAmt);
        dest.writeString(typeOfGrant);
        dest.writeByte((byte) (selectedSale ? 1 : 0));
        dest.writeStringArray(selectedRoomType);
        dest.writeString(region);
        dest.writeString(priceRange);
    }

    //method to recreate a Userinput from a Parcel
    public static Creator<UserInputs> CREATOR = new Creator<UserInputs>(){
        @Override
        public UserInputs createFromParcel(Parcel source){
            return new UserInputs(source);
        }
        @Override
        public UserInputs[] newArray(int size) {
            return new UserInputs[size];
        }
    };
}
