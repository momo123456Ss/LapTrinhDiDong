package com.example.actionbarthuchanh2606;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        getSupportActionBar().hide();
    }
}