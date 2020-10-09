package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class qualificationfilltheverb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualificationfilltheverb);

        Button activities = findViewById(R.id.btnActivitiesFill);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(qualificationfilltheverb.this, menuActivities.class);
                startActivity(intent);
            }
        });

        Button answers = findViewById(R.id.btnAnswersFill);
        answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(qualificationfilltheverb.this, answerfilltheverbs.class);
                startActivity(intent);
            }
        });
    }
}