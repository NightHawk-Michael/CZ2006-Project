package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class DebtRepaymentView extends AppCompatActivity {
    /**
     * Initialize a Spinner Object
     */
    Spinner spinner;
    /**
     * Creates an array adapter
     */
    ArrayAdapter<CharSequence> adapter;
    final double interestRate = 2.6;
    public Spinner spinnerDRYearOfLoan;

    /**
     * This method will save the state of the application in a bundle
     * it will instantiate the spinner object for YearOfLoan within the class
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt__repayment);

        spinnerDRYearOfLoan = (Spinner) findViewById(R.id.spinnerDRYearOfLoan);
        adapter = ArrayAdapter.createFromResource(this, R.array.yearOfLoan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDRYearOfLoan.setAdapter(adapter);
        spinnerDRYearOfLoan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView myText = (TextView) view;
                Toast.makeText(getBaseContext(), myText.getText() + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         *  Retrieve Loan Amount entered by user
         *  Loan Amount entered by user will be pass to the ViewDebtRepayment class upon executing cal
         *  @param userLoanAmount  Loan Amount User Entered
         *  @param intent  Pass data from DebtRepayment to ViewDebtRepayment
         *  @param putExtra bundle EditText with intent when calling the next activity
         */


        // get button
        Button cal = (Button) findViewById(R.id.calButton);
        // button listener
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double interestRate = 0.026;
                double loanAmt, noOfYears, mthlyDR, mthlyAmt, mthlyinterestRate, powerYear;
                String answer;

                // pass data over to another activity
                Intent intent = new Intent(DebtRepaymentView.this, DebtRepaymentResultView.class);

                // retrieve, pass user input loan amount
                EditText userLoanAmount = (EditText) findViewById(R.id.userLoanAmount);
                intent.putExtra("loanAmount", userLoanAmount.getText().toString());

                // retrieve, pass year of loan
                String YearOfLoan = spinnerDRYearOfLoan.getSelectedItem().toString();
                intent.putExtra("yearOfLoan", spinnerDRYearOfLoan.getSelectedItem().toString());

                loanAmt = Double.parseDouble(userLoanAmount.getText().toString());
                noOfYears = Double.parseDouble(spinnerDRYearOfLoan.getSelectedItem().toString());

                mthlyAmt = loanAmt * (interestRate / 12);
                powerYear = (1 / (Math.pow((1 + (interestRate / 12)), ((noOfYears) * 12))));
                mthlyinterestRate = 1 - powerYear;
                mthlyDR = mthlyAmt / mthlyinterestRate;

                answer = String.format("%.2f", mthlyDR);
                intent.putExtra("answer", answer.toString());

                // start ViewDebtRepayment activity
                startActivity(intent);
            }
        });

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



