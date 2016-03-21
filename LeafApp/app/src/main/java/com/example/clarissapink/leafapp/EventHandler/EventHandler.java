package com.example.clarissapink.leafapp.EventHandler;

import com.example.clarissapink.leafapp.controllers.AffordableFlatController;
import com.example.clarissapink.leafapp.controllers.DebtController;
import com.example.clarissapink.leafapp.controllers.GrantController;
import com.example.clarissapink.leafapp.controllers.ViewHDBController;
import com.example.clarissapink.leafapp.models.AffordableFlatDetails;
import com.example.clarissapink.leafapp.models.DebtRepaymentDetails;
import com.example.clarissapink.leafapp.models.GrantInformation;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.UserInputs;

/**
 * Created by Michael on 21/3/2016.
 */
public class EventHandler {
    private UserInputs inputs;
    private HDBCollection flatCollection;
    private GrantInformation grantInfo;
    private DebtRepaymentDetails debtRepayDetails;
    private AffordableFlatDetails affordableFlatDetails;
    private ViewHDBController viewHDBController;
    private GrantController grantController;
    private DebtController debtController;
    private AffordableFlatController affordableFlatController;

    //Constructor
    public EventHandler(UserInputs inputs,
                        HDBCollection flatCollection,
                        GrantInformation grantInfo,
                        DebtRepaymentDetails debtRepayDetails,
                        AffordableFlatDetails affordableFlatDetails,
                        ViewHDBController viewHDBController,
                        GrantController grantController,
                        DebtController debtController,
                        AffordableFlatController affordableFlatController
                        ){
        this.inputs = inputs;
        this.flatCollection = flatCollection;
        this.grantInfo = grantInfo;
        this.debtRepayDetails = debtRepayDetails;
        this.affordableFlatDetails = affordableFlatDetails;
        this.viewHDBController = viewHDBController;
        this.grantController = grantController;
        this.debtController = debtController;
        this.affordableFlatController = affordableFlatController;
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

    public AffordableFlatDetails affordableFlatDetails(){
        return  this.affordableFlatDetails;
    }

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
    public void updateSelectedRoomType(String[] selectedRoomType) {
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

}
