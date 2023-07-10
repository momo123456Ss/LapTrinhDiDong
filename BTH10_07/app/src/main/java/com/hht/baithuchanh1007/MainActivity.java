package com.hht.baithuchanh1007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_name;
    EditText edt_class;
    EditText edt_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_class = (EditText) findViewById(R.id.edt_class);
        edt_age = (EditText) findViewById(R.id.edt_age);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("mySharePref", MODE_PRIVATE);
        String strName = sh.getString("name", "");
        String strClass = sh.getString("class", "");
        int Age = sh.getInt("age", 0);

        edt_name.setText(strName);
        edt_class.setText(strClass);
        edt_age.setText(String.valueOf(Age));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh = getSharedPreferences("mySharePref", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = sh.edit();
        myEditor.putString("name",edt_name.getText().toString());
        myEditor.putString("class",edt_class.getText().toString());
        myEditor.putInt("age",Integer.parseInt(edt_age.getText().toString()));
        myEditor.apply();
    }
}