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

public class TransactionHome extends AppCompatActivity {
        ImageButton transactionsBtn;
        ImageButton receiptBtn;
        ImageButton reportBtn;
        ImageButton profileBtn;
        ImageButton planningBtn;

        Button addTransactionBtn;
        Button deleteTransactionBtn;
        private ListView mwlistView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_transaction_home);

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

            planningBtn = findViewById(R.id.planningBtn);
            planningBtn.setOnClickListener(v->
            {
                startActivity(new Intent(this,Planning.class));
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
            addTransactionBtn = findViewById(R.id.mwAddBtn);
            addTransactionBtn.setOnClickListener(v->
            {
                startActivity(new Intent(this,TransactionAdd.class));
            });

            deleteTransactionBtn = findViewById(R.id.deleteTransactionBtnMw);
            DatabaseReference referenceMw01= FirebaseDatabase.getInstance().getReference().child("Transaction");
            deleteTransactionBtn.setOnClickListener(v->
            {
                referenceMw01.removeValue();
                Toast.makeText(this, "All Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, com.example.project_mad.TransactionHome.class));
            });

            //

            //Print data in list
            mwlistView = findViewById(R.id.TranscationListView);

            final ArrayList<String> list = new ArrayList<>();
            final ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.budgetlist_item,list);

            mwlistView.setAdapter(adapter);

            DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Transaction");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot postsnapshot: dataSnapshot.getChildren()){
                        TransactionDeclare transaction= postsnapshot.getValue(TransactionDeclare.class);
                        String txt= "Category: " + transaction.getTransCategory()+" \nValue: "+ transaction.getTransValue()+" \nDate: "+ transaction.getTransDate()+ " \nRemark: "+ transaction.getTransRemark();
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

