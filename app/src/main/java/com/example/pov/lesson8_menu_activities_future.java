package com.example.pov;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class lesson8_menu_activities_future extends AppCompatActivity {
    Button btnFill,btnAnswer, btnListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_menu_activities_future);

        btnListen = findViewById(R.id.btnlisten);
        btnFill = findViewById(R.id.btnFill);
        btnAnswer = findViewById(R.id.btnAnswer);
        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
        if (vali.getInt("lesson8future", 0) == 0){
            btnListen.setEnabled(true);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(false);
        }else if(vali.getInt("lesson8future", 0) == 1){
            btnListen.setEnabled(false);
            btnFill.setEnabled(true);
            btnAnswer.setEnabled(false);
        }else if(vali.getInt("lesson8future", 0) == 2){
            btnListen.setEnabled(false);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(true);
        }else if(vali.getInt("lesson8future", 0) == 3){
            btnListen.setEnabled(false);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(false);
            Toast.makeText(this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson8_menu_activities_future.this, lesson8_listenread_future.class);
                startActivity(intent);
            }
        });

        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson8_menu_activities_future.this, lesson8_fillverbs_future.class);
                startActivity(intent);
            }
        });

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson8_menu_activities_future.this, lesson8_answerquestion_future.class);
                startActivity(intent);
            }
        });
    }
}