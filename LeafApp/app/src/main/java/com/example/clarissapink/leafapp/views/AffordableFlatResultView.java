package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
import com.example.clarissapink.leafapp.models.HDBFlat;

import java.util.List;

/**
 * This class will display the Affordable Flats
 * @author Emily
 */

public class AffordableFlatResultView extends AppCompatActivity {
    EventHandler eventHandler;
    List<HDBFlat> flatResult;
    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affordable_flat_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle flatAffordResult = getIntent().getExtras();

        eventHandler = flatAffordResult.getParcelable("eventHandler");

        flatResult = eventHandler.findAffordFlats();

        // populateAFListViewFromDB();
    }

/*    private void populateAFListViewFromDB() {
        Cursor cursor = myDb.getAllRows();
        //Allow activity to manage lifetime of the cursor ; deprecated
        startManagingCursor(cursor);

        //Setup mapping from cursor to view fields:
        String[] fromFieldNames = new String[]
                {DatabaseHandl.};
        int[] toViewIDs = new int[]
                {R.id.locationAF, R.id.priceRangeAF};//get the IDS from layout

        //Create adaptor to map columns of the DB onto elements in the UI
        SimpleCursorAdapter myCursorAdaptor =
                new simpleCursorAdaptor(
                        this,
                        R.layout.af_list_layout_, //row layout template (new activity)
                        Cursor,          //cursor (set of DB records to map)
                        fromFieldNames,    //DB Column names
                        toViewIDs     //view IDS to put information in
                );
        //Set the adapter for the list view
        ListView myList = (ListView) findViewById(R.id.flatDetailsAFList);
        myList.setAdapter(myCursorAdapter);

    }*/



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
