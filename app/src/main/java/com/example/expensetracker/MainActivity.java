package com.example.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.expensetracker.controler.ExpenseTracker;


public class MainActivity extends AppCompatActivity {
    private ExpenseTracker expenseTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expenseTracker = ExpenseTracker.getInstance();

    }

    public void addExpenseButton(View view){
        Intent addExpenseIntent = new Intent(this, AddExpenseActivity.class);
        startActivity(addExpenseIntent);
    }

    public void addIncomeButton(View view){
        Intent addIncomeIntent = new Intent(this, AddIncomeActivity.class);
        startActivity(addIncomeIntent);
    }

}
