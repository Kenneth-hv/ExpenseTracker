package com.example.expensetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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
        EditText editText_description = findViewById(R.id.expenseDescription);
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        int category = categorySpinner.getSelectedItemPosition();


        float value = Float.parseFloat(editText_expense.getText().toString());
        String description = editText_description.getText().toString();
        ExpenseTracker.getInstance().addExpense(value, description, Expense.Category.OTHER);

        finish();
    }
}
