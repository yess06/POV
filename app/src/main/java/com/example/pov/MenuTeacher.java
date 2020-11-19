package com.example.pov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
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

public class MenuTeacher extends AppCompatActivity {
    TextView example;
    public String token, id, name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_teacher);
        example = findViewById(R.id.exampletxt);
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferences.getString("token", "null");
        email = preferences.getString("email", "null");
        example.append("Name: " + info.getString("name", "null") +"\n" + "Email: " + preferences.getString("email", "null"));
    }
    public void lessons(View view){
        Intent intent = new Intent(MenuTeacher.this, PovQualification.class);
        startActivity(intent);
    }
    public void register(View view){
        //Toast.makeText(getBaseContext(), "hola", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MenuTeacher.this, register.class);
        startActivity(intent);
    }
    public void studentlist(View view){
        Intent intent = new Intent(MenuTeacher.this, Studentlist.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_teacher,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logoutt){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = getResources().getString(R.string.urllogout);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),loginTeacher.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
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