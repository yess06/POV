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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class questionPastL1 extends AppCompatActivity {
    String id, token;
    Button btnsubmit;
    double fin,fina;
    ProgressDialog progressDialog;
    Spinner exercise1,exercise2, exercise3, exercise4,exercise5,exercise6,exercise7,exercise8,exercise9,exercise10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_past_l1);
        btnsubmit = findViewById(R.id.button13);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualification();
            }
        });
        exercise1 = findViewById(R.id.questPastL11);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.QsPasL11, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise1.setAdapter(adapter);

        exercise2 = findViewById(R.id.questPastL12);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.QsPasL12, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise2.setAdapter(adapter2);

        exercise3 = findViewById(R.id.questPastL13);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.QsPasL13, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise3.setAdapter(adapter3);

        exercise4 = findViewById(R.id.questPastL14);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.QsPasL14, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise4.setAdapter(adapter4);

        exercise5 = findViewById(R.id.questPastL15);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.QsPasL15, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise5.setAdapter(adapter5);

        exercise6 = findViewById(R.id.questPastL16);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.QsPasL16, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise6.setAdapter(adapter6);

        exercise7 = findViewById(R.id.questPastL17);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.QsPasL17, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise7.setAdapter(adapter7);

        exercise8 = findViewById(R.id.questPastL18);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.QsPasL18, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise8.setAdapter(adapter8);

        exercise9 = findViewById(R.id.questPastL19);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.QsPasL19, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise9.setAdapter(adapter9);

        exercise10 = findViewById(R.id.questPastL110);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.QsPasL110, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercise10.setAdapter(adapter10);
    }
     public void qualification(){
         if(exercise1.getSelectedItemPosition() ==0||exercise2.getSelectedItemPosition() ==0||exercise3.getSelectedItemPosition() ==0
                 ||exercise4.getSelectedItemPosition() ==0||exercise5.getSelectedItemPosition() ==0||exercise6.getSelectedItemPosition() == 0
                 ||exercise7.getSelectedItemPosition() ==0){
             Toast.makeText(this, "it remains to select a question", Toast.LENGTH_SHORT).show();
         }else{
             int conta = 0;
             if (exercise1.getSelectedItemPosition() == 3){
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
             if (exercise5.getSelectedItemPosition() == 2){
                 conta++;
             }
             if (exercise6.getSelectedItemPosition() == 1){
                 conta++;
             }
             if (exercise7.getSelectedItemPosition() == 1){
                 conta++;
             }
             if (exercise8.getSelectedItemPosition() == 3){
                 conta++;
             }
             if (exercise9.getSelectedItemPosition() == 1){
                 conta++;
             }
             if (exercise10.getSelectedItemPosition() == 2){
                 conta++;
             }
             fin = 0;
             fina = 0;
             fin = (100 * conta) /10;
             fina = (10 * fin) / 100;
             btnsubmit.setEnabled(false);
             SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
             SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
             token = preferencess.getString("token", "null");
             id = preferences.getString("id", "null");
             RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
             JSONObject object = new JSONObject();
             try {
                 object.put("user_id", id);
                 object.put("lesson_id", "1");
                 object.put("time_id", "3");
                 object.put("activity_id", "3");
                 object.put("qualification", String.valueOf(fina));
             } catch (JSONException e) {
                 e.printStackTrace();
             }
             progressDialog = new ProgressDialog(questionPastL1.this);
             progressDialog.setMessage("Submit...");
             progressDialog.show();
             String url = getResources().getString(R.string.urlpostqualificationlesson1);
             JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                     object, new Response.Listener<JSONObject>() {
                 @Override
                 public void onResponse(JSONObject response) {
                     btnsubmit.setEnabled(true);
                     progressDialog.hide();
                     Toast.makeText(questionPastL1.this, "Qualification Max : 10.00\nQualification Obt :" + fina,Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(questionPastL1.this, qualificationfilltheverb.class);
                     startActivity(intent);
                 }
             }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     btnsubmit.setEnabled(true);
                     progressDialog.hide();
                     Toast.makeText(questionPastL1.this, "Wrong with the qualification", Toast.LENGTH_SHORT).show();
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