package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {
    EditText txtemail, txtname, txtpass, txtreppass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtname = findViewById(R.id.nameuser);
        txtemail = findViewById(R.id.emailuser);
        txtpass = findViewById(R.id.passuser);
        txtreppass = findViewById(R.id.reppassuser);
    }

    public void register(View view){
        String name = txtname.getText().toString();
        String email = txtemail.getText().toString();
        String pass = txtpass.getText().toString();
        String repp = txtreppass.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("name", name);
            object.put("email", email);
            object.put("password", pass);
            object.put("password_confirmation", repp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = getResources().getString(R.string.urlregister);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST,
                url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    Toast.makeText(register.this, "Successful register", Toast.LENGTH_SHORT).show();
                    txtname.setText("");
                    txtemail.setText("");
                    txtpass.setText("");
                    txtreppass.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}