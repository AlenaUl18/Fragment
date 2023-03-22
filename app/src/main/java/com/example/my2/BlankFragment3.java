package com.example.my2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BlankFragment3 extends Fragment {
    ArrayList<List1> list1=new ArrayList<>();
    ListView list;
    public BlankFragment3() {
        super(R.layout.fragment_blank3);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_blank3,container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        for (int i=0; i<200; i++)
            list1.add(new List1(R.drawable.movie_player_play_video_svgrepo_com, String.valueOf(i)));
        list = view.findViewById(R.id.Recycle);
        MyListAdapter adapter = new MyListAdapter(getContext(), R.layout.item, list1);
        list.setAdapter(adapter);
        AdapterView.OnItemClickListener ItemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List1 select = (List1) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), select.getText(), Toast.LENGTH_LONG).show();
                Log.i("TAG", select.getText());
            }
        };
        list.setOnItemClickListener(ItemListener);
    }
}