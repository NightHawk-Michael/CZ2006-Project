package com.example.clarissapink.leafapp.models;

/**
 * Created by Michael on 18/3/2016.
 */
public class UserInputs {
    private double monthlyIncome;
    private double amtRepay;
    private int yearToPay;
    private double loanAmt;
    private String typeOfGrant;
    private boolean selectedSale;
    private String selectedRoomType;
    private String region;

    public UserInputs(){}

    public UserInputs(double monthlyIncome, double amtRepay, int yearToPay, double loanAmt, String typeOfGrant, boolean selectedSale, String selectedRoomType, String region){
        this.monthlyIncome = monthlyIncome;
        this.amtRepay = amtRepay;
        this.yearToPay = yearToPay;
        this.loanAmt = loanAmt;
        this.typeOfGrant = typeOfGrant;
        this.selectedSale = selectedSale;
        this.selectedRoomType = selectedRoomType;
        this.region = region;
    }

    //get&set methods
}
