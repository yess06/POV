package com.example.pov;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class practiceVocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_vocabulary);

        Spinner vocabulary1 = findViewById(R.id.vocabulary1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.verbs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vocabulary1.setAdapter(adapter);

        Spinner vocabulary2 = findViewById(R.id.vocabulary2);
        vocabulary2.setAdapter(adapter);

        Spinner vocabulary3 = findViewById(R.id.vocabulary3);
        vocabulary3.setAdapter(adapter);

        Spinner vocabulary4 = findViewById(R.id.vocabulary4);
        vocabulary4.setAdapter(adapter);

        Spinner vocabulary5 = findViewById(R.id.vocabulary5);
        vocabulary5.setAdapter(adapter);

        Spinner vocabulary6 = findViewById(R.id.vocabulary6);
        vocabulary6.setAdapter(adapter);
    }
}