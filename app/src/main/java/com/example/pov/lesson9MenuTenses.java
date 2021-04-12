package com.example.pov;

import android.app.ProgressDialog;
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

public class lesson9MenuTenses extends AppCompatActivity {
    Button btnPresent, btnVocabulary,btnFuture,btnPast, btnQualification,btntry;
    public String token, id, name, email;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9_menu_tenses);
        verifyconnection();
        btntry = findViewById(R.id.btnaga);
        btnVocabulary = findViewById(R.id.vocabularyL3);
        btnFuture = findViewById(R.id.btnlessontwofuture);
        btnPresent = findViewById(R.id.btntwoPresent);
        btnPast = findViewById(R.id.btnlessontwopast);
        btnQualification =  findViewById(R.id.btnlessontwoscore);
        btntry.setVisibility(View.INVISIBLE);
        getbtn();
        btntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getbtn();
            }
        });
        SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
        if (valid.getInt("cont15", 0) == 0){
            btnVocabulary.setEnabled(true);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
            //Toast.makeText(this, "Cont: " + valid.getInt("cont", 0), Toast.LENGTH_SHORT).show();
        }else if(valid.getInt("cont15", 0) == 1){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(true);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont15", 0) == 2){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(true);
            btnFuture.setEnabled(false);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont15", 0) == 3){
            btnVocabulary.setEnabled(false);
            btnPresent.setEnabled(false);
            btnPast.setEnabled(false);
            btnFuture.setEnabled(true);
            btnQualification.setEnabled(false);
        }else if(valid.getInt("cont15", 0) == 4){
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
                Intent intent = new Intent(lesson9MenuTenses.this, lesson9MenuActivitiesPresent.class);
                startActivity(intent);

            }
        });
        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson9MenuTenses.this, lesson9MenuActivitiesPast.class);
                startActivity(intent);
            }
        });
        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson9MenuTenses.this, lesson9MenuActivitiesFuture.class);
                startActivity(intent);
            }
        });
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson9MenuTenses.this, lesson9MenuVocabulary.class);
                startActivity(intent);
            }
        });

        btnQualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lesson9MenuTenses.this, lesson9qualificationstudent.class);
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
    public void getbtn() {
        btnQualification.setVisibility(View.INVISIBLE);
        btnFuture.setVisibility(View.INVISIBLE);
        btnPast.setVisibility(View.INVISIBLE);
        btnPresent.setVisibility(View.INVISIBLE);
        btnVocabulary.setVisibility(View.INVISIBLE);
        btntry.setVisibility(View.INVISIBLE);
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            progressDialog = new ProgressDialog(lesson9MenuTenses.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        btnQualification.setVisibility(View.VISIBLE);
                        btnFuture.setVisibility(View.VISIBLE);
                        btnPast.setVisibility(View.VISIBLE);
                        btnPresent.setVisibility(View.VISIBLE);
                        btnVocabulary.setVisibility(View.VISIBLE);
                        btntry.setVisibility(View.INVISIBLE);
                        progressDialog.hide();
                        int cont = 0, cont2 = 0, cont3 = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("9")){
                                    if (u.getString("time_id").equals("4")){
                                        cont++;
                                        //Toast.makeText(menuFutureL1.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("lesson9future", cont);
                                        editor.commit();
                                    }else if (u.getString("time_id").equals("3")){
                                        cont2++;
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("lesson9past", cont2);
                                        editor.commit();
                                    }
                                    else if (u.getString("time_id").equals("2")){
                                        cont3++;
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("lesson9present", cont3);
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
                    btnQualification.setVisibility(View.INVISIBLE);
                    btnFuture.setVisibility(View.INVISIBLE);
                    btnPast.setVisibility(View.INVISIBLE);
                    btnPresent.setVisibility(View.INVISIBLE);
                    btnVocabulary.setVisibility(View.INVISIBLE);
                    btntry.setVisibility(View.VISIBLE);
                    progressDialog.hide();
                    Toast.makeText(lesson9MenuTenses.this, "Wrong data", Toast.LENGTH_SHORT).show();
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