package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class questionPresentL1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_present_l1);

        Spinner exercise1 = findViewById(R.id.QstPstL11);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.QsPsL11, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        Spinner exercise2 = findViewById(R.id.QstPstL12);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.QsPsL12, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        Spinner exercise3 = findViewById(R.id.QstPstL13);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.QsPsL13, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        Spinner exercise4 = findViewById(R.id.QstPstL14);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.QsPsL14, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        Spinner exercise5 = findViewById(R.id.QstPstL15);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.QsPsL15, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        Spinner exercise6 = findViewById(R.id.QstPstL16);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.QsPsL16, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        Spinner exercise7 = findViewById(R.id.QstPstL17);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.QsPsL17, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        Spinner exercise8 = findViewById(R.id.QstPstL18);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.QsPsL18, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        Spinner exercise9 = findViewById(R.id.QstPstL19);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.QsPsL19, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        Spinner exercise10 = findViewById(R.id.QstPstL110);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.QsPsL110, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);
    }
}