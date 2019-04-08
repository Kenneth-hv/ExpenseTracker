package com.example.expensetracker.controler;

import java.util.ArrayList;

import com.example.expensetracker.data.Expense;
import com.example.expensetracker.data.ExpenseTrackerSystem;
import com.example.expensetracker.data.Register;

public class ExpenseTracker {
    private static ExpenseTracker instance;
    private ExpenseTrackerSystem system;


    private ExpenseTracker(){
        instance = this;
        system = new ExpenseTrackerSystem();
    }

    static public ExpenseTracker getInstance(){
        if(instance == null) {
            if(!loadData()) {
                return new ExpenseTracker();
            } else {
                return new ExpenseTracker(); //TODO: CHANGE WHEN LOAD DATA IMPLEMENTED.
            }
        } else {
            return instance;
        }
    }

    static boolean loadData(){

        //TODO: LOAD DATA IMPLEMENTATION


        return false;
    }

    public void saveData(){
        //TODO: SAVE DATA IMPLEMENTATION
    }

    public void addIncome(float value, String description){
        system.addIncome(value, description);
        saveData();
    }

    public void addExpense(float value, String description, Expense.Category category){
        system.addExpense(value, description, category);
        saveData();
    }

    public ArrayList<Register> getRegisters(){
        return system.getRegistersList();
    }

    public String getTotalString(){
        return system.getStringDecimalTotal();
    }
}
