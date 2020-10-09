package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class qualificationanswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualificationanswer);


        Button answers = findViewById(R.id.btnAnswersAns);
        answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(qualificationanswer.this, answeransthequestion.class);
                startActivity(intent);
            }
        });

        Button activities = findViewById(R.id.btnActivitiesAnsw);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(qualificationanswer.this, menuActivities.class);
                startActivity(intent);
            }
        });

    }
}