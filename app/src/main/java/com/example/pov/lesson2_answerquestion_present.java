package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class lesson2_answerquestion_present extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_answerquestion_present);


        Spinner exercise1 = findViewById(R.id.Qsps1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.QsPsL21, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        Spinner exercise2 = findViewById(R.id.Qsps2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.QsPsL22, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        Spinner exercise3 = findViewById(R.id.Qsps3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.QsPsL23, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        Spinner exercise4 = findViewById(R.id.Qsps4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.QsPsL24, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        Spinner exercise5 = findViewById(R.id.Qsps5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.QsPsL25, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        Spinner exercise6 = findViewById(R.id.Qsps6);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.QsPsL26, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        Spinner exercise7 = findViewById(R.id.Qsps7);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.QsPsL27, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        Spinner exercise8 = findViewById(R.id.Qsps8);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.QsPsL28, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        Spinner exercise9 = findViewById(R.id.Qsps9);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.QsPsL29, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        Spinner exercise10 = findViewById(R.id.Qsps10);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.QsPsL210, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);
    }
}