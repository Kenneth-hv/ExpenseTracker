package com.example.expensetracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.expensetracker.controler.ExpenseTracker;


public class MainActivity extends AppCompatActivity {
    private ExpenseTracker expenseTracker;
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("tracker", Context.MODE_PRIVATE);

        expenseTracker = ExpenseTracker.getInstance();

        updateCurrentTotal();
    }

    public void addExpenseButton(View view){
        Intent addExpenseIntent = new Intent(this, AddExpenseActivity.class);
        startActivityForResult(addExpenseIntent,0);
        updateCurrentTotal();
    }

    public void addIncomeButton(View view){
        Intent addIncomeIntent = new Intent(this, AddIncomeActivity.class);
        startActivity(addIncomeIntent);
        updateCurrentTotal();
    }

    public void viewHistoryButton(View view){
        Intent viewHistoryActivity = new Intent(this, ViewHistory.class);
        startActivityForResult(viewHistoryActivity,0);
        updateCurrentTotal();
    }

    private void updateCurrentTotal(){
        TextView total = findViewById(R.id.totalTextView);
        total.setText(expenseTracker.getTotalString());
    }

    public static SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }
}
