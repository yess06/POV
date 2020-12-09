package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lesson8_menu_vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_menu_vocabulary);

    }
    public void answer(View view){
        Intent intent = new Intent(lesson8_menu_vocabulary.this, lesson8_answer_vocabulary.class);
        startActivity(intent);
    }
    public void practice(View view){
        Intent intent = new Intent(lesson8_menu_vocabulary.this, lesson8_preview_vocabulary.class);
        startActivity(intent);
    }
}