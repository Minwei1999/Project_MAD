package com.example.project_mad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlanningEvents extends AppCompatActivity {

    TextView travelLocationView;
    TextView totalBudgetView;
    TextView personCountView;
    TextView daysTravelView;
    TextView travelDateView;
    TextView Airasia;
    TextView bookHotel;

    Button updateEventBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_events);

        travelLocationView = findViewById(R.id.travelLocationView);
        totalBudgetView = findViewById(R.id.totalBudgetView);
        personCountView = findViewById(R.id.personCountView);
        daysTravelView = findViewById(R.id.daysTravelView);
        travelDateView = findViewById(R.id.travelDateView);
        updateEventBtn = findViewById(R.id.editEventBtn);


        Airasia = (TextView) findViewById(R.id.bookTravelFlight);
        Airasia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://www.airpaz.com/en";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        bookHotel = findViewById(R.id.bookHotel);
        bookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://www.airbnb.com/";
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse(url));
                startActivity(j);
            }
        });

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Event");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Event event = snapshot.getValue(Event.class);
                    travelLocationView.setText(event.getLocation());
                    totalBudgetView.setText(event.getTotalBudget());
                    personCountView.setText(event.getPersonCount());
                    daysTravelView.setText(event.getDaysofTravel());
                    travelDateView.setText(event.getDateTravel());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        updateEventBtn.setOnClickListener(v->
        {
            startActivity(new Intent(this,PlanningEventUpdate.class));
        });


    }
}