package com.example.expensetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.expensetracker.controler.ExpenseTracker;
import com.example.expensetracker.data.Expense;


public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
    }

    public void addExpenseButtonClick(View view){

        EditText editText_expense = findViewById(R.id.expenseInput);


        float value = Float.parseFloat(editText_expense.getText().toString());
        ExpenseTracker.getInstance().addExpense(value, "Gasto", Expense.Category.OTHER);

    }
}
