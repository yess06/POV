package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoStudent extends AppCompatActivity {
    EditText txtname, txtemail, txtpass,txtpassconfirmation;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);
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
        String url = "http://10.0.0.5:8000/api/auth/updateuser/"+id+"/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.PUT, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(InfoStudent.this, "Successful updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InfoStudent.this, "wrong with the update", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
    public void updatepass(View view){
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
        String url = "http://10.0.0.5:8000/api/auth/updatepass/"+id+"/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.PUT,
                url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(InfoStudent.this, "Successful updated", Toast.LENGTH_SHORT).show();
                txtpass.setText("");
                txtpassconfirmation.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InfoStudent.this, "wrong with the update", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
    public void deleteUser(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        String url = "http://10.0.0.5:8000/api/auth/deleteuser/"+id+"/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(InfoStudent.this, "Successful delete", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), Studentlist.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InfoStudent.this, "wrong with the delete", Toast.LENGTH_SHORT).show();
            }
        });
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
