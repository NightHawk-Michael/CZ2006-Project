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
public class DebtRepaymentResultView extends AppCompatActivity {
    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__debt__repayment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Displays the loan amount user entered in debt_repayment screen
         */
        TextView yearOfLoanView = (TextView) findViewById(R.id.displayYearOfLoan);
        yearOfLoanView.setText(getIntent().getExtras().getString("yearOfLoan"));

        TextView loanAmountView = (TextView) findViewById(R.id.displayLoanAmount);
        loanAmountView.setText(getIntent().getExtras().getString("loanAmount"));

        TextView loanRepaymentPerMView = (TextView) findViewById(R.id.displayLoanRepaymentPerM);
        loanRepaymentPerMView.setText(getIntent().getExtras().getString("answer"));
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
