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

public class PlanningBudgetAdd extends AppCompatActivity {

    EditText budgetCategoryAdd;
    EditText budgetGoalAdd;
    EditText budgetDateAdd;
    Button budgetAddSaveBtn;
    DatePickerDialog picker;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date dateObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_budget_add);

        budgetCategoryAdd = findViewById(R.id.budgetCategoryAdd);
        budgetGoalAdd = findViewById(R.id.budgetGoalAdd);
        budgetDateAdd = findViewById(R.id.budgetDateAdd);
        budgetAddSaveBtn = findViewById(R.id.budgetAddSave);

        budgetDateAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(PlanningBudgetAdd.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        budgetDateAdd.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                picker.show();

            }
        });

        DatabaseBudget databaseBudget = new DatabaseBudget();

        budgetAddSaveBtn.setOnClickListener(v->
        {
            Budget budget = new Budget(budgetCategoryAdd.getText().toString(),Float.parseFloat(budgetGoalAdd.getText().toString()),budgetDateAdd.getText().toString());
            databaseBudget.add(budget).addOnSuccessListener(suc->{
                Toast.makeText(this, "New Budget Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,PlanningBudget.class));
            });
        });
    }
}