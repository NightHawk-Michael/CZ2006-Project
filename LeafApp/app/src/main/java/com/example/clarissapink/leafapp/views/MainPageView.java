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
import com.example.clarissapink.leafapp.R;
import com.example.clarissapink.leafapp.models.HDBCollection;
/**
 * This class will manage the footer buttons and displays Debt Repayment result
 *
 * @author YongLing
 *
 */
public class MainPageView extends AppCompatActivity {
    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Database
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        //check connection
        boolean connected = checkConnection();

        if (connected == true) {
            ApiManager apiMgr = new ApiManager(databaseHandler);
            apiMgr.getApiData();
        }

        HDBCollection hdbCollection = new HDBCollection(databaseHandler.getAllHDB());

    }
    /**
     * This method navigates to different classes (DebtRepaymentView, Applicable Grant, Affordable Flat, Flat Availability) based on user click input.
     * @param view stores what the user interact with the button
     */
    public void showGreetings(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Debt Repayment")) {
            Intent intent = new Intent(this, DebtRepaymentView.class);
            startActivity(intent);
        } else if (button_text.equals("Applicable Grant")) {
            Intent intent = new Intent(this, ApplicableGrantView.class);
            startActivity(intent);
        } else if (button_text.equals("Affordable Flat")) {
            Intent intent = new Intent(this, AffordableFlatView.class);
            startActivity(intent);
        } else if (button_text.equals("Flat Availability")) {
            Intent intent = new Intent(this, FlatAvailableView.class);
            startActivity(intent);
        }
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
