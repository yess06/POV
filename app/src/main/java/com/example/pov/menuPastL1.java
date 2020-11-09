package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuPastL1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_past_l1);

        Button btnlisten = findViewById(R.id.readPastL1);
        btnlisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuPastL1.this, readingPastL1.class);
                startActivity(intent);
            }
        });

        Button btnQuestion = findViewById(R.id.questionPastL1);
        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuPastL1.this, questionPastL1.class);
                startActivity(intent);
            }
        });

        Button btnFill = findViewById(R.id.filPastL1);
        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuPastL1.this, fillPastL1.class);
                startActivity(intent);
            }
        });
    }
}