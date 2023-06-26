package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.appsearch.GetByDocumentIdRequest;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements TextWatcher {
    TextView txtMsg;
    Button btnBegin;
    Button btnExit;
    Number editTxtNumber1;
    Number editTxtNumber2;
    ListView myListView;
    TextView txtMsgListView;

    String[] items = {"Cơ sở lập trình", "Cơ sở dữ liệu",
            "Cấu trúc dữ liệu", "Lập trình hướng đối tượng"};

    TextView txtMsgSpinner;
    Spinner spinner1;
    String[] items2 = {"data-0", "data-1",
            "data-2", "data-3"};

    TextView txtMsgGridView;

    TextView txtMsgAutoComplteTextView;
    AutoCompleteTextView autoCompleteTextView;
    String[] itemsAutoCompleteTextView ={"words","starting","with","set","Setback","Setline","Setoffs","Setouts"
                                            ,"Settled","Settler","Wordless","Wordiness","Adios"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompletetextview);
//        txtMsg = (TextView) findViewById(R.id.txtMsg);
//        btnBegin = (Button) findViewById(R.id.btnBegin);
//        btnExit = (Button) findViewById(R.id.btnExit);
//
//        btnBegin.setOnClickListener(this);
//        btnExit.setOnClickListener(this);

        //ListView--------
//        txtMsgListView = (TextView) findViewById(R.id.txtMsgListView);
//        myListView = (ListView) findViewById(R.id.myListView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
//        myListView.setAdapter(adapter);


//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String text = "Position: " + position + " " + items[position];
//                txtMsgListView.setText(text);
//            }
//        });
        //endListView--------


        //--------------------Spinner
//        txtMsgSpinner = (TextView) findViewById(R.id.txtMsgSpinner);
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
//        spinner1.setAdapter(adapter);
//        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //-------------------EndSpinner

        //GridView--extends Activity
//        txtMsgGridView = findViewById(R.id.txtMsgGridView);
//        GridView gridView = findViewById(R.id.grid);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
//        gridView.setAdapter(adapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                txtMsgGridView.setText(items[position]);
//            }
//        });
        //EndGridView

        //autoCompleteTextView--extends Activity implements TextWatcher
        txtMsgAutoComplteTextView = (TextView) findViewById(R.id.txtMsgAutoCompleteTextView);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.txtautoCompleteTextView);
        autoCompleteTextView.addTextChangedListener(this);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,itemsAutoCompleteTextView));
        //endautoCompleteTextView--extends Activity implements TextWatcher
    }

    //autoCompleteTextView--extends Activity implements TextWatcher
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        txtMsgAutoComplteTextView.setText(autoCompleteTextView.getText());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    //endautoCompleteTextView--extends Activity implements TextWatcher

    //Spinner,extends Activity implements AdapterView.OnItemSelectedListener
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        txtMsgSpinner.setText(items2[position]);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
    //EndSpinner

    //    @Override
//    public void onClick(View v) {
//        if (v.getId() == btnBegin.getId()) {
//            txtMsg.setText("");
//        }
//        if (v.getId() == btnExit.getId()) {
//            txtMsg.setText("2.Exit button");
//        }
//    }
}