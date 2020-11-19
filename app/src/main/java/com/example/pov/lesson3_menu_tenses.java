package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson3_menu_tenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_menu_tenses);





        Button vocabulario = findViewById(R.id.vocabularyL3);
        vocabulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_tenses.this, lesson3_menu_vocabulary.class);
                startActivity(intent);
            }
        });

        Button Present = findViewById(R.id.btnlessontwoPresent);
        Present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_tenses.this, lesson3_menu_activities_present.class);
                startActivity(intent);
            }
        });

        Button Past = findViewById(R.id. btnlessontwopast);
        Past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_tenses.this, lesson3_menu_activities_past.class);
                startActivity(intent);
            }
        });

        Button Future = findViewById(R.id.btnlessontwofuture);
        Future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_tenses.this, lesson3_menu_activities_future.class);
                startActivity(intent);
            }
        });

    }
}