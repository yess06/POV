package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson4_menu_tenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_menu_tenses);


        Button Present = findViewById(R.id.btnlessontwoPresent);
        Present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_activities_present.class);
                startActivity(intent);
            }
        });

        Button Past = findViewById(R.id. btnlessontwopast);
        Past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_activities_past.class);
                startActivity(intent);
            }
        });

        Button Future = findViewById(R.id.btnlessontwofuture);
        Future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_activities_future.class);
                startActivity(intent);
            }
        });


        Button vocabulary = findViewById(R.id.vocabularyL3);
        Future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_answer_vocabulary.class);
                startActivity(intent);
            }
        });

    }
}