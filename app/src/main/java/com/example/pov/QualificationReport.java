package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QualificationReport extends AppCompatActivity {
    String lesson;
    ArrayList<Qualifications> listqual;
    RecyclerView recycler;
    String token;
    TextView txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification_report);
        txtname = findViewById(R.id.txtnamest);
        Bundle bundle = getIntent().getExtras();
        lesson = bundle.getString("lesson");
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferences.getString("token", "null");
        recycler = findViewById(R.id.rvless);
        listqual = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        getQual();
    }
    public void getQual() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationlesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("lesson_id").equals(lesson)){
                                listqual.add(new Qualifications(u.getString("id"),u.getString("name"),u.getString("email"),u.getString("lesson_id"),u.getString("qualification")));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AdapterQualification adapterQualification = new AdapterQualification(listqual);
                    adapterQualification.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(QualificationReport.this, Qualification_user_teacher.class);
                            intent.putExtra("user_id", listqual.get(recycler.getChildAdapterPosition(view)).getUser_id());
                            intent.putExtra("id", listqual.get(recycler.getChildAdapterPosition(view)).getLesson_id());
                            intent.putExtra("name", listqual.get(recycler.getChildAdapterPosition(view)).getName());
                            intent.putExtra("email", listqual.get(recycler.getChildAdapterPosition(view)).getEmail());
                            intent.putExtra("qualification", listqual.get(recycler.getChildAdapterPosition(view)).getQualification());
                            startActivity(intent);
                        }
                    });
                    recycler.setAdapter(adapterQualification);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(QualificationReport.this, "Wrong data", Toast.LENGTH_SHORT).show();
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
    public void seaechqual(View view){
        clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationlesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("lesson_id").equals(lesson)){
                                if (u.getString("name").equals(txtname.getText().toString())){
                                    listqual.add(new Qualifications(u.getString("id"),u.getString("name"),u.getString("email"),u.getString("lesson_id"),u.getString("qualification")));
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AdapterQualification adapterQualification = new AdapterQualification(listqual);
                    adapterQualification.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(QualificationReport.this, Qualification_user_teacher.class);
                            intent.putExtra("user_id", listqual.get(recycler.getChildAdapterPosition(view)).getUser_id());
                            intent.putExtra("id", listqual.get(recycler.getChildAdapterPosition(view)).getLesson_id());
                            intent.putExtra("name", listqual.get(recycler.getChildAdapterPosition(view)).getName());
                            intent.putExtra("email", listqual.get(recycler.getChildAdapterPosition(view)).getEmail());
                            intent.putExtra("qualification", listqual.get(recycler.getChildAdapterPosition(view)).getQualification());
                            startActivity(intent);
                        }
                    });
                    recycler.setAdapter(adapterQualification);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(QualificationReport.this, "Wrong data", Toast.LENGTH_SHORT).show();
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
    public void clear(){
        recycler.removeAllViewsInLayout();
        listqual.clear();
    }
}