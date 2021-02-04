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

public class lesson4_menu_tenses extends AppCompatActivity {
    Button btnPresent, btnVocabulary, btnPast,btnFuture, btnQualification;
    public String token, id, name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_menu_tenses);
        btnQualification = findViewById(R.id.btnlessontwoscore);
        btnPresent = findViewById(R.id.btntwoPresent);
        btnVocabulary = findViewById(R.id.vocabularyL3);
        btnPast = findViewById(R.id.btnlessontwopast);
        btnFuture = findViewById(R.id.btnlessontwofuture);
        getbtn();
        SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
        if (valid.getInt("cont10", 0) == 0){
            btnVocabulary.setEnabled(true);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
            //Toast.makeText(this, "Cont: " + valid.getInt("cont", 0), Toast.LENGTH_SHORT).show();
        }else if(valid.getInt("cont10", 0) == 1){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(true);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont10", 0) == 2){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(true);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont10", 0) == 3){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(true);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont10", 0) == 4){
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
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_activities_present.class);
                startActivity(intent);
            }
        });

        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_activities_past.class);
                startActivity(intent);
            }
        });

        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_activities_future.class);
                startActivity(intent);
            }
        });
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_menu_vocabulary.class);
                startActivity(intent);
            }
        });
        btnQualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_qualification_student.class);
                startActivity(intent);
            }
        });
        btnQualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson4_menu_tenses.this, lesson4_qualification_student.class);
                startActivity(intent);
            }
        });

    }
    public void getbtn() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0, cont2 = 0, cont3 = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("4")){
                                    if (u.getString("time_id").equals("4")){
                                        cont++;
                                        //Toast.makeText(menuFutureL1.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("lesson4future", cont);
                                        editor.commit();
                                    }else if (u.getString("time_id").equals("3")){
                                        cont2++;
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("lesson4past", cont2);
                                        editor.commit();
                                    }
                                    else if (u.getString("time_id").equals("2")){
                                        cont3++;
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("lesson4present", cont3);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont2", cont);
                                editor.commit();
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(lesson4_menu_tenses.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}