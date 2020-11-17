package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lesson2_menu_activities_future extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_menu_activities_future);

        Button listen = findViewById(R.id.btnlisten);
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_future.this, lesson2_listenread_future.class);
                startActivity(intent);
            }
        });

        Button fill = findViewById(R.id.btnFill);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_future.this, lesson2_fillverbs_future.class);
                startActivity(intent);
            }
        });

        Button answer = findViewById(R.id.btnAnswer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_future.this, lesson2_answerquestion_future.class);
                startActivity(intent);
            }
        });
    }
}