package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

public class Studentlist extends AppCompatActivity implements SearchView.OnQueryTextListener {
    ArrayList<Users> listusers;
    RecyclerView recycler;
    ProgressBar progressBar;
    AdapterUser adapterUser;
    String token;
    EditText txtname;
    SearchView svsearch;
    Button buttontry;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        svsearch = findViewById(R.id.svsearch);
        //txtname = findViewById(R.id.txtnamestlist);
        recycler = (RecyclerView) findViewById(R.id.rv);
        listusers = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.pgbr1);
        progressBar.setVisibility(View.INVISIBLE);
        buttontry = findViewById(R.id.btntryagain);
        buttontry.setVisibility(View.INVISIBLE);
        swipeRefreshLayout = findViewById(R.id.swipere);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        getUsers();
        initListener();
        buttontry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUsers();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listusers.clear();
                adapterUser.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(true);
                getUsers();
            }
        });
    }

    public void getUsers() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            swipeRefreshLayout.setRefreshing(false);
            buttontry.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            String url = getResources().getString(R.string.urlgetusers);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    buttontry.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    try {
                        JSONArray user = response.getJSONArray("users");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            listusers.add(new Users(u.getString("id"),u.getString("name"),u.getString("email")));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapterUser = new AdapterUser(listusers);
                    adapterUser.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Studentlist.this, InfoStudent.class);
                            intent.putExtra("id", listusers.get(recycler.getChildAdapterPosition(view)).getId());
                            intent.putExtra("name", listusers.get(recycler.getChildAdapterPosition(view)).getName());
                            intent.putExtra("email", listusers.get(recycler.getChildAdapterPosition(view)).getEmail());
                            startActivity(intent);
                        }
                    });
                    recycler.setAdapter(adapterUser);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.INVISIBLE);
                    buttontry.setVisibility(View.VISIBLE);
                    Toast.makeText(Studentlist.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public  Map getHeaders()throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void initListener(){
        svsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapterUser.filter(newText);
        return false;
    }
}
