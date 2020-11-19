package com.example.pov;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class lesson2_menu_tenses extends AppCompatActivity {
    Button btnPast, btnPresent, btnFuture,btnVocabulary, btnQualification;
    String token, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_menu_tenses);
        btnPast = findViewById(R.id.btnlessontwopast);
        btnPresent = findViewById(R.id.btnlessontwoPresent);
        btnFuture = findViewById(R.id.btnlessontwofuture);
        btnVocabulary = findViewById(R.id.btnlessontwoVocabulary);
        btnQualification = findViewById(R.id.btnlessontwoscore);
        SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
        if (valid.getInt("cont5", 0) == 0){
            btnVocabulary.setEnabled(true);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont5", 0) == 1){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(true);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont5", 0) == 2){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(true);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont5", 0) == 3){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(true);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont5", 0) == 4){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(true);
            Toast.makeText(this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }
        btnPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_menu_activities_present.class);
                startActivity(intent);
            }
        });


        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_menu_activities_past.class);
                startActivity(intent);
            }
        });


        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_menu_activities_future.class);
                startActivity(intent);
            }
        });


        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_menu_vocabulary.class);
                startActivity(intent);
            }
        });
        btnQualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showqualification();
            }
        });
    }
    public void showqualification(){
        Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_qualification_student.class);
        startActivity(intent);
    }
}