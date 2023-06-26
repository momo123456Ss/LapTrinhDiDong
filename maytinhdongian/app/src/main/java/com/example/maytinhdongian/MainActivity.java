package com.example.maytinhdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_clear, btn_ngoac, btn_percent, btn_plus, btn_mul, btn_minus, btn_divine, btn_dot, btn_result, btn_7, btn_8, btn_9, btn_4, btn_5, btn_6, btn_1, btn_2, btn_3, btn_0;
    TextView tvInput, tvResult;
    String process;
    Boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

//bth Tính toàn

        btn_plus = findViewById(R.id.btn_plus);
        btn_divine = findViewById(R.id.btn_divine);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mul = findViewById(R.id.btn_mul);
        btn_result = findViewById(R.id.btn_result);

// btn phu
        btn_dot = findViewById(R.id.btn_dot);
        btn_clear = findViewById(R.id.btn_clear);
        btn_percent = findViewById(R.id.btn_percent);
        btn_ngoac = findViewById(R.id.btn_ngoac);

// TextView tvInput = findViewById(R.id.tv_Input);
        tvInput = findViewById(R.id.tv_input);
        tvResult = findViewById(R.id.tv_result);
        //----
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvResult.setText("");
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "9");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "+");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "x");
            }
        });
        btn_divine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + ":");
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "%");
            }
        });
        btn_ngoac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBracket) {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }
            }
        });
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                process = process.replaceAll("x","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll(":","/");
                Context rhiho = Context.enter();
            }
        });
    }
}