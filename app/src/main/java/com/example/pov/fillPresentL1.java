package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class fillPresentL1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_present_l1);


        Spinner exercise1 = findViewById(R.id.pstL11);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.exercise1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);


        Spinner  exercise2 = findViewById(R.id.pstL12);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.exercise2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        Spinner  exercise3 = findViewById(R.id.pstL13);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.exercise3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        Spinner  exercise4 = findViewById(R.id.pstL14);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.exercise4, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        Spinner  exercise5 = findViewById(R.id.pstL15);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.exercise5, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        Spinner  exercise6 = findViewById(R.id.pstL16);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.exercise6, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        Spinner  exercise7 = findViewById(R.id.pstL17);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.exercise7, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        Spinner  exercise8 = findViewById(R.id.pstL18);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.exercise8, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        Spinner  exercise9 = findViewById(R.id.pstL19);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.exercise9, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        Spinner  exercise10 = findViewById(R.id.pstL110);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.exercise10, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);

        Spinner  exercise11 = findViewById(R.id.pstL111);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.exercise11, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise11.setAdapter(adapter11);

        Spinner  exercise12 = findViewById(R.id.pstL112);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.exercise12, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise12.setAdapter(adapter12);

        Spinner  exercise13 = findViewById(R.id.pstL113);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.exercise13, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise13.setAdapter(adapter13);

        Spinner  exercise14 = findViewById(R.id.pstL114);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.exercise14, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise14.setAdapter(adapter14);

        Spinner  exercise15 = findViewById(R.id.pstL115);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.exercise15, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise15.setAdapter(adapter15);

        Spinner  exercise16 = findViewById(R.id.pstL116);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.exercise16, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise16.setAdapter(adapter16);

        Spinner  exercise17 = findViewById(R.id.pstL117);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.exercise17, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise17.setAdapter(adapter17);

        Spinner  exercise18 = findViewById(R.id.pstL118);
        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.exercise18, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise18.setAdapter(adapter18);

        Spinner  exercise19 = findViewById(R.id.pstL119);
        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.exercise19, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise19.setAdapter(adapter19);

        Spinner  exercise20 = findViewById(R.id.pstL120);
        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(this, R.array.exercise2, android.R.layout.simple_spinner_item);
        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise20.setAdapter(adapter20);

    }
}