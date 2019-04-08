package com.example.expensetracker.data;

import java.util.ArrayList;

public class ExpenseTrackerSystem {
    ArrayList<Register> registersList;
    private double totalExpended;
    private double totalIncomes;
    private double total;

    public ExpenseTrackerSystem(){
        registersList = new ArrayList<Register>() {};

        totalExpended = 0;
        totalIncomes = 0;
        total = 0;
    }

    public ArrayList<Register> getRegistersList(){
        return registersList;
    }

    public String getStringDecimalTotal(){
        String str = "₡";
        str += Math.round(total * 100.0) / 100.0;
        return str;
    }

    public void addIncome(float value, String description){
        registersList.add(0, new Register(value, description, Register.Type.Income));
        totalIncomes += value;
        total += value;
    }

    public void addExpense(float value, String description){
        registersList.add(0, new Register(value, description, Register.Type.Expense));
        totalExpended += value;
        total -= value;
    }

    public void updateValues(){
        totalExpended = 0;
        totalIncomes = 0;
        for (Register register: registersList) {
            if(register.getType() == Register.Type.Income){
                totalIncomes += register.getValue();
            } else {
                totalExpended += register.getValue();
            }
        }
        total = totalIncomes - totalExpended;
    }

}
