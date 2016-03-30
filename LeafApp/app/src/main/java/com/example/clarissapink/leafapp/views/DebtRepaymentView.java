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

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class DebtRepaymentView extends AppCompatActivity {
    EventHandler eventHandler;


    /**
     * Creates an array adapter
     */
    ArrayAdapter<CharSequence> adapter;
    public Spinner spinnerDRYearOfLoan;
    EditText textUserLoanAmount;
    double selectedLoan;
    int selectedYears;
    Button cal;


    /**
     * This method will save the state of the application in a bundle
     * it will instantiate the spinner object for YearOfLoan within the class
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt__repayment);

        Bundle debtRpt = getIntent().getExtras();
        eventHandler = debtRpt.getParcelable("eventHandler");

        textUserLoanAmount = (EditText) findViewById(R.id.userLoanAmount);

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



    }

    public void calButton(View view) {
        String buttonCal;
        buttonCal = ((Button) view).getText().toString();
        if (buttonCal.equals("  Calculate!  ")) {
            if (textUserLoanAmount.getText().toString().matches("[0-9]+")) {
                selectedLoan = Double.parseDouble(textUserLoanAmount.getText().toString());
                if(selectedLoan < 1000 || selectedLoan > 1000000) {
                    Toast.makeText(DebtRepaymentView.this, "Please Enter a loan between 1000 to 1000000", Toast.LENGTH_LONG).show();
                }else
                {
                    selectedYears = Integer.parseInt(spinnerDRYearOfLoan.getSelectedItem().toString());
                    //update user input using eventhandler
                    eventHandler.setDebtInputs(selectedLoan,selectedYears);

                    Intent intent = new Intent(this, DebtRepaymentResultView.class);
                    intent.putExtra("eventHandler", eventHandler);
                    startActivity(intent);
                }
            }else
            {
                Toast.makeText(DebtRepaymentView.this, "Please Enter an valid loan amount", Toast.LENGTH_LONG).show();
            }

        }

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



