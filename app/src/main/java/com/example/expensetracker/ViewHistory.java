package com.example.expensetracker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.expensetracker.controler.ExpenseTracker;
import com.example.expensetracker.data.Register;

import java.util.ArrayList;

public class ViewHistory extends AppCompatActivity {

    ArrayList<Register> registers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        ListView view = findViewById(R.id.register_listView);

        view.setAdapter(new CustomAdapter());
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return ExpenseTracker.getInstance().getRegisters().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.activity_view_history_item, null);
            ArrayList<Register> registers = ExpenseTracker.getInstance().getRegisters();

            TextView text_value = convertView.findViewById(R.id.text_value);
            TextView text_description = convertView.findViewById(R.id.text_description);
            Button button = convertView.findViewById(R.id.deleteRegister);

            View.OnClickListener onclicklistener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExpenseTracker.getInstance().deleteRegister(position);
                    finish();
                    startActivity(getIntent());
                }
            };

            button.setOnClickListener(onclicklistener);


            if(registers.get(position).getType() == Register.Type.Expense){
                text_value.setTextColor(Color.parseColor("#ff312d"));
                text_value.setText("- " + registers.get(position).getStringDecimalValue());
            } else {
                text_value.setTextColor(Color.parseColor("#53aa33"));
                text_value.setText(registers.get(position).getStringDecimalValue());
            }

            text_description.setText(registers.get(position).getDescription());
            return convertView;
        }
    }


}
