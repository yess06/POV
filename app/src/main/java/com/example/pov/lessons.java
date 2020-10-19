package com.example.pov;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lessons extends AppCompatActivity {

    RecyclerView rvLesson;
    lessonsAdapter adapter;
    ArrayList<lesson> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        datos = new ArrayList<>();

        rvLesson = (RecyclerView) findViewById(R.id.rvLessons);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayout = layoutManager;
        rvLesson.setLayoutManager(rvLayout);
        RecyclerView.Adapter adaptador = new lessonsAdapter(dataSet(), lessons.this);
        rvLesson.setAdapter(adaptador);
    }

    private ArrayList<lesson>dataSet(){
        datos.add(new lesson("POV 1"));
        datos.add(new lesson("POV 2"));
        datos.add(new lesson("POV 3"));
        datos.add(new lesson("POV 4"));
        datos.add(new lesson("POV 5"));
        datos.add(new lesson("POV 6"));
        datos.add(new lesson("POV 7"));
        datos.add(new lesson("POV 8"));
        datos.add(new lesson("POV 9"));
        datos.add(new lesson("POV 10"));
        return datos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.log){
            Intent intent = new Intent(this,loginStudent.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

