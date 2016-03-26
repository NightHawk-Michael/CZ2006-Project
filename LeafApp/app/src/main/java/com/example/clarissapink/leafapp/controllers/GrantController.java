package com.example.clarissapink.leafapp.controllers;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.clarissapink.leafapp.models.UserInputs;

/**
 * GrantController is control class which handle all the application logic for grant function.
 * @author Michael
 * Created on 19 March 2016
 */
public class GrantController implements Parcelable{

    /**
     * Constructor
     */
    public GrantController(){}

    public GrantController (Parcel in){

    }

    public String findGrant(UserInputs inputs){
        // Second-Timer Applicants
        String selectedTypeOfApplicant = inputs.getSelectedTypeOfApplicant();
        String selectedGrantMonthlyIncome = inputs.getSelectedGrantMonthlyIncome();
        String selectedSalesLaunch = inputs.getSelectedSalesLaunch();

        if (selectedTypeOfApplicant.contentEquals("Second-Timer Applicants")) {
            return "S$15K";
        }

        // First-Timer and Second-Timer Couple Applicants, Non-Citizen Spouse Scheme, Single Singapore Citizen Scheme
        if ((selectedTypeOfApplicant.contentEquals("First-Timer and Second-Timer Couple Applicants")) || (selectedTypeOfApplicant.contentEquals("Non-Citizen Spouse Scheme")) || (selectedTypeOfApplicant.contentEquals("Single Singapore Citizen Scheme"))) {
            if ((selectedGrantMonthlyIncome.contentEquals("$750 to $1,000")) || (selectedGrantMonthlyIncome.contentEquals("$1,001 to $1,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$32.5K - S$40K";
                else
                    return "S$22.5K - S$30K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$1,501 to $2,000")) || (selectedGrantMonthlyIncome.contentEquals("$2,001 to $2,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$22.5K - S$30K";
                else
                    return "S$12.5K - S$20K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$2,501 to $3,000")) || (selectedGrantMonthlyIncome.contentEquals("$$3,001 to $3,250")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$12.5K - S$17.5K";
                else
                    return "S$2.5K - S$7.5K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$3,251 to $3,500")) || (selectedGrantMonthlyIncome.contentEquals("$3,501 to $4,000")) || (selectedGrantMonthlyIncome.contentEquals("$4,001 to $4,250")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$2.5K - S$10K";
                else
                    return "Not granted";
            else // $4,501 onwards
                return "Sorry, there are no grants available.";
        }

        // First-Timer Applicants, Joint Singles Scheme or Orphans Scheme
        if ((selectedTypeOfApplicant.contentEquals("First-Timer Applicants")) || (selectedTypeOfApplicant.contentEquals("Joint Singles Scheme or Orphans Scheme"))) {
            if ((selectedGrantMonthlyIncome.contentEquals("$750 to $1,000")) || (selectedGrantMonthlyIncome.contentEquals("$1,001 to $1,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$80K";
                else
                    return "S$60K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$1,501 to $2,000")) || (selectedGrantMonthlyIncome.contentEquals("$2,001 to $2,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$70K - S$75K";
                else
                    return "S$50K - S$55K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$2,501 to $3,000")) || (selectedGrantMonthlyIncome.contentEquals("$$3,001 to $3,250")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$60K - S$65K";
                else
                    return "S$40K - S$45K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$3,251 to $3,500")) || (selectedGrantMonthlyIncome.contentEquals("$3,501 to $4,000")) || (selectedGrantMonthlyIncome.contentEquals("$4,001 to $4,250")) || (selectedGrantMonthlyIncome.contentEquals("$4,251 to $4,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$50K - S$60K";
                else
                    return "S$30K - S$40K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$4,501 to $5,000")) || (selectedGrantMonthlyIncome.contentEquals("$5,001 to $5,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$35K - S$45K";
                else
                    return "S$15K - S$25K";
            else if ((selectedGrantMonthlyIncome.contentEquals("$5,501 to $6,000")) || (selectedGrantMonthlyIncome.contentEquals("$6,001 to $6,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$25K - S$30K";
                else
                    return "Not granted";
            else if ((selectedGrantMonthlyIncome.contentEquals("$6,501 to $7,000")) || (selectedGrantMonthlyIncome.contentEquals("$7,001 to $7,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$15K - S$20K";
                else
                    return "Not granted";
            else if ((selectedGrantMonthlyIncome.contentEquals("$7,501 to $8,000")) || (selectedGrantMonthlyIncome.contentEquals("$8,001 to $8,500")))
                if (selectedSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                    return "S$5K - S$10K";
                else
                    return "Sorry, there are no grants available";
        }
        return "";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    public static Parcelable.Creator<GrantController> CREATOR = new Parcelable.Creator<GrantController>(){

        @Override
        public GrantController createFromParcel (Parcel source){
            return new GrantController(source);
        }
        public GrantController[] newArray(int size) {
            return new GrantController[size];
        }
    };
}
