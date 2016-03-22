package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;

/**
 * This class will manage the buttons in FlatAvailable screen
 * @author Emily
 */
public class FlatAvailableView extends AppCompatActivity{

    ArrayAdapter<CharSequence> adapter;

    CheckBox room1;
    CheckBox room2;
    CheckBox room3;
    CheckBox room4;
    CheckBox room5;
    CheckBox executive;
    CheckBox gen3;
    Spinner location;
    CheckBox priceRange1;
    CheckBox priceRange2;
    CheckBox priceRange3;
    CheckBox priceRange4;
    Button searchButton;

    /**
     * Other attributes
     */
    EventHandler eventHandler;
    String[] selectedRoomType = new String[7];
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
        room1 = (CheckBox)findViewById(R.id.checkBox9);
        room2 = (CheckBox)findViewById(R.id.checkBox10);
        room3 = (CheckBox)findViewById(R.id.checkBox11);
        room4 = (CheckBox)findViewById(R.id.checkBox12);
        room5 = (CheckBox)findViewById(R.id.checkBox13);
        executive = (CheckBox)findViewById(R.id.checkBox14);
        gen3 = (CheckBox)findViewById(R.id.checkBox15);
        location = (Spinner)findViewById(R.id.spinnerFALocation);
        adapter = ArrayAdapter.createFromResource(this, R.array.locSpinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter);
        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        priceRange1 = (CheckBox)findViewById(R.id.checkBox16);
        priceRange2 = (CheckBox)findViewById(R.id.checkBox17);
        priceRange3 = (CheckBox)findViewById(R.id.checkBox18);
        priceRange4 = (CheckBox)findViewById(R.id.checkBox19);
        searchButton = (Button)findViewById(R.id.searchButtonFA);

        room1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton room1, boolean isChecked) {
                if (room1.isChecked()) {
                    selectedRoomType[0] = "1-room";
                }
            }
        });
        room2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton room2, boolean isChecked) {
                if (room2.isChecked()) {
                    selectedRoomType[1] = "2-room";
                }
            }
        });
        room3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton room3, boolean isChecked) {
                if (room3.isChecked()) {
                    selectedRoomType[2] = "3-room";
                }
            }
        });
        room4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton room4, boolean isChecked) {
                if (room4.isChecked()) {
                    selectedRoomType[3] = "4-room";
                }
            }
        });
        room5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton room5, boolean isChecked) {
                if (room5.isChecked()) {
                    selectedRoomType[4] = "5-room";
                }
            }
        });
        executive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton executive, boolean isChecked) {
                if (executive.isChecked()) {
                    selectedRoomType[5] = "executive";
                }
            }
        });
        gen3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton gen3, boolean isChecked) {
                if (gen3.isChecked()) {
                    selectedRoomType[6] = "3-gen";
                }
            }
        });
        priceRange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (priceRange1.isChecked()) {
                     selectedPriceRange = "50,000 - 200,000";
                }
            }
        });
        priceRange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (priceRange2.isChecked()) {
                     selectedPriceRange = "200,001 - 400,000";
                }
            }
        });
        priceRange3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (priceRange3.isChecked()) {
                    selectedPriceRange = "400,001 - 600,000";
                }
            }
        });
        priceRange4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (priceRange4.isChecked()) {
                    selectedPriceRange = ">600,000";
                }
        }
        });

        selectedLocation = location.getSelectedItem().toString();

        //update user input ising eventhandler
        eventHandler.setAvailFlatInputs(selectedRoomType,selectedLocation,selectedPriceRange);

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
            // HERE, we call the method for the controller from the eventhandler,
            // THEN, we pass the result object to the next activity
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
        startActivity(intent);
    }

    /**
     * This method navigates to AffordableFlat
     * @param view stores what the user interact with the button
     */
    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlatView.class);
        startActivity(intent);
    }

    /**
     * This method navigates to ApplicableGrant
     * @param view stores what the user interact with the button
     */
    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrantView.class);
        startActivity(intent);
    }

    /**
     * This method navigates to DebtRepayment
     * @param view stores what the user interact with the button
     */
    public void btn4(View view) {
        Intent intent = new Intent(this, DebtRepaymentView.class);
        startActivity(intent);
    }

}
