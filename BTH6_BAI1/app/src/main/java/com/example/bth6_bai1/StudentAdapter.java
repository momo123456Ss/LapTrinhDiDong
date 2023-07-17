package com.example.bth6_bai1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    Context context;
    List<Student> lst;
    LayoutInflater inflater;
    public StudentAdapter(){

    }
    public StudentAdapter(Context appContext, List<Student> lstStudent) {
        this.context = appContext;
        this.lst = lstStudent;
        this.inflater = LayoutInflater.from(appContext);
    }
    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return lst.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =inflater.inflate(R.layout.student_adapter,null);
        TextView id = view.findViewById(R.id.txt_Id);
        id.setText(lst.get(i).get_id());
        TextView name = view.findViewById(R.id.txtName);
        name.setText(lst.get(i).get_name());
        TextView email = view.findViewById(R.id.txtEmail);
        email.setText(lst.get(i).get_email());
        TextView phone = view.findViewById(R.id.txtPhone);
        phone.setText(lst.get(i).get_phone());
        return view;

    }
}
