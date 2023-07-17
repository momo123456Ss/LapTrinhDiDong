package com.example.bth6_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    EditText edt_id,edt_name,edt_email,edt_phone;
    Button btn_UPD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edt_email = findViewById(R.id.edt_email);
        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_phone = findViewById(R.id.edt_phone);
        btn_UPD = findViewById(R.id.btn_UPD);
        DatabaseHandler db = new DatabaseHandler(this);
        bundleExtras();
        btn_UPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student s = new Student(edt_id.getText().toString(),edt_name.getText().toString(),edt_email.getText().toString(),edt_phone.getText().toString());
                db.updateStudent(s);
                Intent i = new Intent(Update.this, MainActivity.class); startActivity(i);

            }
        });
    }
    private void bundleExtras(){
        Bundle extras = getIntent().getExtras();
        edt_id.setText(extras.getString("STUDENT_ID"));
        edt_name.setText(extras.getString("STUDENT_NAME"));
        edt_email.setText(extras.getString("STUDENT_EMAIL"));
        edt_phone.setText(extras.getString("STUDENT_PHONE"));
    }
}