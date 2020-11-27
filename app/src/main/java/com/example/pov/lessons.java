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

public class lessons extends AppCompatActivity {
    public String token, id, name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences info = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferences.getString("token", "null");
        email = preferences.getString("email", "null");
        getbtn();
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

        Button pov3 = findViewById(R.id.btnPOV3);
        pov3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, lesson3_menu_tenses.class);
                startActivity(intent);
            }
        });

        Button pov4 = findViewById(R.id.btnPOV4);
        pov4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, lesson4_menu_tenses.class);
                startActivity(intent);
            }
        });


        Button pov5 = findViewById(R.id.btnPOV5);
        pov5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, lesson5_menu_tenses.class);
                startActivity(intent);
            }
        });

        Button pov6 = findViewById(R.id.btnPOV6);
        pov6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, lesson6_menu_tenses.class);
                startActivity(intent);
            }
        });

        Button pov7 = findViewById(R.id.btnPOV7);
        pov7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessons.this, lesson7_menu_tenses.class);
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
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            String url = getResources().getString(R.string.urllogout);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),loginStudent.class);
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
            SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
            final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
            SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = valid.edit();
            editor.clear();
            editor.commit();
            SharedPreferences.Editor editor1 = preferencess.edit();
            editor1.clear();
            editor1.commit();
            SharedPreferences.Editor editor2 = preferences.edit();
            editor2.clear();
            editor2.commit();
        }
        if (id == R.id.myinfo){
            Intent intent = new Intent(lessons.this, Info_Student.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void getbtn() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationstimelesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        int cont2 = 0, cont3 = 0,cont4 =0,cont6 = 0, cont5 = 0, cont7 = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("1")){
                                    cont++;
                                    //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont", cont);
                                    editor.commit();
                                } else if (u.getString("lesson_id").equals("2")){
                                    cont2++;
                                    //Toast.makeText(lessons.this, "cont " + cont2, Toast.LENGTH_SHORT).show();
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont5", cont2);
                                    editor.commit();
                                }else if (u.getString("lesson_id").equals("3")){
                                    cont3++;
                                    //Toast.makeText(lessons.this, "cont " + cont3, Toast.LENGTH_SHORT).show();
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont9", cont3);
                                    editor.commit();
                                }else if (u.getString("lesson_id").equals("4")){
                                    cont4++;
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont10", cont4);
                                    editor.commit();

                                }else if (u.getString("lesson_id").equals("5")){
                                    cont5++;
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont11", cont5);
                                    editor.commit();

                                }else if (u.getString("lesson_id").equals("6")){
                                    cont6++;
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont12", cont6);
                                    editor.commit();
                                }else if (u.getString("lesson_id").equals("7")){
                                    cont7++;
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont13", cont7);
                                    editor.commit();
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn2() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("1")){
                                    if (u.getString("time_id").equals("4")){
                                        cont++;
                                        //Toast.makeText(menuFutureL1.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont2", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont2", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn3() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("1")){
                                    if (u.getString("time_id").equals("3")){
                                        cont++;
                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont3", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont3", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn4() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("1")){
                                    if (u.getString("time_id").equals("2")){
                                        cont++;

                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont4", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont4", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn5() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationstimelesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("2")){
                                    cont++;
                                    //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont5", cont);
                                    editor.commit();
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont5", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn6() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("2")){
                                    if (u.getString("time_id").equals("4")){
                                        cont++;
                                        //Toast.makeText(menuFutureL1.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont6", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont6", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn7() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("2")){
                                    if (u.getString("time_id").equals("3")){
                                        cont++;
                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont7", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont7", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn8() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("2")){
                                    if (u.getString("time_id").equals("2")){
                                        cont++;

                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont8", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont8", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn9() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationstimelesson1);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("3")){
                                    cont++;
                                    //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                    SharedPreferences valid = getSharedPreferences("valid", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = valid.edit();
                                    editor.putInt("cont9", cont);
                                    editor.commit();
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont9", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn10() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("3")){
                                    if (u.getString("time_id").equals("4")){
                                        cont++;
                                        //Toast.makeText(menuFutureL1.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont10", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(lessons.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont10", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn11() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("3")){
                                    if (u.getString("time_id").equals("3")){
                                        cont++;
                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont11", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont11", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getbtn12() {
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        final SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            String url = getResources().getString(R.string.urlgetqualificationsactivity);
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        int cont = 0;
                        JSONArray user = response.getJSONArray("qualifications");
                        for (int i = 0; i <= user.length(); i++) {
                            JSONObject u = user.getJSONObject(i);
                            if (u.getString("user_id").equals(preferences.getString("id", "null"))){
                                if (u.getString("lesson_id").equals("3")){
                                    if (u.getString("time_id").equals("2")){
                                        cont++;

                                        //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                        SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = vali.edit();
                                        editor.putInt("cont12", cont);
                                        editor.commit();
                                    }
                                }

                            }else{
                                cont = 0;
                                //Toast.makeText(menuActivities.this, "cont " + cont, Toast.LENGTH_SHORT).show();
                                SharedPreferences vali = getSharedPreferences("vali", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = vali.edit();
                                editor.putInt("cont12", cont);
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
                    Toast.makeText(lessons.this, "Wrong data", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map getHeaders()throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}

