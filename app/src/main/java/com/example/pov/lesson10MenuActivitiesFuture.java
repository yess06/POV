package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson10MenuActivitiesFuture extends AppCompatActivity {
    Button btnFill,btnAnswer, btnListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson10_menu_activities_future);

        btnListen = findViewById(R.id.btnlisten);
        btnFill = findViewById(R.id.btnFill);
        btnAnswer = findViewById(R.id.btnAnswer);

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuActivitiesFuture.this, lesson10ListenreadFuture.class);
                startActivity(intent);
            }
        });
        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuActivitiesFuture.this, lesson10FillverbsFuture.class);
                startActivity(intent);
            }
        });

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuActivitiesFuture.this, lesson10AnswerquestionFuture.class);
                startActivity(intent);
            }
        });
    }
}