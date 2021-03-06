package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ImageButton transactionsBtn;
    ImageButton receiptBtn;
    ImageButton planningBtn;
    ImageButton reportBtn;
    ImageButton profileBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
    }

    public void logout (View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

}