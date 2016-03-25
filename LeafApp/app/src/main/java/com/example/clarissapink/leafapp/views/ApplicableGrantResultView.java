package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class ApplicableGrantResultView extends AppCompatActivity {

    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicable_grant_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Displays the loan amount user entered in ApplicableGrantView screen
         */
        TextView typeOfApplicantView = (TextView) findViewById(R.id.displayApplicantType);
        typeOfApplicantView.setText(getIntent().getExtras().getString("typeOfApplicant"));

        TextView averageMonthlyHouseholdIncomeView = (TextView) findViewById(R.id.displayIncome);
        averageMonthlyHouseholdIncomeView.setText(getIntent().getExtras().getString("averageMonthlyHouseholdIncome"));

        TextView salesLaunchView = (TextView) findViewById(R.id.displayPeriod);
        salesLaunchView.setText(getIntent().getExtras().getString("salesLaunch"));

        TextView grantedAmtView = (TextView) findViewById(R.id.displayGrantResult);
        grantedAmtView.setText(getIntent().getExtras().getString("grantedAmt"));

    }

    /**
     * This method navigates to FlatAvailableView
     * @param view stores what the user interact with the button
     */
    public void btn1(View view) {
        Intent intent = new Intent(this, FlatAvailableView.class);
        startActivity(intent);
    }

    /**
     * This method navigates to AffordableFlatView
     * @param view stores what the user interact with the button
     */
    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlatView.class);
        startActivity(intent);
    }

    /**
     * This method navigates to ApplicableGrantView
     * @param view stores what the user interact with the button
     */
    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrantView.class);
        startActivity(intent);
    }

    /**
     * This method navigates to DebtRepaymentView
     * @param view stores what the user interact with the button
     */
    public void btn4(View view) {
        Intent intent = new Intent(this, DebtRepaymentView.class);
        startActivity(intent);
    }

}
