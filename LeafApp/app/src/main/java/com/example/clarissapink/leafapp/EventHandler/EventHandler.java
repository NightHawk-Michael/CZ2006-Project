package com.example.clarissapink.leafapp.EventHandler;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.clarissapink.leafapp.controllers.AffordableFlatController;
import com.example.clarissapink.leafapp.controllers.DebtController;
import com.example.clarissapink.leafapp.controllers.GrantController;
import com.example.clarissapink.leafapp.controllers.ViewHDBController;
import com.example.clarissapink.leafapp.models.DebtRepaymentDetails;
import com.example.clarissapink.leafapp.models.GrantInformation;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;
import com.example.clarissapink.leafapp.models.UserInputs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 21/3/2016.
 */
public class EventHandler implements Parcelable {
    private UserInputs inputs;
    private HDBCollection flatCollection;
    private GrantInformation grantInfo;
    private DebtRepaymentDetails debtRepayDetails;
    private ViewHDBController viewHDBController;
    private GrantController grantController;
    private DebtController debtController;
    private AffordableFlatController affordableFlatController;

    //Constructor
    public EventHandler(UserInputs inputs,
                        HDBCollection flatCollection,
                        GrantInformation grantInfo,
                        DebtRepaymentDetails debtRepayDetails,
                        ViewHDBController viewHDBController,
                        GrantController grantController,
                        AffordableFlatController affordableFlatController,
                        DebtController debtController
                        ){
        this.inputs = inputs;
        this.flatCollection = flatCollection;
        this.debtRepayDetails = debtRepayDetails;
        this.grantInfo = grantInfo;
        this.viewHDBController = viewHDBController;
        this.grantController = grantController;
        this.affordableFlatController = affordableFlatController;
        this.debtController = debtController;
    }

    public EventHandler(Parcel in){
        this.inputs = in.readParcelable(UserInputs.class.getClassLoader());
        this.flatCollection = in.readParcelable(HDBCollection.class.getClassLoader());
        this.debtRepayDetails = in.readParcelable(DebtRepaymentDetails.class.getClassLoader());
        this.grantInfo = in.readParcelable(GrantInformation.class.getClassLoader());
        this.viewHDBController = in.readParcelable(ViewHDBController.class.getClassLoader());
        this.grantController = in.readParcelable(GrantController.class.getClassLoader());
        this.affordableFlatController = in.readParcelable(ViewHDBController.class.getClassLoader());
        this.debtController = in.readParcelable(DebtController.class.getClassLoader());
    }
    public UserInputs getInputs(){
        return this.inputs;
    }

    public HDBCollection getHDBCollection(){
        return this.flatCollection;
    }

    public GrantInformation getGrantInformation(){
        return this.grantInfo;
    }

    public DebtRepaymentDetails getDebtRepaymentDetails(){
        return this.debtRepayDetails;
    }

    // This handle the events when user choose to search for available flats (ViewHDBFlat)
    public void updateMonthlyIncome(double monthlyIncome) {
        this.inputs.setMonthlyIncome(monthlyIncome);
    }
    public void updateAmtRepay(double amtRepay) {
        this.inputs.setAmtRepay(amtRepay);
    }
    public void updateYearToPay(int yearToPay) {
        this.inputs.setSelectedYears(yearToPay);
    }
    public void updateLoanAmt(double loanAmt) {
        this.inputs.setSelectedLoan(loanAmt);
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
    public void updatePriceRange(String priceRange) {
        this.inputs.setPriceRange(priceRange);
    }

    public void processViewHDBFlat(){
        UserInputs userInputs = this.inputs;
        this.viewHDBController.findFlats(userInputs);
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

    public String getSelectedTypeOfApplicant(){
        return inputs.getSelectedTypeOfApplicant();
    }
    public String getSelectedMonthlyIncome(){
        return inputs.getSelectedGrantMonthlyIncome();
    }

    public String getSelectedSalesLaunch(){
        return inputs.getSelectedSalesLaunch();
    }

    public double getSelectedLoan(){
        return inputs.getSelectedLoan();
    }

    public int getSelectedYears(){
        return inputs.getSelectedYears();
    }

    public ArrayList<String> findAvailFlats(){
        ArrayList<String> result = new ArrayList<>();
        List<HDBFlat> resultList = viewHDBController.findFlats(inputs);
        for(HDBFlat hdb : resultList){
            result.add(hdb.getTown() + ", " + hdb.getAddress() + "\n" + hdb.getRoomType() + " " + hdb.getMinPrice() + " - " + hdb.getMaxPrice());
        }
        return result;
    }
    public ArrayList<String> findAffordFlats(){
        ArrayList<String> result = new ArrayList<>();
        List<HDBFlat> resultList = affordableFlatController.findAffordableFlats(inputs);
        for(HDBFlat hdb : resultList){
            result.add(hdb.getTown() + ", " + hdb.getAddress() + "\n" + hdb.getRoomType() + " " + hdb.getMinPrice() + " - " + hdb.getMaxPrice());
        }
        return result;
    }

    public String findGrant(){
        return grantController.findGrant(inputs);
    }

    public double findMonthlyRepayment(){
        debtRepayDetails = debtController.calMonthlyRepayment(inputs);
        return debtRepayDetails.getMonthlyRepayment();
    }



    @Override
    public int describeContents() {
        return 0;
    }

    public void setAvailFlatInputs(String selectedRoomType, String selectedLocation, String selectedPriceRange){
        inputs.setSelectedRoomType(selectedRoomType);
        inputs.setRegion(selectedLocation);
        inputs.setPriceRange(selectedPriceRange);
    }

    public void setAffordFlatInputs(double monthlyInstallment, int repaymentPeriod){
        inputs.setMonthlyIncome(monthlyInstallment);
        inputs.setSelectedYears(repaymentPeriod);
    }

    public void setGrantInfo(String selectedTypeOfApplicant, String selectedGrantMonthlyIncome, String selectedSalesLaunch){
        inputs.setSelectedTypeOfApplicant(selectedTypeOfApplicant);
        inputs.setSelectedGrantMonthlyIncome(selectedGrantMonthlyIncome);
        inputs.setSelectedSalesLaunch(selectedSalesLaunch);
    }

    public void setDebtInputs(double selectedLoan, int selectedYears){
        inputs.setSelectedLoan(selectedLoan);
        inputs.setSelectedYears(selectedYears);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(inputs, flags);
        dest.writeParcelable(flatCollection, flags);
        dest.writeParcelable(debtRepayDetails, flags);
        dest.writeParcelable(grantInfo, flags);
        dest.writeParcelable(viewHDBController, flags);
        dest.writeParcelable(grantController, flags);
        dest.writeParcelable(affordableFlatController, flags);
        dest.writeParcelable(debtController, flags);
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
