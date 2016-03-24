package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DebtRepaymentDetails implements Parcelable {
    private double monthlyRepayment;

    public DebtRepaymentDetails(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public DebtRepaymentDetails(Parcel in){
        this.monthlyRepayment = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(monthlyRepayment);

    }
    public static Parcelable.Creator<DebtRepaymentDetails> CREATOR = new Parcelable.Creator<DebtRepaymentDetails>(){

        @Override
        public DebtRepaymentDetails createFromParcel (Parcel source){
            return new DebtRepaymentDetails(source);
        }
        public DebtRepaymentDetails[] newArray(int size) {
            return new DebtRepaymentDetails[size];
        }
    };
}
