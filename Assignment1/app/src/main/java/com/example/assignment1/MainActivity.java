package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    WagePayment wagePayment;
    Button calcBtn;
    EditText hourText, wageText;
    TextView paymentView, taxView, netView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = findViewById(R.id.calculateBtn);
        hourText = findViewById(R.id.hoursNum);
        wageText = findViewById(R.id.wageAmount);
        paymentView = findViewById(R.id.paymentTotal);
        taxView = findViewById(R.id.taxTotal);
        netView = findViewById(R.id.netTotal);

        calcBtn.setOnClickListener(v -> {
            if(hourText.getText().toString().isEmpty() && wageText.getText().toString().isEmpty()) {
                wagePayment = new WagePayment(0,0);

                paymentView.setText(String.format("%.2f", wagePayment.CalculateTotalIncome()));
                taxView.setText(String.format("%.2f", wagePayment.CalculateTax()));
                netView.setText(String.format("%.2f", wagePayment.CalculateNetIncome()));

            }
            else if(hourText.getText().toString().isEmpty()) {
                wagePayment = new WagePayment(0, Double.parseDouble(wageText.getText().toString()));
                paymentView.setText(String.format("%.2f", wagePayment.CalculateTotalIncome()));
                taxView.setText(String.format("%.2f", wagePayment.CalculateTax()));
                netView.setText(String.format("%.2f", wagePayment.CalculateNetIncome()));

            }
            else if(wageText.getText().toString().isEmpty()) {
                wagePayment = new WagePayment(Double.parseDouble(hourText.getText().toString()), 0);
                paymentView.setText(String.format("%.2f", wagePayment.CalculateTotalIncome()));
                taxView.setText(String.format("%.2f", wagePayment.CalculateTax()));
                netView.setText(String.format("%.2f", wagePayment.CalculateNetIncome()));
            }
            else {
                wagePayment = new WagePayment(Double.parseDouble(hourText.getText().toString()), Double.parseDouble(wageText.getText().toString()));
                paymentView.setText(String.format("%.2f", wagePayment.CalculateTotalIncome()));
                taxView.setText(String.format("%.2f", wagePayment.CalculateTax()));
                netView.setText(String.format("%.2f", wagePayment.CalculateNetIncome()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.about:
                Intent intent = new Intent(getApplicationContext(), AboutActivity2.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}