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

        // get button
        Button search = (Button) findViewById(R.id.searchButton);
        // button listener
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pass data over to another activity
                Intent intent = new Intent(ApplicableGrantView.this, ApplicableGrantResultView.class);

                // retrieve spinner selections
                String userTypeOfApplicant = spinnerAGTypeOfApplicant.getSelectedItem().toString();
                intent.putExtra("typeOfApplicant", spinnerAGTypeOfApplicant.getSelectedItem().toString());

                String userAverageMonthlyHouseholdIncome = spinnerAGAverageMonthlyHouseholdIncome.getSelectedItem().toString();
                intent.putExtra("averageMonthlyHouseholdIncome", spinnerAGAverageMonthlyHouseholdIncome.getSelectedItem().toString());

                String userSalesLaunch = spinnerAGSalesLaunch.getSelectedItem().toString();
                intent.putExtra("salesLaunch", spinnerAGSalesLaunch.getSelectedItem().toString());

                // Second-Timer Applicants
                if (userTypeOfApplicant.contentEquals("Second-Timer Applicants")) {
                    granted = "S$15K";
                }

                // First-Timer and Second-Timer Couple Applicants, Non-Citizen Spouse Scheme, Single Singapore Citizen Scheme
                if ((userTypeOfApplicant.contentEquals("First-Timer and Second-Timer Couple Applicants")) || (userTypeOfApplicant.contentEquals("Non-Citizen Spouse Scheme")) || (userTypeOfApplicant.contentEquals("Single Singapore Citizen Scheme"))) {
                    if ((userAverageMonthlyHouseholdIncome.contentEquals("$750 to $1,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$1,001 to $1,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$32.5K - S$40K";
                        else
                            granted = "S$22.5K - S$30K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$1,501 to $2,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$2,001 to $2,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$22.5K - S$30K";
                        else
                            granted = "S$12.5K - S$20K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$2,501 to $3,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$$3,001 to $3,250")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$12.5K - S$17.5K";
                        else
                            granted = "S$2.5K - S$7.5K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$3,251 to $3,500")) || (userAverageMonthlyHouseholdIncome.contentEquals("$3,501 to $4,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$4,001 to $4,250")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$2.5K - S$10K";
                        else
                            granted = "Not granted";
                    else // $4,501 onwards
                        granted = "Not granted";
                }

                // First-Timer Applicants, Joint Singles Scheme or Orphans Scheme
                if ((userTypeOfApplicant.contentEquals("First-Timer Applicants")) || (userTypeOfApplicant.contentEquals("Joint Singles Scheme or Orphans Scheme"))) {
                    if ((userAverageMonthlyHouseholdIncome.contentEquals("$750 to $1,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$1,001 to $1,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$80K";
                        else
                            granted = "S$60K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$1,501 to $2,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$2,001 to $2,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$70K - S$75K";
                        else
                            granted = "S$50K - S$55K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$2,501 to $3,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$$3,001 to $3,250")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$60K - S$65K";
                        else
                            granted = "S$40K - S$45K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$3,251 to $3,500")) || (userAverageMonthlyHouseholdIncome.contentEquals("$3,501 to $4,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$4,001 to $4,250")) || (userAverageMonthlyHouseholdIncome.contentEquals("$4,251 to $4,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$50K - S$60K";
                        else
                            granted = "S$30K - S$40K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$4,501 to $5,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$5,001 to $5,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$35K - S$45K";
                        else
                            granted = "S$15K - S$25K";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$5,501 to $6,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$6,001 to $6,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$25K - S$30K";
                        else
                            granted = "Not granted";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$6,501 to $7,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$7,001 to $7,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$15K - S$20K";
                        else
                            granted = "Not granted";
                    else if ((userAverageMonthlyHouseholdIncome.contentEquals("$7,501 to $8,000")) || (userAverageMonthlyHouseholdIncome.contentEquals("$8,001 to $8,500")))
                        if (userSalesLaunch.contentEquals("From November 2015 Sales Launch"))
                            granted = "S$5K - S$10K";
                        else
                            granted = "Not granted";
                }

                intent.putExtra("grantedAmt", granted.toString());

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
