package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson7_menu_activities_present extends AppCompatActivity {
    Button btnFill,btnAnswer, btnListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson7_menu_activities_present);

        btnListen = findViewById(R.id.btnlisten);
        btnFill = findViewById(R.id.btnFill);
        btnAnswer = findViewById(R.id.btnAnswer);

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson7_menu_activities_present.this, lesson7_listenread_present.class);
                startActivity(intent);
            }
        });
        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson7_menu_activities_present.this, lesson7_fillverbs_present.class);
                startActivity(intent);
            }
        });

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson7_menu_activities_present.this, lesson7_answerquestion_present.class);
                startActivity(intent);
            }
        });
    }
}