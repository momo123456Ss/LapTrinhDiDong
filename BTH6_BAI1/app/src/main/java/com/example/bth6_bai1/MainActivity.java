package com.example.bth6_bai1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);

    ListView list_view;
    Button btn_themsv;
    List<Student> lst ;
    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = findViewById(R.id.list_view);
        btn_themsv = findViewById(R.id.btn_themsv);
        reNew();
//        Log.d("INSERT DATA WHERE", "Students data....");
//        db.addStudent(new Student("1", "A", "A@gmail.com", "0344142375"));
//        db.addStudent(new Student("2", "b", "b@gmail.com", "0344142375"));
//        db.addStudent(new Student("3", "c", "c@gmail.com", "0344142375"));
//        db.addStudent(new Student("4", "d", "d@gmail.com", "0344142375"));
//        for (Student s : lst) {
//            String log = "Id " + s.get_id()
//                    + ",name: " + s.get_name()
//                    + ",email: " + s.get_email()
//                    + ",phone: " + s.get_phone();
//            Log.d("STUDENT ",log);
//        }



        btn_themsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddStudent.class); startActivity(i);

            }
        });
        db.close();
    }
    private void reNew(){
        list_view.setAdapter(null);
        lst = db.getAllStudent();
        studentAdapter = new StudentAdapter(this,lst);
        list_view.setAdapter(studentAdapter);
        registerForContextMenu(list_view);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        String title = String.valueOf(lst.get(info.position).get_name());
        menu.setHeaderTitle(title);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();
        if (id == R.id.delete){
            DatabaseHandler db = new DatabaseHandler(this);
            db.deleteStudent(lst.get(info.position).get_id());
            reNew();
            return true;
        }
        if (id == R.id.update){
            DatabaseHandler db = new DatabaseHandler(this);
            Intent intent = new Intent(MainActivity.this, Update.class);
            intent.putExtra("STUDENT_ID", lst.get(info.position).get_id());
            intent.putExtra("STUDENT_NAME", lst.get(info.position).get_name());
            intent.putExtra("STUDENT_EMAIL", lst.get(info.position).get_email());
            intent.putExtra("STUDENT_PHONE", lst.get(info.position).get_phone());
            startActivity(intent);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}