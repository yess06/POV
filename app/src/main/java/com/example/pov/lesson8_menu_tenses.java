package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson8_menu_tenses extends AppCompatActivity {
    Button btnPresent, btnVocabulary,btnFuture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_menu_tenses);

        btnVocabulary = findViewById(R.id.vocabularyL3);
        btnFuture = findViewById(R.id.btnlessontwofuture);
        btnPresent = findViewById(R.id.btnlessontwoPresent);


        btnPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson8_menu_tenses.this, lesson8_menu_activities_present.class);
                startActivity(intent);
            }
        });
        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson8_menu_tenses.this, lesson8_menu_activities_future.class);
                startActivity(intent);
            }
        });
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson8_menu_tenses.this, lesson8_answer_vocabulary.class);
                startActivity(intent);
            }
        });
    }
}