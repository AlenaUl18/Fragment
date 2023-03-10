package com.example.my2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class BlankFragment4 extends Fragment {
    ArrayList<List1> list1 = new ArrayList<List1>();
    public BlankFragment4() {
        super(R.layout.fragment_blank4);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_blank4,container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i=0; i<200; i++)
            list1.add(new List1(R.drawable.movie_player_play_video_svgrepo_com, String.valueOf(i)));
        RecyclerView list = view.findViewById(R.id.Recycle);
        RecycleAdapter.OnClickListener clickListener = new RecycleAdapter.OnClickListener() {
            @Override
            public void OnClick(List1 list, int position) {
                Toast.makeText(getContext(), list.getText(), Toast.LENGTH_LONG).show();
                Log.i("TAG", list.getText());
            }
        };
        RecycleAdapter adapter = new RecycleAdapter(getContext(), list1,clickListener);
        list.setAdapter(adapter);
    }
}