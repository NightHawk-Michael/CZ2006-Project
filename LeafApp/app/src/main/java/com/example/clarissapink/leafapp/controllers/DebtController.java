package com.example.clarissapink.leafapp.controllers;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.clarissapink.leafapp.models.DebtRepaymentDetails;
import com.example.clarissapink.leafapp.models.UserInputs;


/**
 * GrantController is control class which handle all the application logic for grant function.
 * @author Michael
 * Created on 19 March 2016.
 */
public class DebtController implements Parcelable {

    /**
     * Constructor instantiate the DebtController.
     */
    public DebtController(){}

    public DebtController(Parcel in){}


    /**
     * Calculate the debt that user have to bear according to the user inputs and the choice of flat.
     * @return debt debt that is calculated from the user input
     */
    public DebtRepaymentDetails calMonthlyRepayment(UserInputs inputs){
        double interestRate =0.026/12;
        double loan = inputs.getSelectedLoan();
        int years = inputs.getSelectedYears();

        //Calculation
        double monthlyRepayment = (loan * interestRate)/(1-(1/Math.pow((1 + interestRate),12*years)));
        DebtRepaymentDetails debt = new DebtRepaymentDetails(monthlyRepayment);
        return debt;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static Parcelable.Creator<DebtController> CREATOR = new Parcelable.Creator<DebtController>(){

        @Override
        public DebtController createFromParcel (Parcel source){
            return new DebtController(source);
        }
        public DebtController[] newArray(int size) {
            return new DebtController[size];
        }
    };
}
