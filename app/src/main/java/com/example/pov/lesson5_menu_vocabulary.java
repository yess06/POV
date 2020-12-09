package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lesson5_menu_vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_menu_vocabulary);
    }
    public void answer_vocabulary(View view){
        Intent intent = new Intent(lesson5_menu_vocabulary.this, lesson5_answer_vocabulary.class);
        startActivity(intent);
    }
    public void practice(View view){
        Intent intent = new Intent(lesson5_menu_vocabulary.this, lesson5_preview_vocabulary.class);
        startActivity(intent);
    }
}