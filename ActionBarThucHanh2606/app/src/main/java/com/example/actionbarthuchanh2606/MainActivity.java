package com.example.actionbarthuchanh2606;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.logobicye);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Home");;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_help:
                Toast.makeText(getApplicationContext(), "Action help", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Action search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                Toast.makeText(getApplicationContext(), "Action refresh", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub_activity1:
                Toast.makeText(getApplicationContext(), "Sub Activity 1", Toast.LENGTH_SHORT).show();
                Intent sub1 = new Intent(this,SubActivity1.class);
                startActivity(sub1);
                return true;
            case R.id.sub_activity2:
                Toast.makeText(getApplicationContext(), "Sub Activity 2", Toast.LENGTH_SHORT).show();
                Intent sub2 = new Intent(this,SubActivity2.class);
                startActivity(sub2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}