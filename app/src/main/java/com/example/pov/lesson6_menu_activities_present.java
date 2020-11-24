package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson6_menu_activities_present extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_menu_activities_present);

        Button listen = findViewById(R.id.btnlisten);
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson6_menu_activities_present.this, lesson6_listenread_present.class);
                startActivity(intent);
            }
        });

        Button Fill = findViewById(R.id.btnFill);
        Fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson6_menu_activities_present.this, lesson6_fillverbs_present.class);
                startActivity(intent);
            }
        });

        Button answer = findViewById(R.id.btnAnswer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson6_menu_activities_present.this, lesson6_answerquestion_present.class);
                startActivity(intent);
            }
        });
    }
}