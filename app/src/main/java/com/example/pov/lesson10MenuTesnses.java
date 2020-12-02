package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson10MenuTesnses extends AppCompatActivity {
    Button btnPresent, btnVocabulary,btnFuture,btnPast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson10_menu_tesnses);

        btnVocabulary = findViewById(R.id.vocabularyL3);
        btnFuture = findViewById(R.id.btnlessontwofuture);
        btnPresent = findViewById(R.id.btnlessontwoPresent);
        btnPast = findViewById(R.id.btnlessontwopast);



        btnPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuTesnses.this, lesson10MenuActivitiesPresent.class);
                startActivity(intent);

            }
        });
        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuTesnses.this, lesson10MenuActivitiesPast.class);
                startActivity(intent);
            }
        });
        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuTesnses.this, lesson10MenuActivitiesFuture.class);
                startActivity(intent);
            }
        });
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuTesnses.this, lesson10AnswerVocabulary.class);
                startActivity(intent);
            }
        });
    }
}