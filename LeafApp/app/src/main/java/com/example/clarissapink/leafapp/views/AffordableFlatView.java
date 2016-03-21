package com.example.clarissapink.leafapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clarissapink.leafapp.R;
import com.example.clarissapink.leafapp.controllers.ViewHDBController;
import com.example.clarissapink.leafapp.models.HDBCollection;
import com.example.clarissapink.leafapp.models.UserInputs;

/**
 * This class will manage the buttons in Affordable screen
 * @author Emily
 */
public class AffordableFlatView extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter;

    Spinner repaymentPeriod;
    EditText monthlyInstallment;
    Button searchButton;
    HDBCollection hdbCollection;
    UserInputs inputs;

    double monthlyIn;
    int repaymentP;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affordable_flat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle flatafford = getIntent().getExtras();

        hdbCollection = flatafford.getParcelable("hdbCollection");
        inputs = flatafford.getParcelable("inputs");
        monthlyInstallment = (EditText) findViewById(R.id.monthlyInstallment);
        searchButton = (Button)findViewById(R.id.searchButton);
        //spinner
        repaymentPeriod = (Spinner) findViewById(R.id.spinnerAFRepaymentPeriod);
        adapter = ArrayAdapter.createFromResource(this, R.array.repaymentPeriod, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        repaymentPeriod.setAdapter(adapter);
        repaymentPeriod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                monthlyIn = Double.parseDouble(monthlyInstallment.getText().toString());
                repaymentP = Integer.parseInt(repaymentPeriod.toString());

            }
    });
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

    /**
     * This method navigates the searchButton on AffordableFlatView
     * @param view stores what the user interact with the button
     */
    public void searchButton(View view) {
        String buttonSearch;
        buttonSearch = ((Button) view).getText().toString();
        if (buttonSearch.equals("Search")) {
            ViewHDBController availController = new ViewHDBController(hdbCollection, inputs);

            Intent intent = new Intent(this, AffordableFlatResultView.class);
            intent.putExtra("hdbCollection", hdbCollection);
            intent.putExtra("inputs", inputs);
            startActivity(intent);
        }

    }
}
