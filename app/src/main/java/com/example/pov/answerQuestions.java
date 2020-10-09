package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class answerQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_questions);

        Spinner answer1 = findViewById(R.id.answer1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.verbs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answer1.setAdapter(adapter);

        Spinner answer2 = findViewById(R.id.answer2);
        answer2.setAdapter(adapter);

        Spinner answer3 = findViewById(R.id.answer3);
        answer3.setAdapter(adapter);

        Spinner answer4 = findViewById(R.id.answer4);
        answer4.setAdapter(adapter);

        Spinner answer5 = findViewById(R.id.answer5);
        answer5.setAdapter(adapter);

        Spinner answer6 = findViewById(R.id.answer6);
        answer6.setAdapter(adapter);

        Spinner answer7 = findViewById(R.id.answer7);
        answer7.setAdapter(adapter);

        Button score = findViewById(R.id.btnScoreAnsw);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(answerQuestions.this, qualificationanswer.class);
                startActivity(intent);
            }
        });
    }
}
