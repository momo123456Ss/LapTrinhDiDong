package com.example.bth6_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    Button btn_themsv;
    ArrayList<String> items = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = findViewById(R.id.list_view);
        btn_themsv = findViewById(R.id.btn_themsv);
        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("INSERT DATA WHERE", "Students data....");
        db.addStudent(new Student("1", "A", "A@gmail.com", "0344142375"));
        db.addStudent(new Student("2", "b", "b@gmail.com", "0344142375"));
        db.addStudent(new Student("3", "c", "c@gmail.com", "0344142375"));
        db.addStudent(new Student("4", "d", "d@gmail.com", "0344142375"));
        List<Student> lst = db.getAllStudent();
        for (Student s : lst) {
            String log = "Id " + s.get_id()
                    + ",name: " + s.get_name()
                    + ",email: " + s.get_email()
                    + ",phone: " + s.get_phone();
            Log.d("STUDENT ",log);
        }

        StudentAdapter studentAdapter = new StudentAdapter(this,lst);
        list_view.setAdapter(studentAdapter);
        registerForContextMenu(list_view);

        btn_themsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddStudent.class); startActivity(i);

            }
        });
        db.close();
    }
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.menu, menu);
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
//        String title = items.get(info.position);
//        //items[info.position];
//        menu.setHeaderTitle(title);
//    }
//
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        int id = item.getItemId();
//        if (id == R.id.delete){
//            items.remove(info.position);
//            adapter.notifyDataSetChanged();
//            return true;
//        }
//        return super.onContextItemSelected(item);
//    }
}