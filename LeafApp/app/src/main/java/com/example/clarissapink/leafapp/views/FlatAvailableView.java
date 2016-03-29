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
 * This class will manage the buttons in FlatAvailable screen
 * @author Emily
 */
public class FlatAvailableView extends AppCompatActivity{

    ArrayAdapter<CharSequence> roomTypeAdapter;
    ArrayAdapter<CharSequence> locationAdapter;
    ArrayAdapter<CharSequence> priceRangeAdapter;

    Spinner roomTypeSpinner;
    Spinner locationSpinner;
    Spinner priceRangeSpinner;
    Button searchButton;

    /**
     * Other attributes
     */
    EventHandler eventHandler;
    String selectedRoomType;
    String selectedPriceRange;
    String selectedLocation;


    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_available);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle flatavail = getIntent().getExtras();
        eventHandler = flatavail.getParcelable("eventHandler");

        /**
         * Initializing checkboxes and buttons
         */
        roomTypeSpinner = (Spinner)findViewById(R.id.spinnerFAroomType);
        locationSpinner = (Spinner)findViewById(R.id.spinnerFALocation);
        priceRangeSpinner = (Spinner)findViewById(R.id.spinnerFApriceRange);

        searchButton = (Button)findViewById(R.id.searchButtonFA);

        roomTypeAdapter = ArrayAdapter.createFromResource(this, R.array.roomSelectedSpinner, android.R.layout.simple_spinner_item);
        roomTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomTypeSpinner.setAdapter(roomTypeAdapter);
        roomTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        locationAdapter = ArrayAdapter.createFromResource(this, R.array.locSpinnerItems, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        priceRangeAdapter = ArrayAdapter.createFromResource(this, R.array.priceRangeSpinner, android.R.layout.simple_spinner_item);
        priceRangeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceRangeSpinner.setAdapter(priceRangeAdapter);
        priceRangeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        // edit user inputs before passing
        // n parsel to controller

    }

    // METHODS TO RECORD CHECKBOXES AND SPINNER CHOSEN AS USER INPUTS

    /**
     * This method navigates the searchButton to FlatAvailableResults
     * @param view stores what the user interact with the button
     */

    public void searchButton(View view) {
        String buttonSearch;
        buttonSearch = ((Button) view).getText().toString();
        if (buttonSearch.equals("Search")) {
            selectedRoomType = roomTypeSpinner.getSelectedItem().toString();
            selectedLocation = locationSpinner.getSelectedItem().toString();
            selectedPriceRange  = priceRangeSpinner.getSelectedItem().toString();

            //update user input using eventhandler
            eventHandler.setAvailFlatInputs(selectedRoomType,selectedLocation,selectedPriceRange);

            Intent intent = new Intent(this, FlatAvailableResultView.class);
            intent.putExtra("eventHandler", eventHandler);
            startActivity(intent);
        }

    }

    /**
     * This method navigates to FlatAvailable
     * @param view stores what the user interact with the button
     */
    public void btn1(View view) {
        Intent intent = new Intent(this, FlatAvailableView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to AffordableFlat
     * @param view stores what the user interact with the button
     */
    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlatView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to ApplicableGrant
     * @param view stores what the user interact with the button
     */
    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrantView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to DebtRepayment
     * @param view stores what the user interact with the button
     */
    public void btn4(View view) {
        Intent intent = new Intent(this, DebtRepaymentView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

}
