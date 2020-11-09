package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson2_menu_activities_past extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_menu_activities_past);

        Button answer = findViewById(R.id.btnAnswerPresent);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_past.this, lesson2_answerquestion_past.class);
                startActivity(intent);
            }
        });

        Button fill = findViewById(R.id.btnFill);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_past.this, lesson2_fillverbs_past.class);
                startActivity(intent);
            }
        });
    }
}