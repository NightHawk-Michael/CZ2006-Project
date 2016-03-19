package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class ApplicableGrant extends AppCompatActivity {
    /**
     * Initialize a Spinner Object
     */
    Spinner spinner;
    /**
     * Creates an array adapter to add data in to the Spinner
     */
    ArrayAdapter<CharSequence> adapter;

    /**
     * This method will save the state of the application in a bundle
     * it will instantiate the spinner object for TypeOfApplicant within the class
     * it will instantiate the spinner object for AverageMonthlyHouseholdIncome within the class
     * it will instantiate the spinner object for SalesLaunch within the class
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicable_grant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinnerAGTypeOfApplicant);
        adapter = ArrayAdapter.createFromResource(this, R.array.typeOfApplicant, android.R.layout.simple_spinner_item);
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

        spinner = (Spinner) findViewById(R.id.spinnerAGAverageMonthlyHouseholdIncome);
        adapter = ArrayAdapter.createFromResource(this, R.array.averageMonthlyHouseholdIncome, android.R.layout.simple_spinner_item);
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

        spinner = (Spinner) findViewById(R.id.spinnerAGSalesLaunch);
        adapter = ArrayAdapter.createFromResource(this, R.array.salesLaunch, android.R.layout.simple_spinner_item);
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

    /**
     * This method navigates the searchButton in AffordableFlat
     * @param view stores what the user interact with the button
     */
    public void searchButton(View view) {
        String buttonSearch;
        buttonSearch = ((Button) view).getText().toString();
        if (buttonSearch.equals("Search")) {
            Intent intent = new Intent(this, ApplicableGrantResult.class);
            startActivity(intent);
        }

    }

}
