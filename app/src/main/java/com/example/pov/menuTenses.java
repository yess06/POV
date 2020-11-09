package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuTenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tenses);


        Button btnPresent = findViewById(R.id.btnPresent);
        btnPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuActivities.class);
                startActivity(intent);
            }
        });

        Button btnVocabulary = findViewById(R.id.btnVocabulary);
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuVocabulary.class);
                startActivity(intent);

            }
        });


        Button btnPast = findViewById(R.id.btnPastL1);
        btnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuPastL1.class);
                startActivity(intent);
            }
        });


        Button btnFuture = findViewById(R.id.btnFutureL1);
        btnFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuTenses.this, menuFutureL1.class);
                startActivity(intent);
            }
        });





    }
}
