package com.example.my2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my2.Model.CinemaInfo;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<CinemaInfo> {
    private final LayoutInflater inflater;
    private final List<CinemaInfo>Raspis;
    private int layout;
    public MyListAdapter(Context context,int resource,List<CinemaInfo>Raspis){
        super (context, resource,Raspis);
        this.inflater=LayoutInflater.from(context);
        this.layout=resource;
        this.Raspis=Raspis;
    }
    public View getView(int position,View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);
        ImageView image = view.findViewById(R.id.images);
        TextView text = view.findViewById(R.id.texts);
        CinemaInfo cinemaInfo = Raspis.get(position);
        image.setImageResource(cinemaInfo.getImage());
        text.setText(cinemaInfo.getText());
        return view;
    }
}