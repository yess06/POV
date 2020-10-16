package com.example.pov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuTeacher extends AppCompatActivity {
    private Button btnregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_teacher);
        btnregister =  findViewById(R.id.btnRegister);
    }
    public void register(View view){
        //Toast.makeText(getBaseContext(), "hola", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MenuTeacher.this, register.class);
        startActivity(intent);
    }
    public void studentlist(View view){
        Intent intent = new Intent(MenuTeacher.this, Studentlist.class);
        startActivity(intent);
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
            Intent intent = new Intent(this,loginTeacher.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}