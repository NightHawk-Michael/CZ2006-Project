package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;

import java.util.ArrayList;

/**
 * This class will display the Affordable Flats
 * @author Emily
 */

public class AffordableFlatResultView extends AppCompatActivity {
    EventHandler eventHandler;
    private ListView lv;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> adapter;
    public String flatLocation;

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


        strArr= new ArrayList<String>();
        lv = (ListView)findViewById(R.id.listView2);

        strArr = eventHandler.findAffordFlats();
        String noFlatFound = "No flat found!";
        if (strArr.size()== 0 ){
            strArr.add(noFlatFound);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strArr);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        /**
         * onclick listener for data in listview
         */
        if(!strArr.contains(noFlatFound)){
            String tmp = strArr.get(0);
            flatLocation = tmp.substring(0,tmp.indexOf(','));
            lv.setOnItemClickListener(onListClick);
        }
    }
    /**
     * method to handler onListClick
     */

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            //create intent
            Intent i = new Intent(AffordableFlatResultView.this, MapDisplay.class);
            i.putExtra("location", flatLocation);
            startActivity(i);
        }
    };


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
