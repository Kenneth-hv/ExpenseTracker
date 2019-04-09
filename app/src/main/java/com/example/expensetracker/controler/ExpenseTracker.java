package com.example.expensetracker.controler;

import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.example.expensetracker.MainActivity;
import com.example.expensetracker.data.ExpenseTrackerSystem;
import com.example.expensetracker.data.Register;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ExpenseTracker {
    private static ExpenseTracker instance;
    private ExpenseTrackerSystem system;


    private ExpenseTracker(){
        instance = this;
        system = new ExpenseTrackerSystem();
    }

    static public ExpenseTracker getInstance(){
        if(instance == null) {
            if(loadData()) {
               return instance;
            } else {
                return new ExpenseTracker();
            }
        } else {
            return instance;
        }
    }

    static boolean loadData(){
        SharedPreferences sharedPreferences = MainActivity.getSharedPreferences();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("registers", null);
        Type type = new TypeToken<ExpenseTracker>() {
        }.getType();

        instance = gson.fromJson(json, type);

        if (instance == null)
            return false;

        return true;
    }

    public void saveData(){
        SharedPreferences sharedPreferences = MainActivity.getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(instance);
        editor.putString("registers", json);
        editor.apply();
    }

    public void addIncome(float value, String description){
        system.addIncome(value, description);
        saveData();
    }

    public void addExpense(float value, String description){
        system.addExpense(value, description);
        saveData();
    }

    public ArrayList<Register> getRegisters(){
        return system.getRegistersList();
    }

    public String getTotalString(){
        return system.getStringDecimalTotal();
    }

    public void deleteRegister(int i){
        system.deleteRegister(i);
        saveData();
    }
}
