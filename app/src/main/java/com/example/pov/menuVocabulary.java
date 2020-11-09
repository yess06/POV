package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuVocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_vocabulary);


        Button preview = findViewById(R.id.btnPreview);
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuVocabulary.this, vocabularyL1.class);
                startActivity(intent);
            }
        });

        /*Button practice = findViewById(R.id.btnPractice);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuVocabulary.this, practiceVocabulary.class);
                startActivity(intent);
            }
        });*/

    }
}
