package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class lesson2_fillverbs_present extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_fillverbs_present);

        Spinner exercise1 = findViewById(R.id.fill1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fillpsL21, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        Spinner exercise2 = findViewById(R.id.fill2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fillpsL22, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        Spinner exercise3 = findViewById(R.id.fill3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.fillpsL23, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        Spinner exercise4 = findViewById(R.id.fill4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.fillpsL24, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        Spinner exercise5 = findViewById(R.id.fill5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.fillpsL25, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        Spinner exercise6 = findViewById(R.id.fill6);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.fillpsL26, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        Spinner exercise7 = findViewById(R.id.fill7);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.fillpsL27, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        Spinner exercise8 = findViewById(R.id.fill8);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.fillpsL28, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        Spinner exercise9 = findViewById(R.id.fill9);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.fillpsL29, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        Spinner exercise10 = findViewById(R.id.fill10);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.fillpsL210, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);

        Spinner exercise11 = findViewById(R.id.fill11);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.fillpsL211, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise11.setAdapter(adapter11);

        Spinner exercise12 = findViewById(R.id.fill12);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.fillpsL212, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise12.setAdapter(adapter12);

        Spinner exercise13 = findViewById(R.id.fill13);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.fillpsL213, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise13.setAdapter(adapter13);

        Spinner exercise14 = findViewById(R.id.fill14);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.fillpsL214, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise14.setAdapter(adapter14);

        Spinner exercise15 = findViewById(R.id.fill15);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.fillpsL215, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise15.setAdapter(adapter15);

        Spinner exercise16 = findViewById(R.id.fill16);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.fillpsL216, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise16.setAdapter(adapter16);

        Spinner exercise17 = findViewById(R.id.fill17);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.fillpsL217, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise17.setAdapter(adapter17);



    }
}