package com.example.pov;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class loginTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);

        Button login = findViewById(R.id.btnLoginT);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(loginTeacher.this, Qualificationreport.class);
                startActivity(intent);*/
            }
        });

    }
}
