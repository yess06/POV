package com.example.pov;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
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

public class qualificationStudent extends AppCompatActivity {
    String id, token;
    ProgressDialog progressDialog;
    TextView txtqualification, txtname,txtid, txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification_student);
        txtqualification = findViewById(R.id.txtqualqual);
        txtid = findViewById(R.id.txtquall);
        txtname = findViewById(R.id.txtnamequali);
        txtemail = findViewById(R.id.txtemailqual);
        showqualifiactionlesson1();
    }
    public void showqualifiactionlesson1(){
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            progressDialog = new ProgressDialog(qualificationStudent.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            String url = getResources().getString(R.string.urlgetqualificationlesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressDialog.hide();
                    try {
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("1")) {
                                    txtqualification.setText( u.getString("qualification"));
                                    txtid.setText(u.getString("lesson_id"));
                                    txtname.setText(u.getString("name"));
                                    txtemail.setText(u.getString("email"));
                                }
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //Toast.makeText(qualificationStudent.this, "qual: " + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.hide();
                    Toast.makeText(qualificationStudent.this, "Wrong data", Toast.LENGTH_SHORT).show();
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
