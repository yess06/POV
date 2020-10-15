package com.example.pov;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity implements dialog.codedialog{

    public String cod;
    public TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = findViewById(R.id.txtexample);
        Button btnTeacher = findViewById(R.id.btnteach);
        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poneDialog();
            }
        });

        Button btnStudent = findViewById(R.id.btnStudent);
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, loginStudent.class);
                 startActivity(intent);
            }
        });



    }

    private void poneDialog() {
        dialog dial = new dialog();
        dial.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void applyText(String code) {
         cod = code;
         tx.setText(cod);
    }
    }

