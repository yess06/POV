package com.example.pov;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InfoStudent extends AppCompatActivity {
    EditText txtname, txtemail, txtpass,txtpassconfirmation;
    String id, token;
    Button btnpass, btninfo;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);
        btninfo = findViewById(R.id.button);
        btnpass = findViewById(R.id.button9);
        txtname = findViewById(R.id.txtinfoname);
        txtemail = findViewById(R.id.txtinfoemail);
        txtpass = findViewById(R.id.txtinfopass);
        txtpassconfirmation = findViewById(R.id.txtpassconfirm);
        Bundle bundle = this.getIntent().getExtras();
        txtname.setText(bundle.getString("name"));
        txtemail.setText(bundle.getString("email"));
        id = bundle.getString("id");
    }
    public void updateuser(View view){
        btninfo.setEnabled(false);
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
        progressDialog = new ProgressDialog(InfoStudent.this);
        progressDialog.setMessage("Update...");
        progressDialog.show();
        String url = getResources().getString(R.string.urlputinfouser)+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.PUT, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.hide();
                btninfo.setEnabled(true);
                Toast.makeText(InfoStudent.this, "Successful updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                btninfo.setEnabled(true);
                Toast.makeText(InfoStudent.this, "wrong with the update", Toast.LENGTH_SHORT).show();
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
        progressDialog = new ProgressDialog(InfoStudent.this);
        progressDialog.setMessage("Update...");
        progressDialog.show();
        String url = getResources().getString(R.string.urlputpassword)+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.PUT,
                url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.hide();
                btnpass.setEnabled(true);
                Toast.makeText(InfoStudent.this, "Successful updated", Toast.LENGTH_SHORT).show();
                txtpass.setText("");
                txtpassconfirmation.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                btnpass.setEnabled(true);
                progressDialog.hide();
                Toast.makeText(InfoStudent.this, "wrong with the update", Toast.LENGTH_SHORT).show();
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
    public void deleteUser(){
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        progressDialog = new ProgressDialog(InfoStudent.this);
        progressDialog.setMessage("Delete...");
        progressDialog.show();
        String url = getResources().getString(R.string.urldeleteuser)+id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.hide();
                Toast.makeText(InfoStudent.this, "Successful delete", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), Studentlist.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(InfoStudent.this, "wrong with the delete", Toast.LENGTH_SHORT).show();
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.infst,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.deleteuser){
            deleteUser();
        }
        return super.onOptionsItemSelected(item);
    }


}
