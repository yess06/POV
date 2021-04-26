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

public class lesson4_qualification_lesson extends AppCompatActivity {
    String id, token;
    ProgressDialog progressDialog, progressDialog2;
    Button btnsubmit, btntry;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_qualification_lesson);
        btntry = findViewById(R.id.button106);
        btnsubmit = findViewById(R.id.btnlessontwoactivities);
        btntry.setVisibility(View.INVISIBLE);
        btnsubmit.setVisibility(View.INVISIBLE);
        score = findViewById(R.id.scorequal13);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifilesson();
            }
        });
        btntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quallificationlesson();
            }
        });
        quallificationlesson();
    }
    public void qualifilesson(){
        btnsubmit.setEnabled(false);
        SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", id);
            object.put("lesson_id", "4");
            object.put("qualification", score.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog = new ProgressDialog(lesson4_qualification_lesson.this);
        progressDialog.setMessage("Submit...");
        progressDialog.show();
        String url = getResources().getString(R.string.urlpostqualificationlessonlesson1);
        JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                btnsubmit.setEnabled(true);
                progressDialog.hide();
                //Toast.makeText(vocabularyL1.this, "Qualification added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(lesson4_qualification_lesson.this, lessons.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                btnsubmit.setEnabled(true);
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
    public void quallificationlesson(){
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            progressDialog2 = new ProgressDialog(lesson4_qualification_lesson.this);
            progressDialog2.setMessage("Loading...");
            progressDialog2.show();
            String url = getResources().getString(R.string.urlgetqualificationstimelesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        btntry.setVisibility(View.INVISIBLE);
                        btnsubmit.setVisibility(View.VISIBLE);
                        progressDialog2.hide();
                        double qualification;
                        qualification = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("4")) {
                                    qualification += Double.parseDouble(u.getString("qualification"));
                                    score.setText(String.valueOf(qualification));
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
                    btnsubmit.setVisibility(View.INVISIBLE);
                    progressDialog2.hide();
                    Toast.makeText(lesson4_qualification_lesson.this, "Wrong data", Toast.LENGTH_SHORT).show();
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