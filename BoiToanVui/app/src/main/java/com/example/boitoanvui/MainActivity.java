package com.example.boitoanvui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_Sotuoi1,edt_Sotuoi2;
    Button btn_TinhToan;
    TextView txt_nhanxet1,txt_nhanxet2,txt_nhanxet3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_Sotuoi1 = (EditText) findViewById(R.id.edt_Sotuoi1);
        edt_Sotuoi2 = (EditText) findViewById(R.id.edt_Sotuoi2);
        //
        btn_TinhToan = (Button) findViewById(R.id.btn_TinhToan);
        //
        txt_nhanxet1 = (TextView) findViewById(R.id.txt_nhanxet1);
        txt_nhanxet2 = (TextView) findViewById(R.id.txt_nhanxet2);
        txt_nhanxet3 = (TextView) findViewById(R.id.txt_nhanxet3);

        btn_TinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tuoi1 = Integer.parseInt(edt_Sotuoi1.getText().toString());
                int tuoi2 = Integer.parseInt(edt_Sotuoi2.getText().toString());
                if(tuoi1 < 0 ||tuoi1 > 80){
                    Toast.makeText(MainActivity.this, "Không ổn rồi bạn 1", Toast.LENGTH_SHORT).show();
                }
                else if(tuoi2 <0 ||tuoi2 > 80){
                    Toast.makeText(MainActivity.this, "Không ổn rồi bạn 2", Toast.LENGTH_SHORT).show();
                }
                else if(tuoi2 <10){
                    Toast.makeText(MainActivity.this, "Học đi yêu chi,bạn 2", Toast.LENGTH_SHORT).show();
                }else {
                    int finalResult;
                    finalResult = (tuoi1+ tuoi2)/10;
                    if(finalResult < 10){
                        txt_nhanxet1.setText("Xin chúc mừng");
                        txt_nhanxet2.setText("2 bạn hợp nhau");
                        txt_nhanxet3.setText("bạn là trò đùa");
                    }else {
                        txt_nhanxet1.setText("Xin chia buồn");
                        txt_nhanxet2.setText("2 bạn ko hợp nhau");
                        txt_nhanxet3.setText("bạn là trò đùa");
                    }
                }
            }
        });
    }
}