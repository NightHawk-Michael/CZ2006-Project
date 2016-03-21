package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.clarissapink.leafapp.R;
import com.example.clarissapink.leafapp.controllers.ViewHDBController;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.UserInputs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will manage the buttons in FlatAvailable screen
 * @author Emily
 */
public class FlatAvailableView extends AppCompatActivity {

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
    HDBCollection hdbCollection;
    UserInputs inputs;
    String[] selectedRoomType = new String[7];

    String roomType;
    String region;
    String priceRange;

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


        hdbCollection = flatavail.getParcelable("hdbCollection");
        inputs = flatavail.getParcelable("inputs");

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
        priceRange1 = (CheckBox)findViewById(R.id.checkBox16);
        priceRange2 = (CheckBox)findViewById(R.id.checkBox17);
        priceRange3 = (CheckBox)findViewById(R.id.checkBox18);
        priceRange4 = (CheckBox)findViewById(R.id.checkBox19);
        searchButton = (Button)findViewById(R.id.searchButtonFA);

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if (room1.isChecked()) {
                    selectedRoomType[0] = "1-room";
                }
                if (room2.isChecked()) {
                    selectedRoomType[1] = "2-room";
                }
                if (room3.isChecked()) {
                    selectedRoomType[2] = "3-room";
                }
                if (room4.isChecked()) {
                    selectedRoomType[3] = "4-room";
                }
                if (room5.isChecked()) {
                    selectedRoomType[4] = "5-room";
                }
                if (executive.isChecked()) {
                    selectedRoomType[5] = "executive";
                }
                if (gen3.isChecked()) {
                    selectedRoomType[6] = "3-gen";
                }
                if (priceRange1.isChecked()) {
                    priceRange = "50,000 - 200,000";
                }
                if (priceRange2.isChecked()) {
                    priceRange = "200,001 - 400,000";
                }
                if (priceRange3.isChecked()) {
                    priceRange = "400,001 - 600,000";
                }
                if (priceRange4.isChecked()) {
                    priceRange = ">600,001";
                }
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
            ViewHDBController availController = new ViewHDBController(hdbCollection);
//            HDBCollection availFlats = new HDBCollection(availController.findFlats(inputs.getSelectedRoomType(), inputs.getRegion(), inputs.getPriceRange()));

            // HERE, we call the method for the controller from the eventhandler,
            // THEN, we pass the result object to the next activity

            Intent intent = new Intent(this, FlatAvailableResultView.class);
            intent.putExtra("hdbCollection", hdbCollection);
            intent.putExtra("inputs", inputs);
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
