package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson10MenuActivitiesPast extends AppCompatActivity {
    Button btnFill,btnAnswer, btnListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson10_menu_activities_past);

        btnListen = findViewById(R.id.btnlisten);
        btnFill = findViewById(R.id.btnFill);
        btnAnswer = findViewById(R.id.btnAnswer);

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuActivitiesPast.this, lesson10ListenreadPast.class);
                startActivity(intent);
            }
        });
        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuActivitiesPast.this, lesson10FillverbsPast.class);
                startActivity(intent);
            }
        });

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuActivitiesPast.this, lesson10AnswerquestionPast.class);
                startActivity(intent);
            }
        });
    }
}