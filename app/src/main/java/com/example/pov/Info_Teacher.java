package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Info_Teacher extends AppCompatActivity {
    EditText txtname, txtemail, txtpass,txtpassconfirmation;
    String id, token,email,name;
    ProgressDialog progressDialog;
    Button btnpass, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__teacher);
        btnpass = findViewById(R.id.button9);
        info = findViewById(R.id.button);
        txtname = findViewById(R.id.txtinfoname);
        txtemail = findViewById(R.id.txtinfoemail);
        txtpass = findViewById(R.id.txtinfopass);
        txtpassconfirmation = findViewById(R.id.txtpassconfirm);
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferences.getString("token", "null");
        email = preferences.getString("email", "null");
        id = info.getString("id", "null");
        name = info.getString("name", "null");
        txtname.setText(name);
        txtemail.setText(email);
    }
    public void updateuser(View view){
        info.setEnabled(false);
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        String name = txtname.getText().toString();
        String email = txtemail.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("name", name);
            object.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog = new ProgressDialog(Info_Teacher.this);
        progressDialog.setMessage("Update...");
        progressDialog.show();
        String url = getResources().getString(R.string.urlputinfouser)+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.PUT, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.hide();
                info.setEnabled(true);
                Toast.makeText(Info_Teacher.this, "Successful updated", Toast.LENGTH_SHORT).show();
                SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = info.edit();
                editor.putString("name", txtname.getText().toString());
                editor.commit();
                SharedPreferences preferences1 = getSharedPreferences("credentials", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = preferences1.edit();
                editor1.putString("email", txtemail.getText().toString());
                editor.commit();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                info.setEnabled(true);
                Toast.makeText(Info_Teacher.this, "wrong with the update", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map getHeaders()throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
    public void updatepass(View view){
        btnpass.setEnabled(false);
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        String pass = txtpass.getText().toString();
        String repp = txtpassconfirmation.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("password", pass);
            object.put("password_confirmation", repp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog = new ProgressDialog(Info_Teacher.this);
        progressDialog.setMessage("Update...");
        progressDialog.show();
        String url = getResources().getString(R.string.urlputpassword)+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.PUT,
                url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.hide();
                btnpass.setEnabled(true);
                Toast.makeText(Info_Teacher.this, "Successful updated", Toast.LENGTH_SHORT).show();
                txtpass.setText("");
                txtpassconfirmation.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                btnpass.setEnabled(true);
                Toast.makeText(Info_Teacher.this, "wrong with the update", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map getHeaders()throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
}