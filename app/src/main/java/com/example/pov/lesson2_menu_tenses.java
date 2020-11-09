package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson2_menu_tenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_menu_tenses);

        Button btnPresent = findViewById(R.id.btnlessontwoPresent);
        btnPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_menu_activities_present.class);
                startActivity(intent);
            }
        });

        Button btnPast = findViewById(R.id.btnlessontwopast);
        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_tenses.this, lesson2_menu_activities_past.class);
                startActivity(intent);
            }
        });
    }
}