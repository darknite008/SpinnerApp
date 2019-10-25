package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinCountry,spinPlayer;
    private AutoCompleteTextView autocompletetv;
    private Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.date);
        btn1=findViewById(R.id.time);
        spinCountry=findViewById(R.id.spincountry);
        spinPlayer=findViewById(R.id.spinPlayer);
        autocompletetv=findViewById(R.id.autoCompleteTextView);

        String countries[]={"Nepal","India"};
        final String Nepali[]={"paras","sandip"};
        final String Indianplayer[]={"sachin","kholi"};
        String AutoText[]={"Samyam","Ram","Hari","Sun","Om","Raja","Abhi","Nares","Manis","Rohit","Sanjeeb","Pranis"};

        ArrayAdapter<String> stringArrayAdapter= new ArrayAdapter<>(
                this ,android.R.layout.select_dialog_item,AutoText);
        autocompletetv.setAdapter(stringArrayAdapter);
        autocompletetv.setThreshold(1);

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,countries);
        spinCountry.setAdapter(adapter);

        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinCountry.getSelectedItem().toString().equals("Nepal")){


                    ArrayAdapter arrayAdapter= new ArrayAdapter<>(
                            MainActivity.this,android.R.layout.simple_list_item_1,Nepali);
                    spinPlayer.setAdapter(arrayAdapter);
                }else{
                    ArrayAdapter arrayAdapter= new ArrayAdapter<>(
                            MainActivity.this,android.R.layout.simple_list_item_1,Indianplayer);
                    spinPlayer.setAdapter(arrayAdapter);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatePicker.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DatePickerActivity.class);
                startActivity(intent);
            }
        });
}}
