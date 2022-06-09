package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {
    ImageButton transactionsBtn;
    ImageButton receiptBtn;
    ImageButton planningBtn;
    ImageButton reportBtn;
    ImageButton profileBtn;

    TextInputLayout username, email, password, contact;
    TextView emaillabel;
    String uname, emailid, pswd, number;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        reference= FirebaseDatabase.getInstance().getReference("users");

        username = findViewById(R.id.uname_profile);
        email = findViewById(R.id.email_profile);
        password = findViewById(R.id.pswd_profile);
        contact = findViewById(R.id.contact_profile);

        showAllUserData();

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

    private void showAllUserData(){
        Intent intent = getIntent();
        emailid = intent.getStringExtra("emailLogin");
        pswd = intent.getStringExtra("passwordLogin");
        number = intent.getStringExtra("phoneNumRegister");

        email.getEditText().setText(emailid);
        password.getEditText().setText(pswd);
        contact.getEditText().setText(number);


    }

    public void update(View view){

        if (isNameChanged() || isPasswordChanged()){
            Toast.makeText(this, "Data has been updated!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Data has not been updated!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isNameChanged() {
        if (!uname.equals(username.getEditText().getText().toString())){
            reference.child(uname).child("name").setValue(username.getEditText().getText().toString());
            uname=username.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }

    }

    private boolean isPasswordChanged(){
        if(!pswd.equals(password.getEditText().getText().toString())){
            reference.child(emailid).child("password").setValue(password.getEditText().getText().toString());
            pswd=password.getEditText().getText().toString();
            return true;
        }
        else{
            return false;
        }

    }

    public void logout (View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}