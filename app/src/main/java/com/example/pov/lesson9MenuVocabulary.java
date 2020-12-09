package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class lesson9MenuVocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9_menu_vocabulary);
    }
    public void answer(View view){
        Intent intent = new Intent(lesson9MenuVocabulary.this, lesson9AnswerVocabulary.class);
        startActivity(intent);
    }
    public void practice(View view){
        Intent intent = new Intent(lesson9MenuVocabulary.this, lesson9PreviewVocabulary.class);
        startActivity(intent);
    }
}