package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson10MenuVocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson10_menu_vocabulary);


        Button btnPreview= findViewById(R.id. btnlessontwoPreview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuVocabulary.this, lesson10AnswerVocabulary.class);
                startActivity(intent);
            }
        });
        Button btnpractice = findViewById(R.id.btnlessontwoPractice);
        btnpractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson10MenuVocabulary.this, lesson10PreviewVocabulary.class);
                startActivity(intent);
            }
        });
    }



    }
    /*public void answer(View view){
        Intent intent = new Intent(lesson10MenuVocabulary.this, lesson10AnswerVocabulary.class);
        startActivity(intent);
    }
    public void practice(View view){
        Intent intent = new Intent(lesson10MenuVocabulary.this, lesson10PreviewVocabulary.class);
        startActivity(intent);
    }*/
