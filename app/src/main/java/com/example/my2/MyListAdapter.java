package com.example.my2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<List1> {
    private final LayoutInflater inflater;
    private final List<List1>Raspis;
    private int layout;
    public MyListAdapter(Context context,int resource,List<List1>Raspis){
        super (context, resource,Raspis);
        this.inflater=LayoutInflater.from(context);
        this.layout=resource;
        this.Raspis=Raspis;
    }
    public View getView(int position,View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);
        ImageView image = view.findViewById(R.id.images);
        TextView text = view.findViewById(R.id.texts);
        List1 list1 = Raspis.get(position);
        image.setImageResource(list1.getImage());
        text.setText(list1.getText());
        return view;
    }
}