package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.clarissapink.leafapp.R;

public class FlatAvailable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_available);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void searchButton(View view)
    {
        String buttonSearch;
        buttonSearch = ((Button) view).getText().toString();
        if(buttonSearch.equals("Search"))
        {
            Intent intent = new Intent(this, FlatAvailableResult.class);
            startActivity(intent);
        }

    }

}
