package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class Qualification_user_teacher extends AppCompatActivity {
    String id, token, lesson;
    ProgressDialog progressDialog;
    TextView txtqualification, txtname,txtid, txtemail, txtqualifitimes;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification_user_teacher);
        txtqualification = findViewById(R.id.txtqualqual);
        txtid = findViewById(R.id.txtquall);
        txtname = findViewById(R.id.txtnamequali);
        txtemail = findViewById(R.id.txtemailqual);
        txtqualifitimes = findViewById(R.id.txtqualtime);
        bundle = getIntent().getExtras();
        txtid.setText(bundle.getString("id"));
        txtname.setText(bundle.getString("name"));
        txtemail.setText(bundle.getString("email"));
        txtqualification.setText(bundle.getString("qualification"));
        lesson = bundle.getString("id");
        id = bundle.getString("user_id");
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        getqual();
    }
    public void getqual(){

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            progressDialog = new ProgressDialog(Qualification_user_teacher.this);
            progressDialog.setMessage("Submit...");
            progressDialog.show();
            String url = getResources().getString(R.string.urlgetqualificationstimelesson1all);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        progressDialog.hide();
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if(u.getString("user_id").equals(id)){
                                if (u.getString("lesson_id").equals(bundle.getString("id"))){
                                    //Toast.makeText(Qualification_user_teacher.this, u.getString("verbalTense") +": " +u.getString("qualification") + "\n", Toast.LENGTH_LONG).show();
                                    txtqualifitimes.append(u.getString("verbalTense") +": " +u.getString("qualification") + "\n\n");
                                }
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(Qualification_user_teacher.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.hide();
                    Toast.makeText(Qualification_user_teacher.this, "Wrong data", Toast.LENGTH_SHORT).show();
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