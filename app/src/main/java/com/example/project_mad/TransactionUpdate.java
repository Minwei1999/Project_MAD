package com.example.project_mad;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TransactionUpdate extends AppCompatActivity {

    EditText updateCategory;
    EditText updateValue;
    EditText updateDateMw;
    EditText updateRemark;
    Button updateBtnMw01;
    DatePickerDialog pickerMw01;
    DateFormat formatterMw01 = new SimpleDateFormat("dd/MM/yyyy");
    Date dateObjectMw01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_update);

        updateCategory = findViewById(R.id.updateCategory);
        updateValue = findViewById(R.id.updateValue);
        updateRemark = findViewById(R.id.updateRemark);
        updateDateMw = findViewById(R.id.updateDateMw);
        updateBtnMw01 = findViewById(R.id.updateBtnMw01);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Transaction");

        updateDateMw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendarMw = Calendar.getInstance();
                int day = calendarMw.get(Calendar.DAY_OF_MONTH);
                int month = calendarMw.get(Calendar.MONTH);
                int year = calendarMw.get(Calendar.YEAR);

                pickerMw01 = new DatePickerDialog(TransactionUpdate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        updateDateMw.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                pickerMw01.show();

            }
        });

        DatabaseTransaction databaseTransaction02 = new DatabaseTransaction();

        updateBtnMw01.setOnClickListener(v->
        {
            HashMap<String, Object> hashMap=new HashMap<>();
            hashMap.put("transCategory",updateCategory.getText().toString());
            hashMap.put("transValue",Float.parseFloat(updateValue.getText().toString()));
            hashMap.put("transDate",updateDateMw.getText().toString());
            hashMap.put("transRemark",updateRemark.getText().toString());

            databaseTransaction02.updates("-N34pt3zbnClwFGUkEB_",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,TransactionHome.class));
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}
