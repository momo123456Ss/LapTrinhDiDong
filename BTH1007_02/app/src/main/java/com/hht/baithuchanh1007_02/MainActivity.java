package com.hht.baithuchanh1007_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    TextView txtView1;
    TextView txtView2;
    Button btnSave;
    Button btnLoad;
    EditText edtText;

    String data;
    private String file = "myFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView1 = (TextView) findViewById(R.id.txtView1);
        txtView2 = (TextView) findViewById(R.id.txtView2);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        edtText = (EditText) findViewById(R.id.edtText);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = edtText.getText().toString();
                try {
                    FileOutputStream fOut = openFileOutput(file,MODE_APPEND);
                    fOut.write(data.getBytes(StandardCharsets.UTF_8));
                    fOut.close();
                    Toast.makeText(MainActivity.this,"output File successfully" ,Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"Error" + e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fIn = openFileInput(file);
                    int c;
                    String temp = "";
                    while ((c = fIn.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    fIn.close();
                    txtView2.setText(temp);
                    Toast.makeText(MainActivity.this,"File read successfully",Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"Error" + e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}