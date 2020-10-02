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
    }
}
