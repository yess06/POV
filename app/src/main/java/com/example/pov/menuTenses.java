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

public class menuTenses extends AppCompatActivity {
    String token, id;
    Button btnPresent, btnVocabulary, btnPast,btnFuture, btnQualification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tenses);
        btnQualification = findViewById(R.id.btnScore);
        btnPresent = findViewById(R.id.btnPresent);
        btnVocabulary = findViewById(R.id.btnVocabulary);
        btnPast = findViewById(R.id.btnPastL1);
        btnFuture = findViewById(R.id.btnFutureL1);

        SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
        if (valid.getInt("cont", 0) == 0){
            btnVocabulary.setEnabled(true);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
            Toast.makeText(this, "Cont: " + valid.getInt("cont", 0), Toast.LENGTH_SHORT).show();
        }else if(valid.getInt("cont", 0) == 1){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(true);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont", 0) == 2){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(true);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont", 0) == 3){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(true);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont", 0) == 4){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(true);
            Toast.makeText(this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }
        btnPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuActivities.class);
                startActivity(intent);
            }
        });
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuVocabulary.class);
                startActivity(intent);

            }
        });



        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuPastL1.class);
                startActivity(intent);
            }
        });



        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuFutureL1.class);
                startActivity(intent);
            }
        });
        btnQualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showqualification();
            }
        });
    }
    public void showqualification(){
        Intent intent = new Intent(menuTenses.this, qualificationStudent.class);
        startActivity(intent);
    }
}
