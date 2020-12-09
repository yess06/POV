package com.example.pov;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.concurrent.TimeUnit;

public class lesson9ListenreadPast extends AppCompatActivity {
    String id, token;
    TextView playerPosition,playerDuration;
    SeekBar seekBar;
    ImageView btPlay,btPause;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9_listenread_past);

        playerPosition = findViewById(R.id.player_position);
        playerDuration = findViewById(R.id.player_duration);
        seekBar = findViewById(R.id.seekBar);
        btPlay = findViewById(R.id.btPlay);
        btPause = findViewById(R.id.bt_pause);

        mediaPlayer = MediaPlayer.create(this, R.raw.lesson9past);
        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);
            }
        };
        int duration = mediaPlayer.getDuration();
        String sDuration = convertFormat(duration);
        playerDuration.setText(sDuration);
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btPlay.setVisibility(View.GONE);
                btPause.setVisibility(View.VISIBLE);
                mediaPlayer.start();
                seekBar.setMax(mediaPlayer.getDuration());
                handler.postDelayed(runnable,0);
            }
        });

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.pause();
                handler.removeCallbacks(runnable);

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
            }
        });



    }

    protected void onDestroy() {

        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
    protected void onPause() {
        super.onPause();
        btPause.setVisibility(View.GONE);
        btPlay.setVisibility(View.VISIBLE);
        mediaPlayer.pause();
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

    }
    public void qualification(View view){
        SharedPreferences preferencess = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        token = preferencess.getString("token", "null");
        id = preferences.getString("id", "null");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("user_id", id);
            object.put("lesson_id", "9");
            object.put("time_id", "3");
            object.put("activity_id", "2");
            object.put("qualification", "10.0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = getResources().getString(R.string.urlpostqualificationlesson1);
        JsonObjectRequest objectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url,
                object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(lesson9ListenreadPast.this, "Qualification Max : 10.00\nQualification Obt : 10.00",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(lesson9ListenreadPast.this, lessons.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(lesson9ListenreadPast.this, "Wrong with the qualification", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };
        requestQueue.add(objectRequest);
    }
}