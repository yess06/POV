package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson3_menu_vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_menu_vocabulary);



        Button vocabulary = findViewById(R.id.    btnlessontwoPreview);
        vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_vocabulary.this, lesson3_answer_vocabulary.class);
                startActivity(intent);
            }
        });

    }
}