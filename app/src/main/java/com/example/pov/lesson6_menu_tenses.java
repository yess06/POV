package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson6_menu_tenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_menu_tenses);

        Button Present = findViewById(R.id.btnlessontwoPresent);
        Present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson6_menu_tenses.this, lesson6_menu_activities_present.class);
                startActivity(intent);
            }
        });


        Button Future = findViewById(R.id.btnlessontwofuture);
        Future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson6_menu_tenses.this, lesson6_menu_activities_future.class);
                startActivity(intent);
            }
        });


        Button vocabulary = findViewById(R.id.vocabularyL3);
        vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson6_menu_tenses.this, lesson6_answer_vocabulary.class);
                startActivity(intent);
            }
        });
    }
}