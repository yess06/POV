package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

public class lesson3_qualification_present extends AppCompatActivity {
    String id, token;
    ProgressDialog progressDialog, progressDialog2;
    TextView score;
    Button btnsumbit, btntry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_qualification_present);
        score = findViewById(R.id.scorequal11);
        btnsumbit = findViewById(R.id.btnlessontwoactivities);
        btntry = findViewById(R.id.button81);
        btntry.setVisibility(View.INVISIBLE);
        btnsumbit.setVisibility(View.INVISIBLE);
        btnsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifitime();
            }
        });
        btntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quallificationtime();
            }
        });
        quallificationtime();
    }
    public void qualifitime(){
        btnsumbit.setEnabled(false);
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", id);
            object.put("lesson_id", "3");
            object.put("time_id", "2");
            object.put("qualification", score.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog = new ProgressDialog(lesson3_qualification_present.this);
        progressDialog.setMessage("Submit...");
        progressDialog.show();
        String url = getResources().getString(R.string.urlpostqualificationtimelesson1);
        JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                btnsumbit.setEnabled(true);
                progressDialog.hide();
                //Toast.makeText(vocabularyL1.this, "Qualification added", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(lesson3_qualification_present.this, lessons.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                btnsumbit.setEnabled(true);
                progressDialog.hide();
                //Toast.makeText(vocabularyL1.this, "Wrong with the qualification", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };
        requestQueue.add(objectRequest);
    }
    public void quallificationtime(){
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            progressDialog2 = new ProgressDialog(lesson3_qualification_present.this);
            progressDialog2.setMessage("Loading...");
            progressDialog2.show();
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    btntry.setVisibility(View.INVISIBLE);
                    btnsumbit.setVisibility(View.VISIBLE);
                    try {
                        progressDialog2.hide();
                        double qualification;
                        qualification = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("3")) {
                                    if (u.getString("time_id").equals("2")) {
                                        qualification = qualification + Double.parseDouble(u.getString("qualification"));
                                        score.setText(String.valueOf(qualification));
                                    }
                                }
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    btntry.setVisibility(View.VISIBLE);
                    btnsumbit.setVisibility(View.INVISIBLE);
                    progressDialog2.hide();
                    Toast.makeText(lesson3_qualification_present.this, "Wrong data", Toast.LENGTH_SHORT).show();
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
            //Intent intent = new Intent(qualificationanswer.this, qualificationanswer.class);
            //startActivity(intent);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}