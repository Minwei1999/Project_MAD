package com.example.project_mad;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DatabaseTransaction {
    private DatabaseReference databaseReference;

    public DatabaseTransaction(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("Transaction");
    }

    public Task<Void> add (TransactionDeclare transaction){
        return databaseReference.push().setValue(transaction);
    }

    public Task<Void>updates(String key, HashMap<String, Object> hashMap) {
        return databaseReference.child(key).updateChildren(hashMap);
    }
}
