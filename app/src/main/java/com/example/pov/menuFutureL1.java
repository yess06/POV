package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuFutureL1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_future_l1);

        Button btnlisten = findViewById(R.id.btnFutureListenL1);
        btnlisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuFutureL1.this, readingFutureL1.class);
                startActivity(intent);
            }
        });

        Button btnFill = findViewById(R.id.btnFutureFillL1);
        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuFutureL1.this, fillFutureL1.class);
                startActivity(intent);
            }
        });

        Button btnQuestion = findViewById(R.id.btnFutureQuestionL1);
        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuFutureL1.this, questionFutureL1.class);
                startActivity(intent);
            }
        });
    }
}