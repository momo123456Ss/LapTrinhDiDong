package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnnews = findViewById(R.id.btnNews);


        btnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView,NewsFragment.class, null)
                                .setReorderingAllowed(true).addToBackStack("name")
                                .commit();
            }
        });
        Button btnsport = findViewById(R.id.btnSport);
        btnsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,SportFragment.class, null)
                        .setReorderingAllowed(true).addToBackStack("name")
                        .commit();
            }
        });
        Button btntest = findViewById(R.id.btnTest);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,TestFragment.class, null)
                        .setReorderingAllowed(true).addToBackStack("name")
                        .commit();
            }
        });
    }
}