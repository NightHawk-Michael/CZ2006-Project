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
import android.widget.Toast;

import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class DebtRepayment extends AppCompatActivity {
    /**
     * Initialize a Spinner Object
     */
    Spinner spinner;
    /**
     * Creates an array adapter
     */
    ArrayAdapter<CharSequence> adapter;

    /**
     * This method will save the state of the application in a bundle
     * it will instantiate the spinner object for YearOfLoan within the class
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt__repayment);

        /**
         *  Retrieve Loan Amount entered by user
         *  Loan Amount entered by user will be pass to the ViewDebtRepayment class upon executing cal
         *  @param userLoanAmount  Loan Amount User Entered
         *  @param intent  Pass data from DebtRepayment to ViewDebtRepayment
         *  @param putExtra bundle EditText with intent when calling the next activity
         */
        final EditText userLoanAmount = (EditText) findViewById(R.id.userLoanAmount);
        Button cal = (Button) findViewById(R.id.calButton);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DebtRepayment.this, ViewDebtRepayment.class);
                intent.putExtra("loanAmount", userLoanAmount.getText().toString());
                startActivity(intent);
            }
        });

        spinner = (Spinner) findViewById(R.id.spinnerDRYearOfLoan);
        adapter = ArrayAdapter.createFromResource(this, R.array.yearOfLoan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /**
     * This method navigates to FlatAvailable
     * @param view stores what the user interact with the button
     */
    public void btn1(View view) {
        Intent intent = new Intent(this, FlatAvailable.class);
        startActivity(intent);
    }

    /**
     * This method navigates to AffordableFlat
     * @param view stores what the user interact with the button
     */
    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlat.class);
        startActivity(intent);
    }

    /**
     * This method navigates to ApplicableGrant
     * @param view stores what the user interact with the button
     */
    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrant.class);
        startActivity(intent);
    }

    /**
     * This method navigates to DebtRepayment
     * @param view stores what the user interact with the button
     */
    public void btn4(View view) {
        Intent intent = new Intent(this, DebtRepayment.class);
        startActivity(intent);
    }

}



