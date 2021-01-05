package com.example.pov;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class menuPastL1 extends AppCompatActivity {
    Button btnFill,btnQuestion, btnlisten;
    String token, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_past_l1);
        btnlisten = findViewById(R.id.readPastL1);
        btnQuestion = findViewById(R.id.questionPastL1);
        btnFill = findViewById(R.id.filPastL1);
        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
        if (vali.getInt("lesson1past", 0) == 0){
            btnlisten.setEnabled(true);
            btnFill.setEnabled(false);
            btnQuestion.setEnabled(false);
        }else if(vali.getInt("lesson1past", 0) == 1){
            btnlisten.setEnabled(false);
            btnFill.setEnabled(true);
            btnQuestion.setEnabled(false);
        }else if(vali.getInt("lesson1past", 0) == 2){
            btnlisten.setEnabled(false);
            btnFill.setEnabled(false);
            btnQuestion.setEnabled(true);
        }else if(vali.getInt("lesson1past", 0) == 3){
            btnlisten.setEnabled(false);
            btnFill.setEnabled(false);
            btnQuestion.setEnabled(false);
            Toast.makeText(menuPastL1.this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }

        btnlisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuPastL1.this, readingPastL1.class);
                startActivity(intent);
            }
        });


        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuPastL1.this, questionPastL1.class);
                startActivity(intent);
            }
        });


        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuPastL1.this, fillPastL1.class);
                startActivity(intent);
            }
        });
    }

}