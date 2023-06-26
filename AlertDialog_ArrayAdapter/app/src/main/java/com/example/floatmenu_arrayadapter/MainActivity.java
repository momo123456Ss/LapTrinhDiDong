package com.example.floatmenu_arrayadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtMsg;
    ListView lvwListView;
    ArrayAdapter<String> adapter;
    ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.add("Kỹ thuật lập trình");
        items.add("Cơ sở dữ liệu");
        items.add("Lập trình hướng đối tượng");
        items.add("Mạng máy tính");
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        lvwListView = (ListView) findViewById(R.id.lvwListView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvwListView.setAdapter(adapter);
        registerForContextMenu(lvwListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        String title = items.get(info.position);
        //items[info.position];
        menu.setHeaderTitle(title);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();
        if (id == R.id.delete){
            items.remove(info.position);
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}