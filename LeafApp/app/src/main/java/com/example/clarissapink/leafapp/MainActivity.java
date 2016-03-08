package com.example.clarissapink.leafapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showGreetings(View view)
    {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if(button_text.equals("      Debt Repayment        "))
        {
            Intent intent = new Intent(this, Debt_Repayment.class);
            startActivity(intent);
        }
        else if(button_text.equals("     Applicable Grant     "))
        {
            Intent intent = new Intent(this, ApplicableGrant.class);
            startActivity(intent);
        }
        else if(button_text.equals("      Affordable Flat      "))
        {
            Intent intent = new Intent(this, AffordableFlat.class);
            startActivity(intent);
        }
        else if(button_text.equals("      Flat Availiability     "))
        {
            Intent intent = new Intent(this, FlatAvailable.class);
            startActivity(intent);
        }
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
}
