package com.example.pov;

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

public class loginTeacher extends AppCompatActivity {
    private String token, id, na;
    private EditText emailt, passt;
    private Button login;
    CheckBox pass;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);

        login = findViewById(R.id.btnLoginT);
        emailt = findViewById(R.id.emailteacher);
        passt = findViewById(R.id.passteacher);
        pass = findViewById(R.id.checkBoxloginteacher);
        pass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    passt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    passt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }
    public void login(View view){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("email", emailt.getText().toString());
            object.put("password", passt.getText().toString());
            object.put("remember_me", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = getResources().getString(R.string.urllogin);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    token = response.getString("access_token");

                    SharedPreferences sharedPreferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", token);
                    editor.putString("email", emailt.getText().toString());
                    editor.commit();
                    userlog();
                    RequestQueue requestQueue2 = Volley.newRequestQueue(getApplicationContext());
                    JSONObject jsonObject = new JSONObject();
                    String url3 = "http://10.0.0.6:8000/api/auth/roles";
                    JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, url3, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    SharedPreferences preferences3 = getSharedPreferences("info", Context.MODE_PRIVATE);
                                    try {
                                        JSONArray role = response.getJSONArray("roles");
                                        for (int i = 0; i<=role.length();i++){
                                            JSONObject u = role.getJSONObject(i);
                                            if (preferences3.getString("id", "null").equals(u.getString("user_id"))){
                                                if (u.getString("name").equals("Teacher")){
                                                    Toast.makeText(getBaseContext(), "successful login", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(getBaseContext(), MenuTeacher.class);
                                                    startActivity(intent);
                                                }else{
                                                    Toast.makeText(getBaseContext(), "wrong data", Toast.LENGTH_SHORT).show();
                                                }
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
                    requestQueue2.add(request);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), "Wrong data verify your email or password", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
    public void userlog(){
        RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
        JSONObject jsonObject = new JSONObject();
        String url2 = "http://10.0.0.6:8000/api/auth/users";
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
