package com.example.project_mad;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DatabaseEvent {
    private DatabaseReference databaseReference;

    public DatabaseEvent(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("Event");
    }

    public Task<Void> add (Event event){
        return databaseReference.push().setValue(event);
    }

    public Task<Void>updates(String key, HashMap<String, Object> hashMap) {
        return databaseReference.child(key).updateChildren(hashMap);
    }
}
