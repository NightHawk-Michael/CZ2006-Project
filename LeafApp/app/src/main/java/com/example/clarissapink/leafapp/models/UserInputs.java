package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Michael on 18/3/2016.
 */
public class UserInputs implements Parcelable{
    private double monthlyIncome;
    private double amtRepay;
    private int selectedYears;
    private double selectedLoan;
    private String typeOfGrant;
    private boolean selectedSale;
    private String selectedRoomType = "";
    private String region = "";
    private String priceRange = "";
    private String selectedTypeOfApplicant;
    private String selectedGrantMonthlyIncome;
    private String selectedSalesLaunch;


    public UserInputs(){}

    public UserInputs(String region, String selectedRoomType, String priceRange){
        this.region = region;
        this.selectedRoomType = selectedRoomType;
        this.priceRange = priceRange;
    }
    public UserInputs(double monthlyIncome, double amtRepay, int selectedYears, double selectedLoan, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region,String priceRange){
        this.monthlyIncome = monthlyIncome;
        this.amtRepay = amtRepay;
        this.selectedYears = selectedYears;
        this.selectedLoan = selectedLoan;
        this.typeOfGrant = typeOfGrant;
        this.selectedSale = selectedSale;
        this.selectedRoomType = selectedRoomType;
        this.region = region;
        this.priceRange = priceRange;
    }

    public UserInputs (Parcel in){
        this.monthlyIncome = in.readDouble();
        this.amtRepay = in.readDouble();
        this.selectedYears  = in.readInt();
        this.selectedLoan = in.readDouble();
        this.typeOfGrant = in.readString();
        this.selectedSale = in.readByte() != 0;
        this.selectedRoomType = in.readString();
        this.region = in.readString();
        this.priceRange = in.readString();
        this.selectedTypeOfApplicant = in.readString();
        this.selectedGrantMonthlyIncome = in.readString();
        this.selectedSalesLaunch = in.readString();
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

    public int getSelectedYears() {
        return selectedYears;
    }

    public void setSelectedYears(int selectedYears) {
        this.selectedYears = selectedYears;
    }

    public double getSelectedLoan() {
        return selectedLoan;
    }

    public void setSelectedLoan(double selectedLoan) {
        this.selectedLoan = selectedLoan;
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

    public String getSelectedRoomType() {
        return selectedRoomType;
    }

    public void setSelectedRoomType(String selectedRoomType) {
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

    public String getSelectedTypeOfApplicant() {
        return selectedTypeOfApplicant;
    }

    public void setSelectedTypeOfApplicant(String selectedTypeOfApplicant) {
        this.selectedTypeOfApplicant = selectedTypeOfApplicant;
    }

    public String getSelectedGrantMonthlyIncome() {
        return selectedGrantMonthlyIncome;
    }

    public void setSelectedGrantMonthlyIncome(String selectedGrantMonthlyIncome) {
        this.selectedGrantMonthlyIncome = selectedGrantMonthlyIncome;
    }

    public String getSelectedSalesLaunch() {
        return selectedSalesLaunch;
    }

    public void setSelectedSalesLaunch(String selectedSalesLaunch) {
        this.selectedSalesLaunch = selectedSalesLaunch;
    }

    @Override
    public int describeContents() {
        return 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(monthlyIncome);
        dest.writeDouble(amtRepay);
        dest.writeInt(selectedYears);
        dest.writeDouble(selectedLoan);
        dest.writeString(typeOfGrant);
        dest.writeByte((byte) (selectedSale ? 1 : 0));
        dest.writeString(selectedRoomType);
        dest.writeString(region);
        dest.writeString(priceRange);
        dest.writeString(selectedTypeOfApplicant);
        dest.writeString(selectedGrantMonthlyIncome);
        dest.writeString(selectedSalesLaunch);
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
