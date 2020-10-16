package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Studentlist extends AppCompatActivity {
    ArrayList<Users> listusers;
    RecyclerView recycler;
    String token;
    EditText txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        txtname = findViewById(R.id.txtnamestlist);
        recycler = (RecyclerView) findViewById(R.id.rv);
        listusers = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        getUsers();
    }

    public void getUsers() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetusers);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray user = response.getJSONArray("users");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            listusers.add(new Users(u.getString("id"),u.getString("name"),u.getString("email")));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AdapterUser adapterUser = new AdapterUser(listusers);
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
    public void search(View view){
        clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetusers);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray user = response.getJSONArray("users");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (txtname.getText().toString().equals(u.getString("name"))){
                                listusers.add(new Users(u.getString("id"),u.getString("name"),u.getString("email")));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AdapterUser adapterUser = new AdapterUser(listusers);
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
    public void clear(){
        recycler.removeAllViewsInLayout();
        listusers.clear();
    }
}
