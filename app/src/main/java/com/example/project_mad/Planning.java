package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Planning extends AppCompatActivity {

    ImageButton transactionsBtn;
    ImageButton receiptBtn;
    ImageButton planningBtn;
    ImageButton reportBtn;
    ImageButton profileBtn;

    Button budgetBtn;
    Button eventBtn;
    Button planningGPSBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        //Image Button (bottom navigation) links

        transactionsBtn = findViewById(R.id.transactionBtn);
        transactionsBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,Transactions.class));
        });

        receiptBtn = findViewById(R.id.receiptBtn);
        receiptBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,Receipt.class));
        });

        planningBtn = findViewById(R.id.planningBtn);
        planningBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,Planning.class));
        });

        reportBtn = findViewById(R.id.reportBtn);
        reportBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,Report.class));
        });

        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,Profile.class));
        });
        //Image button links end

        //Button links
        budgetBtn = findViewById(R.id.budgetBtn);

        eventBtn = findViewById(R.id.eventsBtn);

        planningGPSBtn = findViewById(R.id.planningGPSBtn);

        budgetBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,PlanningBudget.class));
        });


        eventBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,PlanningEvents.class));
        });


        planningGPSBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,PlanningGPS.class));
        });



    }
}