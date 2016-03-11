package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.clarissapink.leafapp.R;

public class AffordableFlatResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affordable_flat_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void btn1(View view) {
        Intent intent = new Intent(this, FlatAvailable.class);
        startActivity(intent);
    }

    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlat.class);
        startActivity(intent);
    }

    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrant.class);
        startActivity(intent);
    }

    public void btn4(View view) {
        Intent intent = new Intent(this, Debt_Repayment.class);
        startActivity(intent);
    }

}
