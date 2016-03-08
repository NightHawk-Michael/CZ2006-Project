package com.example.clarissapink.leafapp.models;

public class AffordableFlatDetails {

    private int repaymentPeriod;
    private double principalValue;

    public AffordableFlatDetails(int repaymentPeriod, double principalValue) {
        this.repaymentPeriod = repaymentPeriod;
        this.principalValue = principalValue;
    }

    public double getPrincipalValue() {
        return principalValue;
    }

    public void setPrincipalValue(double principalValue) {
        this.principalValue = principalValue;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }
}
