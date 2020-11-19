package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson3_menu_activities_past extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_menu_activities_past);


        Button listen = findViewById(R.id.btnlisten);
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_activities_past.this, lesson3_listenread_past.class);
                startActivity(intent);
            }
        });

        Button Fill = findViewById(R.id.btnFill);
        Fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_activities_past.this, lesson3_fillverbs_past.class);
                startActivity(intent);
            }
        });

        Button answer = findViewById(R.id.btnAnswer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson3_menu_activities_past.this, lesson3_answerquestion_past.class);
                startActivity(intent);
            }
        });
    }
}