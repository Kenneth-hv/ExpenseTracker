package data;

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

    public void addIncome(float value, String description){
        registersList.add(new Income(value, description));
        totalIncomes += value;
        total += value;
    }

    public void addExpense(float value, Expense.Category category, String description){
        registersList.add(new Expense(value, category, description));
        totalExpended += value;
        total -= value;
    }

    public void updateValues(){
        totalExpended = 0;
        totalIncomes = 0;
        for (Register register: registersList) {
            if(register instanceof Income){
                totalIncomes += register.getValue();
            } else {
                totalExpended += register.getValue();
            }
        }
        total = totalIncomes - totalExpended;
    }

}
