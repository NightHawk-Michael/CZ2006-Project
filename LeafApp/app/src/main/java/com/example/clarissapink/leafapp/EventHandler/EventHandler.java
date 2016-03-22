package com.example.clarissapink.leafapp.EventHandler;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.clarissapink.leafapp.controllers.AffordableFlatController;
import com.example.clarissapink.leafapp.controllers.ViewHDBController;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;
import com.example.clarissapink.leafapp.models.UserInputs;

import java.util.List;

/**
 * Created by Michael on 21/3/2016.
 */
public class EventHandler implements Parcelable {
    private UserInputs inputs;
    private HDBCollection flatCollection;
//    private GrantInformation grantInfo;
//    private DebtRepaymentDetails debtRepayDetails;
    private ViewHDBController viewHDBController;
//    private GrantController grantController;
//    private DebtController debtController;
    private AffordableFlatController affordableFlatController;

    //Constructor
    public EventHandler(UserInputs inputs,
                        HDBCollection flatCollection,
//                        GrantInformation grantInfo,
//                        DebtRepaymentDetails debtRepayDetails,
                        ViewHDBController viewHDBController,
//                            ,GrantController grantController,
//                        DebtController debtController,
                        AffordableFlatController affordableFlatController
                        ){
        this.inputs = inputs;
        this.flatCollection = flatCollection;
//        this.grantInfo = grantInfo;
//        this.debtRepayDetails = debtRepayDetails;
        this.viewHDBController = viewHDBController;
//        this.grantController = grantController;
//        this.debtController = debtController;
       this.affordableFlatController = affordableFlatController;
    }

    public EventHandler(Parcel in){
        this.inputs = in.readParcelable(UserInputs.class.getClassLoader());
        this.flatCollection = in.readParcelable(HDBCollection.class.getClassLoader());
        this.viewHDBController = in.readParcelable(ViewHDBController.class.getClassLoader());
        this.affordableFlatController = in.readParcelable(ViewHDBController.class.getClassLoader());
    }
    public UserInputs getInputs(){
        return this.inputs;
    }

    public HDBCollection getHDBCollection(){
        return this.flatCollection;
    }

//    public GrantInformation getGrantInformation(){
//        return this.grantInfo;
//    }
//
//    public DebtRepaymentDetails getDebtRepaymentDetails(){
//        return this.debtRepayDetails;
//    }
//
//    public AffordableFlatDetails affordableFlatDetails(){
//        return  this.affordableFlatDetails;
//    }

    // This handle the events when user choose to search for available flats (ViewHDBFlat)
    public void updateMonthlyIncome(double monthlyIncome) {
        this.inputs.setMonthlyIncome(monthlyIncome);
    }
    public void updateAmtRepay(double amtRepay) {
        this.inputs.setAmtRepay(amtRepay);
    }
    public void updateYearToPay(int yearToPay) {
        this.inputs.setYearToPay(yearToPay);
    }
    public void updateLoanAmt(double loanAmt) {
        this.inputs.setLoanAmt(loanAmt);
    }
    public void updateTypeOfGrant(String typeOfGrant) {
        this.inputs.setTypeOfGrant(typeOfGrant);
    }
    public void updateSelectedSale(boolean selectedSale) {
        this.inputs.setSelectedSale(selectedSale);
    }
    public void updateSelectedRoomType(String selectedRoomType) {
        this.inputs.setSelectedRoomType(selectedRoomType);
    }
    public void updateRegion(String region){
        this.inputs.setRegion(region);
    }
    public void updatePriceRange(String priceRange){
        this.inputs.setPriceRange(priceRange);
    }

    public void processViewHDBFlat(){
        UserInputs userInputs = this.inputs;
        this.viewHDBController.findFlats(userInputs);
    }

    public List<HDBFlat> findAvailFlats(){
        return viewHDBController.findFlats(inputs);
    }



    public String getSelectedRoomType(){
        return inputs.getSelectedRoomType();
    }
    public String getSelectedLocation(){
        return inputs.getRegion();
    }
    public String getSelectedPriceRange(){
        return inputs.getPriceRange();
    }

    public List<HDBFlat> findAffordFlats(){
        return affordableFlatController.findAffordableFlats(inputs);
    }

    public void setAvailFlatInputs(String selectedRoomType, String selectedLocation, String selectedPriceRange){
        inputs.setSelectedRoomType(selectedRoomType);
        inputs.setRegion(selectedLocation);
        inputs.setPriceRange(selectedPriceRange);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(inputs, flags);
        dest.writeParcelable(flatCollection, flags);
        dest.writeParcelable(viewHDBController, flags);
        dest.writeParcelable(affordableFlatController, flags);
    }


    public void setAffordFlatInputs(double monthlyInstallment, int repaymentPeriod){
        inputs.setMonthlyIncome(monthlyInstallment);
        inputs.setYearToPay(repaymentPeriod);
    }

    public static Parcelable.Creator<EventHandler> CREATOR = new Parcelable.Creator<EventHandler>(){

        @Override
        public EventHandler createFromParcel (Parcel source){
            return new EventHandler(source);
        }
        public EventHandler[] newArray(int size) {
            return new EventHandler[size];
        }
    };
}
