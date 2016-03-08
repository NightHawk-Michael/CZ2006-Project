package com.example.clarissapink.leafapp.models;

public class DebtRepaymentDetails {
    private double interestRate;

    public DebtRepaymentDetails(double interestRate) {
        this.interestRate = interestRate;
    }

    public DebtRepaymentDetails(int ir) {
        this.interestRate = ir;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
