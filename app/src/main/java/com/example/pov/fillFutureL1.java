package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class fillFutureL1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_future_l1);


       Spinner exercise1 = findViewById(R.id.fillFutL11);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fillFut1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        Spinner exercise2 = findViewById(R.id.fillFutL12);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fillFut2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        Spinner exercise3 = findViewById(R.id.fillFutL13);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.fillFut3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        Spinner exercise4 = findViewById(R.id.fillFutL14);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.fillFut4, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        Spinner exercise5 = findViewById(R.id.fillFutL15);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.fillFut5, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        Spinner exercise6 = findViewById(R.id.fillFutL16);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.fillFut6, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        Spinner exercise7 = findViewById(R.id.fillFutL17);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.fillFut7, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        Spinner exercise8 = findViewById(R.id.fillFutL18);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.fillFut8, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        Spinner exercise9 = findViewById(R.id.fillFutL19);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.fillFut9, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        Spinner exercise10 = findViewById(R.id.fillFutL110);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.fillFut10, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);

        Spinner exercise11 = findViewById(R.id.fillFutL111);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.fillFut11, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise11.setAdapter(adapter11);

        Spinner exercise12 = findViewById(R.id.fillFutL12);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.fillFut12, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise12.setAdapter(adapter12);

        Spinner exercise13 = findViewById(R.id.fillFutL113);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.fillFut13, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise13.setAdapter(adapter13);

        Spinner exercise14 = findViewById(R.id.fillFutL114);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.fillFut14, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise14.setAdapter(adapter14);

        Spinner exercise15 = findViewById(R.id.fillFutL115);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.fillFut15, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise15.setAdapter(adapter15);

        Spinner exercise16 = findViewById(R.id.fillFutL116);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.fillFut16, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise16.setAdapter(adapter16);

        Spinner exercise17 = findViewById(R.id.fillFutL117);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.fillFut17, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise17.setAdapter(adapter17);

        Spinner exercise18 = findViewById(R.id.fillFutL118);
        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.fillFut18, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise18.setAdapter(adapter18);

        Spinner exercise19 = findViewById(R.id.fillFutL119);
        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.fillFut19, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise19.setAdapter(adapter19);


    }
}