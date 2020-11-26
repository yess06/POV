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

public class lesson2_menu_activities_future extends AppCompatActivity {
    Button btnFill,btnAnswer, btnListen;
    String token, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_menu_activities_future);
        btnAnswer = findViewById(R.id.btnAnswer);
        btnFill = findViewById(R.id.btnFill);
        btnListen = findViewById(R.id.btnlisten);
        getbtn();
        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
        if (vali.getInt("cont2", 0) == 0){
            btnListen.setEnabled(true);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(false);
        }else if(vali.getInt("cont2", 0) == 1){
            btnListen.setEnabled(false);
            btnFill.setEnabled(true);
            btnAnswer.setEnabled(false);
        }else if(vali.getInt("cont2", 0) == 2){
            btnListen.setEnabled(false);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(true);
        }else if(vali.getInt("cont2", 0) == 3){
            btnListen.setEnabled(false);
            btnFill.setEnabled(false);
            btnAnswer.setEnabled(false);
            Toast.makeText(this, "Verbal Tense ending", Toast.LENGTH_SHORT).show();
        }
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_future.this, lesson2_listenread_future.class);
                startActivity(intent);
            }
        });


        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_future.this, lesson2_fillverbs_future.class);
                startActivity(intent);
            }
        });


        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson2_menu_activities_future.this, lesson2_answerquestion_future.class);
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
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("2")){
                                    if (u.getString("time_id").equals("4")){
                                        cont++;

                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont6", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont6", cont);
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
                    Toast.makeText(lesson2_menu_activities_future.this, "Wrong data", Toast.LENGTH_SHORT).show();
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