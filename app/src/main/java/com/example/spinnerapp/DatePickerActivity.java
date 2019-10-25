package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {
private TextView tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker2);

        tvTime=findViewById(R.id.tvtime);
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadTime();
            }

            private void loadTime() {
               final Calendar c = Calendar.getInstance();
               final int hour = c.get(Calendar.HOUR);
               int minute = c.get(Calendar.MINUTE);
               int second = c.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog=new TimePickerDialog(DatePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText("Time is : "+ hourOfDay +":"+ minute);
                    }
                },hour,minute,false);
               timePickerDialog.show();

            }
        });
    }
}
