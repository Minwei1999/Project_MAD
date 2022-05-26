package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PlanningBudgetDelete extends AppCompatActivity {

    Button confirmDelete;
    EditText categoryDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_budget_delete);

        confirmDelete = findViewById(R.id.confirmDelete);
        categoryDelete = findViewById(R.id.deleteCategory);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query deleteQuery = ref.child("Budget").orderByChild("budgetCategory").equalTo(categoryDelete.getText().toString());


        confirmDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(PlanningBudgetDelete.this, "Removed Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PlanningBudgetDelete.this,PlanningBudget.class));

            }
        });
    }
}