package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Transactions extends AppCompatActivity {
    ImageButton transactionsBtn;
    ImageButton receiptBtn;
    ImageButton planningBtn;
    ImageButton reportBtn;
    ImageButton profileBtn;

    Button addTransBtn;
    Button viewTransBtn;
    Button acclerometerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        //Image Button links

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
        addTransBtn = findViewById(R.id.budgetBtn);

        viewTransBtn = findViewById(R.id.eventsBtn);

        acclerometerBtn = findViewById(R.id.eventsBtn2);

        addTransBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,TransactionHome.class));
        });


        viewTransBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,TransactionUpdate.class));
        });

        acclerometerBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,TransactionAccelerometer.class));
        });
    }
}