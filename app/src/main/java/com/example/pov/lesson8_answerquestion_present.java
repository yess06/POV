package com.example.pov;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class lesson8_answerquestion_present extends AppCompatActivity {
    Spinner exercise1,exercise2, exercise3, exercise4,exercise5,exercise6,exercise7,exercise8,exercise9,exercise10;
    ProgressDialog progressDialog;
    Button btnsubmit;
    double fin,fina;
    String id, token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_answerquestion_present);
        btnsubmit= findViewById(R.id.button89);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualification();
            }
        });
        exercise1 = findViewById(R.id.QspsL81);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.QsPsL81, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        exercise2 = findViewById(R.id.QspsL82);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.QsPsL82, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        exercise3 = findViewById(R.id.QspsL83);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.QsPsL83, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        exercise4 = findViewById(R.id.QspsL84);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.QsPsL84, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        exercise5 = findViewById(R.id.QspsL85);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.QsPsL85, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        exercise6 = findViewById(R.id.QspsL86);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.QsPsL86, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        exercise7 = findViewById(R.id.QspsL87);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.QsPsL87, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        exercise8 = findViewById(R.id.QspsL88);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.QsPsL88, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        exercise9 = findViewById(R.id.QspsL89);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.QsPsL89, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        exercise10 = findViewById(R.id.QspsL810);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.QsPsL810, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);
    }
    public void qualification(){
        if(exercise1.getSelectedItemPosition() ==0||exercise2.getSelectedItemPosition() ==0||exercise3.getSelectedItemPosition() ==0
                ||exercise4.getSelectedItemPosition() ==0||exercise5.getSelectedItemPosition() ==0||exercise6.getSelectedItemPosition() == 0
                ||exercise7.getSelectedItemPosition() ==0||exercise8.getSelectedItemPosition() ==0||exercise9.getSelectedItemPosition() == 0
                ||exercise10.getSelectedItemPosition() ==0){
            Toast.makeText(this, "it remains to select a question", Toast.LENGTH_SHORT).show();

        }else{
            int conta = 0;
            if (exercise1.getSelectedItemPosition() == 1){
                conta++;
            }
            if (exercise2.getSelectedItemPosition() == 1){
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
            if (exercise9.getSelectedItemPosition() == 1){
                conta++;
            }
            if (exercise10.getSelectedItemPosition() == 1){
                conta++;
            }

            fin = 0;
            fina = 0;
            fin = (100 * conta) /10;
            fina = (15 * fin) / 100;
            btnsubmit.setEnabled(false);
            SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
            SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
            token = preferencess.getString("token", "null");
            id = preferences.getString("id", "null");
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            JSONObject object = new JSONObject();
            try {
                object.put("user_id", id);
                object.put("lesson_id", "8");
                object.put("time_id", "2");
                object.put("activity_id", "3");
                object.put("qualification", String.valueOf(fina));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            progressDialog = new ProgressDialog(lesson8_answerquestion_present.this);
            progressDialog.setMessage("Submit...");
            progressDialog.show();
            String url = getResources().getString(R.string.urlpostqualificationlesson1);
            JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                    object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    btnsubmit.setEnabled(true);
                    progressDialog.hide();
                    Toast.makeText(lesson8_answerquestion_present.this, "Qualification Max : 15.00\nQualification Obt :" + fina,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(lesson8_answerquestion_present.this, lesson8_qualification_present.class);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    btnsubmit.setEnabled(true);
                    progressDialog.hide();
                    Toast.makeText(lesson8_answerquestion_present.this, "Wrong with the qualification", Toast.LENGTH_SHORT).show();
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