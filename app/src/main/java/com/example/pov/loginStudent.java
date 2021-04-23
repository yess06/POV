package com.example.pov;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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

public class loginStudent extends AppCompatActivity {

    private EditText txtemail;
    private EditText txtpassword;
    CheckBox pass;
    Button login;
    private String token;
    private TextView resul;
    ProgressDialog progressDialog;
    private static final String TAG= loginStudent.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);
     txtemail = findViewById(R.id.tvEmail);
        txtpassword = findViewById(R.id.tvPassword);
        pass = findViewById(R.id.checkBoxloginstudent);

        pass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    txtpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    txtpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


       login = findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void login(){
        login.setEnabled(false);
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
        progressDialog = new ProgressDialog(loginStudent.this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        String url = getResources().getString(R.string.urllogin);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url, object,
                new
                        com.android.volley.Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                try {
                    login.setEnabled(true);
                    progressDialog.hide();
                    token = response.getString("access_token");
                    SharedPreferences sharedPreferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", token);
                    editor.putString("email", txtemail.getText().toString());
                    editor.putString("qualifi", "0");
                    editor.commit();
                    userlog();
                    Intent intent = new Intent(loginStudent.this, lessons.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),
                                    "successful login", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }catch (JSONException e){
                    throw new RuntimeException(e);
                }
                    }
                }, new com.android.volley.Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError Error){
                progressDialog.hide();
                login.setEnabled(true);
                Toast.makeText(getApplicationContext(),
                        "Wrong data verify your email or password", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
    public void userlog(){
        RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
        JSONObject jsonObject = new JSONObject();
        String url2 = "http://192.168.1.69:8000/api/auth/users";
        JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url2, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
                            SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();

                            JSONArray user = response.getJSONArray("users");
                            for (int i = 0; i <= user.length(); i++) {
                                JSONObject u = user.getJSONObject(i);
                                if (preferencess.getString("email", "null").equals(u.getString("email"))){
                                    editor.putString("id", u.getString("id"));
                                    editor.putString("name", u.getString("name"));
                                    editor.commit();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };
        requestQueue1.add(objectRequest);
    }
}
