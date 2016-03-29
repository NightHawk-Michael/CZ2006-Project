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

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class ApplicableGrantView extends AppCompatActivity {
    /**
     * Initialize a Spinner Object
     */
    Spinner spinner;
    /**
     * Creates an array adapter to add data in to the Spinner
     */
    ArrayAdapter<CharSequence> adapter;

    Spinner spinnerAGTypeOfApplicant;
    Spinner spinnerAGAverageMonthlyHouseholdIncome;
    Spinner spinnerAGSalesLaunch;
    public String granted;

    String selectedTypeOfApplicant;
    String selectedGrantMonthlyIncome;
    String selectedSalesLaunch;

    EventHandler eventHandler;

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

        Bundle grant = getIntent().getExtras();
        eventHandler = grant.getParcelable("eventHandler");

        spinnerAGTypeOfApplicant = (Spinner) findViewById(R.id.spinnerAGTypeOfApplicant);
        adapter = ArrayAdapter.createFromResource(this, R.array.typeOfApplicant, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAGTypeOfApplicant.setAdapter(adapter);
        spinnerAGTypeOfApplicant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerAGAverageMonthlyHouseholdIncome = (Spinner) findViewById(R.id.spinnerAGAverageMonthlyHouseholdIncome);
        adapter = ArrayAdapter.createFromResource(this, R.array.averageMonthlyHouseholdIncome, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAGAverageMonthlyHouseholdIncome.setAdapter(adapter);
        spinnerAGAverageMonthlyHouseholdIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerAGSalesLaunch = (Spinner) findViewById(R.id.spinnerAGSalesLaunch);
        adapter = ArrayAdapter.createFromResource(this, R.array.salesLaunch, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAGSalesLaunch.setAdapter(adapter);
        spinnerAGSalesLaunch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void getButton(View view) {
        String buttonGet;
        buttonGet = ((Button) view).getText().toString();
        if (buttonGet.equals("  Search  ")) {
            selectedTypeOfApplicant = spinnerAGTypeOfApplicant.getSelectedItem().toString();
            selectedGrantMonthlyIncome = spinnerAGAverageMonthlyHouseholdIncome.getSelectedItem().toString();
            selectedSalesLaunch = spinnerAGSalesLaunch.getSelectedItem().toString();

            //update user input using eventhandler
            eventHandler.setGrantInfo(selectedTypeOfApplicant, selectedGrantMonthlyIncome, selectedSalesLaunch);

            Intent intent = new Intent(this, ApplicableGrantResultView.class);
            intent.putExtra("eventHandler", eventHandler);
            startActivity(intent);
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

    /**
     * This method navigates the searchButton in AffordableFlatView
     * @param view stores what the user interact with the button
     */
    public void searchButton(View view) {
        String buttonSearch;
        buttonSearch = ((Button) view).getText().toString();
        if (buttonSearch.equals("Search")) {
            Intent intent = new Intent(this, ApplicableGrantResultView.class);
            startActivity(intent);
        }

    }

}
