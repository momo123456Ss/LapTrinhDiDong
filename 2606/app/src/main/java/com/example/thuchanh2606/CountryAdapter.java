package com.example.thuchanh2606;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    Context context;
    List<Country> lst;
    LayoutInflater inflater;

    public CountryAdapter(Context appContext, List<Country> lsCountry) {
        this.context = appContext;
        this.lst = lsCountry;
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
        view =inflater.inflate(R.layout.country_layout,null);
        TextView name = view.findViewById(R.id.txtName);
        name.setText(lst.get(i).getName());
        ImageView img = view.findViewById(R.id.img);
        img.setImageResource(lst.get(i).getFlag());
        return view;
    }
}
