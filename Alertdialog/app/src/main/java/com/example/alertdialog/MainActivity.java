package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtAlert;
    Button btnAlert, btnExit, btnTraditionalList;
    String msg;
    String[] colors_array = {"RED", "GREEN", "BLUE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAlert = (TextView) findViewById(R.id.txtAlert);
        btnAlert = (Button) findViewById(R.id.btnAlert);
        btnExit = findViewById(R.id.btnExit);
        btnTraditionalList = findViewById(R.id.btnTraditionalList);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thoát").setMessage("Bạn muốn thoát chương trình?")
                        .setIcon(R.drawable.ic_exit)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                msg = "YES " + Integer.toString(which);
                                txtAlert.setText(msg);
                            }
                        })

                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                msg = "Cancel " + Integer.toString(which);
                                txtAlert.setText(msg);
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                msg = "No " + Integer.toString(which);
                                txtAlert.setText(msg);
                            }
                        })
                        .create()
                        .show();
            }
        });
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thoát").setMessage("Bạn muốn thoát chương trình?").setIcon(R.drawable.ic_exit)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                msg = "YES " + Integer.toString(which);
                                txtAlert.setText(msg);
                            }
                        }).create()
                        .show();
            }

        });

        ////----
        btnTraditionalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pick Color")
                        .setItems(colors_array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        txtAlert.setTextColor(Color.RED);
                                        break;
                                    case 1:
                                        txtAlert.setTextColor(Color.GREEN);
                                        break;
                                    case 2:
                                        txtAlert.setTextColor(Color.BLUE);
                                        break;
                                }
                            }
                        }).create().show();
            }
        });
    }
}