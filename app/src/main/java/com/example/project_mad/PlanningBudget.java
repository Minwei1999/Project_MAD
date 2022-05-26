package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlanningBudget extends AppCompatActivity {
    ImageButton transactionsBtn;
    ImageButton receiptBtn;
    ImageButton reportBtn;
    ImageButton profileBtn;

    Button addBudgetBtn;
    Button deleteBudgetBtn;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_budget);

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

        // Budget Button links
        addBudgetBtn = findViewById(R.id.addBudgetBtn);
        addBudgetBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,PlanningBudgetAdd.class));
        });

        deleteBudgetBtn = findViewById(R.id.deleteBudgetBtn);
        DatabaseReference reference2= FirebaseDatabase.getInstance().getReference().child("Budget");
        deleteBudgetBtn.setOnClickListener(v->
        {
            reference2.removeValue();
            Toast.makeText(this, "All Data Deleted Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,PlanningBudget.class));
        });

        //

        //Print data in list
        listView = findViewById(R.id.BudgetListView);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.budgetlist_item,list);

        listView.setAdapter(adapter);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Budget");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot postsnapshot: dataSnapshot.getChildren()){
                    Budget budget= postsnapshot.getValue(Budget.class);
                    String txt= "Category: " + budget.getBudgetCategory()+" \n Goal Value: "+ budget.getBudgetGoal()+" \n End Date: "+ budget.getBudgetDate() ;
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        


    }
}