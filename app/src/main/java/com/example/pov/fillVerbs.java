package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class fillVerbs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_verbs);


        Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.verbs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);

        Spinner spinner3 = findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter);

        Spinner spinner4 = findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter);

        Spinner spinner5 = findViewById(R.id.spinner5);
        spinner5.setAdapter(adapter);

        Spinner spinner6 = findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter);

        Spinner spinner7 = findViewById(R.id.spinner7);
        spinner7.setAdapter(adapter);

        Button scoreFill = findViewById(R.id.btnAnswersAns);

        scoreFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fillVerbs.this, qualificationfilltheverb.class);
                startActivity(intent);
            }
        });


    }
}
