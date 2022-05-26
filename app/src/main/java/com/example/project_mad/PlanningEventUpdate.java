package com.example.project_mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class PlanningEventUpdate extends AppCompatActivity {

    EditText travelLocationUpdate;
    EditText travelBudgetUpdate;
    EditText personCountUpdate;
    EditText travelDaysUpdate;
    EditText travelDateUpdate;
    Button travelUpdateBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_event_update);

        travelLocationUpdate = findViewById(R.id.travelLocationUpdate);
        travelBudgetUpdate = findViewById(R.id.travelBudgetUpdate);
        personCountUpdate = findViewById(R.id.personCountUpdate);
        travelDaysUpdate = findViewById(R.id.daysTravelUpdate);
        travelDateUpdate = findViewById(R.id.dateTravelUpdate);
        travelUpdateBtn = findViewById(R.id.travelUpdateBtn);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Event");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Event event = snapshot.getValue(Event.class);
                    travelLocationUpdate.setText(event.getLocation());
                    travelBudgetUpdate.setText(event.getTotalBudget());
                    personCountUpdate.setText(event.getPersonCount());
                    travelDaysUpdate.setText(event.getDaysofTravel());
                    travelDateUpdate.setText(event.getDateTravel());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        DatabaseEvent eventDatabase=new DatabaseEvent();

        travelUpdateBtn.setOnClickListener(v->
        {
            HashMap<String, Object> hashMap=new HashMap<>();
            hashMap.put("location",travelLocationUpdate.getText().toString());
            hashMap.put("totalBudget",travelBudgetUpdate.getText().toString());
            hashMap.put("personCount",personCountUpdate.getText().toString());
            hashMap.put("daysofTravel",travelDaysUpdate.getText().toString());
            hashMap.put("dateTravel",travelDateUpdate.getText().toString());

            eventDatabase.updates("-N3-0KyudiVCYDQnwq5N",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,PlanningEvents.class));
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });



    }
}