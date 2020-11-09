package com.example.pov;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lessons extends AppCompatActivity {

    RecyclerView rvLesson;

    ArrayList<lesson> datos;
    public String token, id, name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferences.getString("token", "null");
        email = preferences.getString("email", "null");

        Button pov1 = findViewById(R.id.btnPOV1);
        pov1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, menuTenses.class);
                startActivity(intent);
            }
        });

        Button pov2 = findViewById(R.id.btnPOV2);
        pov2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, lesson2_menu_tenses.class);
                startActivity(intent);
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.log){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }
    public void logout(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://10.0.0.5:8000/api/auth/logout";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),loginTeacher.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
}

