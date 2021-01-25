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

public class menuFutureL1 extends AppCompatActivity {
    Button btnFill,btnQuestion, btnlisten;
    String token, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_future_l1);
        verifyconnection();
        btnlisten = findViewById(R.id.btnFutureListenL1);
        btnFill = findViewById(R.id.btnFutureFillL1);
        btnQuestion = findViewById(R.id.btnFutureQuestionL1);
        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
        if (vali.getInt("lesson1future", 0) == 0){
            btnlisten.setEnabled(true);
            btnFill.setEnabled(false);
            btnQuestion.setEnabled(false);
        }else if(vali.getInt("lesson1future", 0) == 1){
            btnlisten.setEnabled(false);
            btnFill.setEnabled(true);
            btnQuestion.setEnabled(false);
        }else if(vali.getInt("lesson1future", 0) == 2){
            btnlisten.setEnabled(false);
            btnFill.setEnabled(false);
            btnQuestion.setEnabled(true);
        }else if(vali.getInt("lesson1future", 0) == 3){
            btnlisten.setEnabled(false);
            btnFill.setEnabled(false);
            btnQuestion.setEnabled(false);
            Toast.makeText(this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }

        btnlisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuFutureL1.this, readingFutureL1.class);
                startActivity(intent);
            }
        });


        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuFutureL1.this, fillFutureL1.class);
                startActivity(intent);
            }
        });


        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuFutureL1.this, questionFutureL1.class);
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