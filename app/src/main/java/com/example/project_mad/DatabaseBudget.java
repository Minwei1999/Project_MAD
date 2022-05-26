package com.example.project_mad;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseBudget {
    private DatabaseReference databaseReference;

    public DatabaseBudget(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("Budget");
    }

    public Task<Void> add (Budget budget){
        return databaseReference.push().setValue(budget);
    }
}
