package com.example.pov;

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

public class lesson6_answerquestion_present extends AppCompatActivity {
    String id, token;
    Spinner exercise1,exercise2, exercise3, exercise4,exercise5,exercise6,exercise7,exercise8,exercise9,exercise10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_answerquestion_present);


        exercise1 = findViewById(R.id.QspsL61);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.QsPsL61, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        exercise2 = findViewById(R.id.QspsL62);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.QsPsL62, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        exercise3 = findViewById(R.id.QspsL63);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.QsPsL63, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        exercise4 = findViewById(R.id.QspsL64);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.QsPsL64, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        exercise5 = findViewById(R.id.QspsL65);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.QsPsL65, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        exercise6 = findViewById(R.id.QspsL66);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.QsPsL66, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        exercise7 = findViewById(R.id.QspsL67);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.QsPsL67, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        exercise8 = findViewById(R.id.QspsL68);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.QsPsL68, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        exercise9 = findViewById(R.id.QspsL69);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.QsPsL69, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        exercise10 = findViewById(R.id.QspsL610);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.QsPsL610, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);
    }
    public void qualification(View view){
        int conta = 0;
        if (exercise1.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise2.getSelectedItemPosition() == 3){
            conta++;
        }
        if (exercise3.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise4.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise5.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise6.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise7.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise8.getSelectedItemPosition() == 1){
            conta++;
        }
        if (exercise9.getSelectedItemPosition() == 2){
            conta++;
        }
        if (exercise10.getSelectedItemPosition() == 1){
            conta++;
        }
        final double fin,fina;
        fin = (100 * conta) /10;
        fina = (15 * fin) / 100;
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", id);
            object.put("lesson_id", "6");
            object.put("time_id", "2");
            object.put("activity_id", "3");
            object.put("qualification", String.valueOf(fina));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = getResources().getString(R.string.urlpostqualificationlesson1);
        JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(lesson6_answerquestion_present.this, "Qualification Max : 10.00\nQualification Obt :" + fina,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(lesson6_answerquestion_present.this, lesson6_qualification_present.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(lesson6_answerquestion_present.this, "Wrong with the qualification", Toast.LENGTH_SHORT).show();
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