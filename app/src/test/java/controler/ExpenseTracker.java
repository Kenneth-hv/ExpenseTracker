package controler;

import java.util.ArrayList;

import data.Expense;
import data.ExpenseTrackerSystem;
import data.Register;

public class ExpenseTracker {
    private static ExpenseTracker instance;
    private ExpenseTrackerSystem system;


    private ExpenseTracker(){
        instance = this;
        system = new ExpenseTrackerSystem();
    }

    public ExpenseTracker getInstance(){
        if(instance == null) {
            return new ExpenseTracker();
        } else {
            return instance;
        }
    }

    public void addIncome(float value, String description){
        system.addIncome(value, description);
    }

    public void addExpense(float value, Expense.Category category, String description){
        system.addExpense(value, category, description);
    }

    public ArrayList<Register> getRegisters(){
        return system.getRegistersList();
    }
}
