package com.example.clarissapink.leafapp.EventHandler;

import com.example.clarissapink.leafapp.models.AffordableFlatDetails;
import com.example.clarissapink.leafapp.models.DebtRepaymentDetails;
import com.example.clarissapink.leafapp.models.GrantInformation;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.HDBFlat;
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

    //Constructor
    public EventHandler(UserInputs inputs, HDBCollection flatCollection, GrantInformation grantInfo, DebtRepaymentDetails debtRepayDetails, AffordableFlatDetails affordableFlatDetails){
        this.inputs = inputs;
        this.flatCollection = flatCollection;
        this.grantInfo = grantInfo;
        this.debtRepayDetails = debtRepayDetails;
        this.affordableFlatDetails = affordableFlatDetails;
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


}
