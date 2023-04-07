package com.example.my2.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.my2.Model.CinemaInfo;
import com.example.my2.R;
import com.example.my2.RecycleAdapter;
import com.example.my2.ViewModels.ViewPattern;

public class BlankFragment4 extends Fragment {
    private ViewPattern pattern;
    public BlankFragment4() {
        super(R.layout.fragment_blank4);
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pattern = new ViewModelProvider(this).get(ViewPattern.class);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView list = view.findViewById(R.id.Recycle);
        RecycleAdapter.OnClickListener clickListener = new RecycleAdapter.OnClickListener() {
            @Override
            public void OnClick(CinemaInfo list, int position) {
            }
        };
        RecycleAdapter adapter = new RecycleAdapter(getContext(), clickListener);
        list.setAdapter(adapter);
        pattern.list1.observe(getViewLifecycleOwner(), adapter::update);
    }
}