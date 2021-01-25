package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class lesson4_menu_vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_menu_vocabulary);

    }

    public void preview(View view){
        Intent intent = new Intent(lesson4_menu_vocabulary.this, lesson4_answer_vocabulary.class);
        startActivity(intent);
    }
    public  void practice(View view){
        Intent intent = new Intent(lesson4_menu_vocabulary.this, lesson4_preview_vocabulary.class);
        startActivity(intent);
    }
}