package com.example.my2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        list = view.findViewById(R.id.List1);
        MyListAdapter adapter = new MyListAdapter(getContext(), R.layout.item, list1);
        list.setAdapter(adapter);
    }
}