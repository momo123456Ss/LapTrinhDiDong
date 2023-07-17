package com.example.bth6_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity {
    EditText edt_id,edt_name,edt_email,edt_phone;
    Button btn_ADD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        edt_email = findViewById(R.id.edt_email);
        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_phone = findViewById(R.id.edt_phone);
        btn_ADD = findViewById(R.id.btn_ADD);
        DatabaseHandler db = new DatabaseHandler(this);
        btn_ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student s = new Student(edt_id.getText().toString(),edt_name.getText().toString(),edt_email.getText().toString(),edt_phone.getText().toString());
                db.addStudent(s);
                Intent i = new Intent(AddStudent.this, MainActivity.class); startActivity(i);
            }
        });
    }
}