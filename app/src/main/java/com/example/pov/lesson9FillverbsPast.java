package com.example.pov;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class lesson9FillverbsPast extends AppCompatActivity {
    String id, token;
    ProgressDialog progressDialog;
    Spinner exercise1,exercise2, exercise3, exercise4,exercise5,exercise6,exercise7,exercise8,exercise9,exercise10,exercise11,exercise12,exercise13;
    Spinner exercise14, exercise15, exercise16,exercise17,exercise18,exercise19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9_fillverbs_past);

        exercise1 = findViewById(R.id.fillPasL91);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fillpasL91, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        exercise2 = findViewById(R.id.fillPasL92);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fillpasL92, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        exercise3 = findViewById(R.id.fillPasL93);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.fillpasL93, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        exercise4 = findViewById(R.id.fillPasL94);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.fillpasL94, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        exercise5 = findViewById(R.id.fillPasL95);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.fillpasL95, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        exercise6 = findViewById(R.id.fillPasL96);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.fillpasL96, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        exercise7 = findViewById(R.id.fillPasL97);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.fillpasL97, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        exercise8 = findViewById(R.id.fillPasL98);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.fillpasL98, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        exercise9 = findViewById(R.id.fillPasL99);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.fillpasL99, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        exercise10 = findViewById(R.id.fillPasL910);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.fillpasL910, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);

        exercise11 = findViewById(R.id.fillPasL911);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.fillpasL911, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise11.setAdapter(adapter11);

        exercise12 = findViewById(R.id.fillPasL912);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.fillpasL912, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise12.setAdapter(adapter12);

        exercise13 = findViewById(R.id.fillPasL913);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.fillpasL913, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise13.setAdapter(adapter13);

        exercise14 = findViewById(R.id.fillPasL914);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.fillpasL914, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise14.setAdapter(adapter14);

        exercise15 = findViewById(R.id.fillPasL915);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.fillpasL915, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise15.setAdapter(adapter15);

        exercise16 = findViewById(R.id.fillPasL916);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.fillpasL916, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise16.setAdapter(adapter16);

        exercise17 = findViewById(R.id.fillPasL917);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.fillpasL917, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise17.setAdapter(adapter17);

        exercise18 = findViewById(R.id.fillPasL918);
        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.fillpasL918, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise18.setAdapter(adapter18);

        exercise19 = findViewById(R.id.fillPasL919);
        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.fillpasL919, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise19.setAdapter(adapter19);
    }
    public void qualification(View view){
        if(exercise1.getSelectedItemPosition() ==0||exercise2.getSelectedItemPosition() ==0||exercise3.getSelectedItemPosition() ==0
                ||exercise4.getSelectedItemPosition() ==0||exercise5.getSelectedItemPosition() ==0||exercise6.getSelectedItemPosition() == 0
                ||exercise7.getSelectedItemPosition() ==0||exercise8.getSelectedItemPosition() ==0||exercise9.getSelectedItemPosition() == 0
                ||exercise10.getSelectedItemPosition() ==0||exercise11.getSelectedItemPosition() ==0||exercise12.getSelectedItemPosition() == 0
                ||exercise13.getSelectedItemPosition() ==0||exercise14.getSelectedItemPosition() ==0||exercise15.getSelectedItemPosition() ==0
                ||exercise16.getSelectedItemPosition() ==0||exercise17.getSelectedItemPosition() ==0||exercise18.getSelectedItemPosition() ==0
                ||exercise19.getSelectedItemPosition() ==0){
            Toast.makeText(this, "it remains to select a question", Toast.LENGTH_SHORT).show();

        }else{
            int conta = 0;
            if (exercise1.getSelectedItemPosition() == 3){
                conta++;
            }
            if (exercise2.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise3.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise4.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise5.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise6.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise7.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise8.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise9.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise10.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise11.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise12.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise13.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise14.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise15.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise16.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise17.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise18.getSelectedItemPosition() == 2){
                conta++;
            }
            if (exercise19.getSelectedItemPosition() == 2){
                conta++;
            }

            final double fin,fina;
            fin = (100 * conta) /19;
            fina = (10 * fin) / 100;
            SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
            SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
            token = preferencess.getString("token", "null");
            id = preferences.getString("id", "null");
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            JSONObject object = new JSONObject();
            try {
                object.put("user_id", id);
                object.put("lesson_id", "9");
                object.put("time_id", "3");
                object.put("activity_id", "1");
                object.put("qualification", String.valueOf(fina));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            progressDialog = new ProgressDialog(lesson9FillverbsPast.this);
            progressDialog.setMessage("Submit...");
            progressDialog.show();
            String url = getResources().getString(R.string.urlpostqualificationlesson1);
            JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                    object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressDialog.hide();
                    Toast.makeText(lesson9FillverbsPast.this, "Qualification Max : 10.00\nQualification Obt :" + fina, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(lesson9FillverbsPast.this, lesson9MenuTenses.class);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.hide();
                    Toast.makeText(lesson9FillverbsPast.this, "Wrong with the qualification", Toast.LENGTH_SHORT).show();
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

    }
}