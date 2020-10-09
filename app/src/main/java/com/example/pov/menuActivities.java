package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activities);

        Button btnFill = findViewById(R.id.btnFill);

        btnFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (menuActivities.this, fillVerbs.class);
                startActivity(intent);
            }
        });

     Button btnAnswer = findViewById(R.id.btnAnswer);
     btnAnswer.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(menuActivities.this, answerQuestions.class);
             startActivity(intent);
         }
     });



    }
}
