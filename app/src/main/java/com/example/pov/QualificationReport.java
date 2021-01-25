package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class QualificationReport extends AppCompatActivity implements SearchView.OnQueryTextListener {
    AdapterQualification adapterQualification;
    ProgressBar progressBar;
    String lesson;
    SearchView svsearch;
    ArrayList<Qualifications> listqual;
    RecyclerView recycler;
    String token;
    TextView txtname;
    Button buttontry;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification_report);
        svsearch = findViewById(R.id.svsearchq);
        txtname = findViewById(R.id.txtnamest);
        Bundle bundle = getIntent().getExtras();
        lesson = bundle.getString("lesson");
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferences.getString("token", "null");
        recycler = findViewById(R.id.rvless);
        listqual = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.pgbr2);
        progressBar.setVisibility(View.INVISIBLE);
        buttontry = findViewById(R.id.btntry);
        buttontry.setVisibility(View.INVISIBLE);
        swipeRefreshLayout = findViewById(R.id.swiperef);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        getQual();
        initListener();
        buttontry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQual();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listqual.clear();
                adapterQualification.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(true);
                getQual();
            }
        });
    }

    private void initListener() {
        svsearch.setOnQueryTextListener(this);
    }


    public void getQual() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            swipeRefreshLayout.setRefreshing(false);
            buttontry.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            String url = getResources().getString(R.string.urlgetqualificationlesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    buttontry.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
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
                    adapterQualification = new AdapterQualification(listqual);
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
                    buttontry.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
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
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapterQualification.filter(newText);
        return false;
    }
}