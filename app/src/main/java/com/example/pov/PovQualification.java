package com.example.pov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PovQualification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pov_qualification);
    }
    public void lesson1(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "1");
        startActivity(intent);
    }
    public void lesson2(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "2");
        startActivity(intent);
    }
    public void lesson3(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "3");
        startActivity(intent);
    }
    public void lesson4(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "4");
        startActivity(intent);
    }
    public void lesson5(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "5");
        startActivity(intent);
    }
    public void lesson6(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "6");
        startActivity(intent);
    }
    public void lesson7(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "7");
        startActivity(intent);
    }
    public void lesson8(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "8");
        startActivity(intent);
    }
    public void lesson9(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "9");
        startActivity(intent);
    }
    public void lesson10(View view){
        Intent intent = new Intent(PovQualification.this, QualificationReport.class);
        intent.putExtra("lesson", "10");
        startActivity(intent);
    }
}
