package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class fillPastL1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_past_l1);

        Spinner exercise1 = findViewById(R.id.fillPastL11);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fillpast1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        Spinner exercise2 = findViewById(R.id.fillPastL12);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fillpast2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        Spinner exercise3 = findViewById(R.id.fillPastL13);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.fillpast3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        Spinner exercise4 = findViewById(R.id.fillPastL14);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.fillpast4, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        Spinner exercise5 = findViewById(R.id.fillPastL15);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.fillpast5, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        Spinner exercise6 = findViewById(R.id.fillPastL16);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.fillpast6, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        Spinner exercise7 = findViewById(R.id.fillPastL17);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.fillpast7, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        Spinner exercise8 = findViewById(R.id.fillPastL18);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.fillpast8, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        Spinner exercise9 = findViewById(R.id.fillPastL19);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.fillpast9, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        Spinner exercise10 = findViewById(R.id.fillPastL110);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.fillpast10, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);

        Spinner exercise11 = findViewById(R.id.fillPastL111);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.fillpast11, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise11.setAdapter(adapter11);

        Spinner exercise12 = findViewById(R.id.fillPastL112);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.fillpast12, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise12.setAdapter(adapter12);

        Spinner exercise13 = findViewById(R.id.fillPastL113);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.fillpast13, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise13.setAdapter(adapter13);

        Spinner exercise14 = findViewById(R.id.fillPastL114);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.fillpast14, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise14.setAdapter(adapter14);

        Spinner exercise15 = findViewById(R.id.fillPastL115);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.fillpast15, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise15.setAdapter(adapter15);

        Spinner exercise16 = findViewById(R.id.fillPastL116);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.fillpast16, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise16.setAdapter(adapter16);

        Spinner exercise17 = findViewById(R.id.fillPastL117);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.fillpast17, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise17.setAdapter(adapter17);

        Spinner exercise18 = findViewById(R.id.fillPastL118);
        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.fillpast18, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise18.setAdapter(adapter18);

        Spinner exercise19 = findViewById(R.id.fillPastL119);
        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.fillpast19, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise19.setAdapter(adapter19);
    }
}