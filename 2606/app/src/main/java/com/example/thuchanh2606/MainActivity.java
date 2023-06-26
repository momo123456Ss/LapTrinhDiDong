package com.example.thuchanh2606;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Country> lsCountry;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.lst);
        getCountryList();
        CountryAdapter adapter = new CountryAdapter(this,lsCountry);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "Possition: " + i +"\n";
                msg += "Quốc gia: " + lsCountry.get(i).getName();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


                builder.setTitle(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "OK!!", Toast.LENGTH_SHORT).show();

                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "CANCEL!!", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
            }
        });

    }
    protected void getCountryList(){
        lsCountry = new ArrayList<Country>();
        lsCountry.add(new Country("India",R.drawable.in));
        lsCountry.add(new Country("China",R.drawable.cn));
        lsCountry.add(new Country("Canada",R.drawable.ca));
        lsCountry.add(new Country("Việt Name",R.drawable.vn));

    }
}