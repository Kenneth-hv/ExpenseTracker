package com.example.expensetracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.expensetracker.controler.ExpenseTracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class MainActivity extends AppCompatActivity {
    private ExpenseTracker expenseTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expenseTracker = ExpenseTracker.getInstance();
        System.out.print(getApplicationInfo().dataDir);
        loadJSON();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveJSON();
    }

    public void addExpenseButton(View view){
        Intent addExpenseIntent = new Intent(this, AddExpenseActivity.class);
        startActivity(addExpenseIntent);
    }

    public void addIncomeButton(View view){
        Intent addIncomeIntent = new Intent(this, AddIncomeActivity.class);
        startActivity(addIncomeIntent);

    }

    public void saveJSON() {
        SharedPreferences sharedPreferences = getSharedPreferences("tracker", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(expenseTracker);
        editor.putString("registers", json);
        editor.apply();
    }

    public void loadJSON() {
        SharedPreferences sharedPreferences = getSharedPreferences("tracker", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("registers", null);
        Type type = new TypeToken<ExpenseTracker>() {
        }.getType();
        expenseTracker = gson.fromJson(json, type);

        if (expenseTracker == null)
            expenseTracker = ExpenseTracker.getInstance();
    }
}
