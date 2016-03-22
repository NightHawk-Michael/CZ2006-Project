package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
import com.example.clarissapink.leafapp.models.HDBFlat;

import java.util.List;

/**
 * This class will display the FlatsAvailable
 * @author Emily
 */

public class FlatAvailableResultView extends AppCompatActivity {



    EventHandler eventHandler;
    List<HDBFlat> flatResult;

    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_available_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle flatAvailResult = getIntent().getExtras();
        eventHandler = flatAvailResult.getParcelable("eventHandler");


        TextView roomTypeText = (TextView)findViewById(R.id.roomFlatFA);
        TextView locationText = (TextView)findViewById(R.id.LocationFA);
        TextView priceRangeText = (TextView)findViewById(R.id.priceRangeFA);


        roomTypeText.setText(eventHandler.getSelectedRoomType());
        locationText.setText(eventHandler.getSelectedLocation());
        priceRangeText.setText(eventHandler.getSelectedPriceRange());




        flatResult = eventHandler.findAvailFlats();



    }

    /**
     * This method navigates to FlatAvailableResults
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
