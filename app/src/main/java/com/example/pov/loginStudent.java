package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class loginStudent extends AppCompatActivity {

    private EditText txtemail;
    private EditText txtpassword;

    Button login;
    private String token;
    private TextView resul;
    private static final String TAG= loginStudent.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);
      txtemail = findViewById(R.id.tvEmail);
        txtpassword = findViewById(R.id.tvPassword);


       login = findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void login(){
        String email= txtemail.getText().toString().trim();
        String password = txtpassword.getText().toString().trim();
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try{
            object.put("email", email);
            object.put("password", password);
            object.put("remember_me", true);
        }catch (JSONException e){
            e.printStackTrace();
        }

        String url = getResources().getString(R.string.urlpost);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url, object,
                new
                        com.android.volley.Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                try {
                    token = response.getString("access_token");
                    Intent intent = new Intent(loginStudent.this, lessons.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),
                                    "successful login", Toast.LENGTH_SHORT).show();
                    intent.putExtra("token", token);
                    startActivity(intent);
                }catch (JSONException e){
                    throw new RuntimeException(e);
                }
                    }
                }, new com.android.volley.Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError Error){
                Toast.makeText(getApplicationContext(),
                        "Wrong data verify your email or password", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}
