package com.example.clarissapink.leafapp.views;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.clarissapink.leafapp.ApiManager;
import com.example.clarissapink.leafapp.DatabaseHandler;
import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
import com.example.clarissapink.leafapp.controllers.AffordableFlatController;
import com.example.clarissapink.leafapp.controllers.DebtController;
import com.example.clarissapink.leafapp.controllers.ViewHDBController;
import com.example.clarissapink.leafapp.models.DebtRepaymentDetails;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.UserInputs;

/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class MainPageView extends AppCompatActivity{
    DatabaseHandler databaseHandler;
    SQLiteDatabase db;
    HDBCollection hdbCollection;
    DebtRepaymentDetails debt;
    ViewHDBController availFlatsCtr;
    AffordableFlatController affordFlatsCtr;
    DebtController debtCtr;
    EventHandler eventHandler;
    UserInputs inputs;


    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseHandler = new DatabaseHandler(this);
        boolean exists = databaseHandler.checkDataBase();
//        //check connection
        boolean connected = checkConnection();

        inputs = new UserInputs();


        if(exists) {
            db = databaseHandler.openDatabase();
            db = databaseHandler.getReadableDatabase();
        } else if (connected == true) {
            ApiManager apiMgr = new ApiManager(databaseHandler);
            apiMgr.getApiData();
        }


        hdbCollection = new HDBCollection(databaseHandler.getAllHDB());
        debt = new DebtRepaymentDetails(0);
        availFlatsCtr = new ViewHDBController(hdbCollection);
        affordFlatsCtr = new AffordableFlatController(hdbCollection);
        debtCtr = new DebtController();
         eventHandler = new EventHandler(inputs,hdbCollection, debt, availFlatsCtr,affordFlatsCtr,debtCtr);

    }
    /**
     * This method navigates to different classes (DebtRepayment, Applicable Grant, Affordable Flat, Flat Availability) based on user click input.
     * @param view stores what the user interact with the button
     */
    public void showGreetings(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Debt Repayment")) {
            Intent intent = new Intent(this, DebtRepaymentView.class);
            intent.putExtra("eventHandler", eventHandler);
            startActivity(intent);
        } else if (button_text.equals("Applicable Grant")) {
            Intent intent = new Intent(this, ApplicableGrantView.class);
            startActivity(intent);
        } else if (button_text.equals("Affordable Flat")) {
            Intent intent = new Intent(this, AffordableFlatView.class);
            intent.putExtra("eventHandler", eventHandler);
            startActivity(intent);
        } else if (button_text.equals("Flat Availability")) {
            Intent intent = new Intent(this, FlatAvailableView.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //method to check if there is internet connection
    private boolean checkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return true; // connected to wifi
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true; // connected to mobile data
            } else {
                return false; // not connected
            }
        }
        return false;
    }
}
