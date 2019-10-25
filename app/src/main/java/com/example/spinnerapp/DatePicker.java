package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class DatePicker extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
private TextView txtdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        txtdate=findViewById(R.id.tvdate);


        txtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDatePicker();
            }

            private void loadDatePicker() {
                final Calendar c= Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(DatePicker.this, DatePicker.this, year, month , day);
                datePickerDialog.show();

            }
        });
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
    String date="Month/Day/Year : "+ month + "/" + day + "/" + year;
    txtdate.setText(date);
    }
}
