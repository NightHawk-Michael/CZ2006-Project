package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class DebtRepaymentResultView extends AppCompatActivity {
    EventHandler eventHandler;
    double monthlyRepayment;
    double interestRate = 0.026;

    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__debt__repayment);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Bundle debtResult = getIntent().getExtras();
        eventHandler = debtResult.getParcelable("eventHandler");


        TextView yearOfLoanView = (TextView) findViewById(R.id.displayYearOfLoan);
        TextView loanAmountView = (TextView) findViewById(R.id.displayLoanAmount);
        TextView loanRepaymentPerMView = (TextView) findViewById(R.id.displayLoanRepaymentPerM);

        monthlyRepayment = eventHandler.findMonthlyRepayment();
        String debtRepaymentResult = String.format("%.2f",monthlyRepayment);


        yearOfLoanView.setText(Double.toString(eventHandler.getSelectedYears()));
        loanAmountView.setText(String.valueOf(eventHandler.getSelectedLoan()));
        loanRepaymentPerMView.setText(debtRepaymentResult);
    }

    /**
     * This method navigates to FlatAvailableView
     * @param view stores what the user interact with the button
     */
    public void btn1(View view) {
        Intent intent = new Intent(this, FlatAvailableView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to AffordableFlatView
     * @param view stores what the user interact with the button
     */
    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlatView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to ApplicableGrantView
     * @param view stores what the user interact with the button
     */
    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrantView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to DebtRepaymentView
     * @param view stores what the user interact with the button
     */
    public void btn4(View view) {
        Intent intent = new Intent(this, DebtRepaymentView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

}
