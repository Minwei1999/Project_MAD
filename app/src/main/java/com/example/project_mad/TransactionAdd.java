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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TransactionAdd extends AppCompatActivity {
    EditText transactionCategoryAdd;
    EditText transactionValueAdd;
    EditText transactionDateAdd;
    EditText transactionRemarkAdd;
    Button transactionAddSave;
    DatePickerDialog pickerMw;
    DateFormat formatterMw = new SimpleDateFormat("dd/MM/yyyy");
    Date dateObjectMw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_add);

        transactionCategoryAdd = findViewById(R.id.transactionCategoryAdd);
        transactionValueAdd = findViewById(R.id.transactionValueAdd);
        transactionDateAdd = findViewById(R.id.transactionDateAdd);
        transactionRemarkAdd = findViewById(R.id.transactionRemarkAdd);
        transactionAddSave = findViewById(R.id.transactionAddSave);

        transactionDateAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendarMw = Calendar.getInstance();
                int day = calendarMw.get(Calendar.DAY_OF_MONTH);
                int month = calendarMw.get(Calendar.MONTH);
                int year = calendarMw.get(Calendar.YEAR);

                pickerMw = new DatePickerDialog(TransactionAdd.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        transactionDateAdd.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                pickerMw.show();

            }
        });

        DatabaseTransaction databaseTransaction = new DatabaseTransaction();

        transactionAddSave.setOnClickListener(v->
        {
            TransactionDeclare transaction = new TransactionDeclare(transactionCategoryAdd.getText().toString(),Float.parseFloat(transactionValueAdd.getText().toString()),transactionDateAdd.getText().toString(), transactionRemarkAdd.getText().toString());
            databaseTransaction.add(transaction).addOnSuccessListener(suc->{
                Toast.makeText(this, "New Transaction Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,TransactionHome.class));
            });
        });
    }
}
