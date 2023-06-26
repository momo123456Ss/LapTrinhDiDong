package com.example.baitailop2606;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    TextView edtMsg,edtMsg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        edtMsg = findViewById(R.id.edtMsg);
        edtMsg2 = findViewById(R.id.edtMsg2);

        registerForContextMenu(edtMsg2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            edtMsg.setText("Search...");
            return true;
        } else if (id == R.id.action_share) {
            edtMsg.setText("Share...");
        } else if (id == R.id.action_download) {
            edtMsg.setText("Download...");
            return true;
        } else if (id == R.id.action_about) {
            edtMsg.setText("About...");
            return true;
        } else if (id == R.id.action_settings) {
            edtMsg.setText("Setting...");
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        getMenuInflater().inflate(R.menu.menu_options, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.option_1) {
            Toast.makeText(this, "Option 1 Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.option_2) {
            Toast.makeText(this, "Option 2 Selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);


    }
}