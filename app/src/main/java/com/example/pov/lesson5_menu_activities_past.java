package com.example.pov;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class lesson5_menu_activities_past extends AppCompatActivity {
    Button btnFill,btnAnswer, btnListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_menu_activities_past);
        verifyconnection();
        btnAnswer = findViewById(R.id.btnAnswer);
        btnFill = findViewById(R.id.btnFill);
        btnListen = findViewById(R.id.btnlisten);
        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);

        if (vali.getInt("lesson5past", 0) == 0){
            btnListen.setEnabled(true);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(false);
        }else if(vali.getInt("lesson5past", 0) == 1){
            btnListen.setEnabled(false);
            btnFill.setEnabled(true);
            btnAnswer.setEnabled(false);
        }else if(vali.getInt("lesson5past", 0) == 2){
            btnListen.setEnabled(false);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(true);
        }else if(vali.getInt("lesson5past", 0) == 3){
            btnListen.setEnabled(false);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(false);
            Toast.makeText(this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson5_menu_activities_past.this, lesson5_listenread_past.class);
                startActivity(intent);
            }
        });

        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson5_menu_activities_past.this, lesson5_fillverbs_past.class);
                startActivity(intent);
            }
        });

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson5_menu_activities_past.this, lesson5_answerquestion_past.class);
                startActivity(intent);
            }
        });
    }
    public void verifyconnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

        }else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }
}