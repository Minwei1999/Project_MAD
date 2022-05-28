package com.example.project_mad;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class Report extends AppCompatActivity {
    ImageButton transactionsBtn;
    ImageButton receiptBtn;
    ImageButton planningBtn;
    ImageButton reportBtn;
    ImageButton profileBtn;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jan_report);

        pieChart = findViewById(R.id.piechart);
        loadPieChartData();
        setupPieChart();


        //Image Button links

        transactionsBtn = findViewById(R.id.transactionBtn);
        transactionsBtn.setOnClickListener(v ->
        {
            startActivity(new Intent(this, Transactions.class));
        });

        receiptBtn = findViewById(R.id.receiptBtn);
        receiptBtn.setOnClickListener(v ->
        {
            startActivity(new Intent(this, Receipt.class));
        });

        planningBtn = findViewById(R.id.planningBtn);
        planningBtn.setOnClickListener(v ->
        {
            startActivity(new Intent(this, Planning.class));
        });

        reportBtn = findViewById(R.id.reportBtn);
        reportBtn.setOnClickListener(v ->
        {
            startActivity(new Intent(this, Report.class));
        });

        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(v ->
        {
            startActivity(new Intent(this, Profile.class));
        });
        //Image button links end
    }
            private void setupPieChart(){
                pieChart.setDrawHoleEnabled(true);
                pieChart.setUsePercentValues(true);
                pieChart.setEntryLabelTextSize(12);
                pieChart.setEntryLabelColor(Color.BLACK);
                pieChart.setCenterText("Spending by Category");
                pieChart.setCenterTextSize(24);
                pieChart.getDescription().setEnabled(false);

                Legend l = pieChart.getLegend();
                l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
                l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
                l.setOrientation(Legend.LegendOrientation.VERTICAL);
                l.setDrawInside(false);
                l.setEnabled(true);

            }
            private void loadPieChartData () {
                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry(0.2f,"Entertainment"));
                entries.add(new PieEntry(0.1f,"Medical"));
                entries.add(new PieEntry(0.3f,"Food"));
                entries.add(new PieEntry(0.25f,"Rental"));
                entries.add(new PieEntry(0.15f,"Bills"));

                ArrayList<Integer> colors = new ArrayList<>();
                for (int color: ColorTemplate.MATERIAL_COLORS){
                    colors.add(color);
                }
                for (int color: ColorTemplate.VORDIPLOM_COLORS){
                    colors.add(color);
                }

                PieDataSet dataSet = new PieDataSet(entries,"Expenses Category");
                dataSet.setColors(colors);

                PieData data = new PieData(dataSet);
                data.setDrawValues(true);
                data.setValueFormatter(new PercentFormatter(pieChart));
                data.setValueTextSize(12f);
                data.setValueTextColor(Color.BLACK);

                pieChart.setData(data);
                pieChart.invalidate();
                pieChart.animateY(1400, Easing.EaseInOutQuad);

    }
}

