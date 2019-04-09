package com.example.expensetracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.expensetracker.controler.ExpenseTracker;


public class MainActivity extends AppCompatActivity {
    private ExpenseTracker expenseTracker;
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("tracker", Context.MODE_PRIVATE);

        expenseTracker = ExpenseTracker.getInstance();

        ViewPager viewPager = findViewById(R.id.newsPager);

        viewPager.setAdapter(new CustomPageAdapter());

        updateCurrentTotal();
    }

    public void addExpenseButton(View view){
        Intent addExpenseIntent = new Intent(this, AddExpenseActivity.class);
        startActivity(addExpenseIntent);
    }

    public void addIncomeButton(View view){
        Intent addIncomeIntent = new Intent(this, AddIncomeActivity.class);
        startActivity(addIncomeIntent);
    }

    public void viewHistoryButton(View view){
        Intent viewHistoryActivity = new Intent(this, ViewHistory.class);
        startActivity(viewHistoryActivity);
    }

    private void updateCurrentTotal(){
        TextView total = findViewById(R.id.totalTextView);
        total.setText(expenseTracker.getTotalString());
    }

    @Override
    protected void onResume(){
        super.onResume();
        updateCurrentTotal();
    }

    public static SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }

    public class CustomPageAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getLayoutInflater().inflate(R.layout.tip_view_layout, container, false);
            ImageView displayImage = view.findViewById(R.id.newImage);

            TextView titleText = view.findViewById(R.id.titleText);
            TextView sumary = view.findViewById(R.id.sumaryText);

            View.OnClickListener onclicklistener;

            switch(position){
                case 0:
                    titleText.setText("Cómo empezar a ahorrar dinero, gastar inteligente y \nser feliz con menos");
                    sumary.setText("Muy pocas personas en este planeta pueden presumir de ahorrar dinero. Para la mayoría el dinero parece mantequilla y se nos resbala de la cuenta de banco rápidamente.");
                    displayImage.setImageResource(R.drawable.img1);
                    onclicklistener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://habitualmente.com/ahorrar-dinero/"));
                            startActivity(browserIntent);
                        }
                    };
                    view.setOnClickListener(onclicklistener);
                    break;
                case 1:
                    titleText.setText("8 Maneras de ser un comprador más consciente");
                    sumary.setText("Gastar dinero es de las cosas más fáciles en el mundo. Es rico, es satisfactorio, nos da placer inmediato. Sin embargo, cuando lo hacemos desmedidamente (que es lo que le pasa a la mayoría) las consecuencias emocionales y financieras pueden ser catastróficas y a largo plazo.");
                    displayImage.setImageResource(R.drawable.img2);
                    onclicklistener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plataconplatica.com/8-maneras-comprador-mas-consciente/"));
                            startActivity(browserIntent);
                        }
                    };
                    view.setOnClickListener(onclicklistener);
                    break;
                case 2:
                    titleText.setText("Gasto Consciente: Como ver tus finanzas de un plumazo y tomar control de tu gasto.");
                    sumary.setText("Seamos sinceros. MUY poca gente necesita ahorrar. Hay gente que necesita no gastar mucho porque si no no llegan a fin de mes, pero ahorrar, en el sentido de \"acumular dinero\" no es una necesidad primaria para nadie.");
                    displayImage.setImageResource(R.drawable.img3);
                    onclicklistener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rankia.com/blog/thinkingrich/1039343-gasto-consciente-como-ver-tus-finanzas-plumazo-tomar-control"));
                            startActivity(browserIntent);
                        }
                    };
                    view.setOnClickListener(onclicklistener);break;
            }

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
