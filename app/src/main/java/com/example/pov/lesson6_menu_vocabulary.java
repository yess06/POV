package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lesson6_menu_vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_menu_vocabulary);
    }
    public void vocabulary(View view){
        Intent intent = new Intent(lesson6_menu_vocabulary.this, lesson6_answer_vocabulary.class);
        startActivity(intent);
    }
}