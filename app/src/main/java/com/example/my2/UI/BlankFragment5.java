package com.example.my2.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.my2.DataSource.Room.DataBase;
import com.example.my2.DataSource.User;
import com.example.my2.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BlankFragment5 extends Fragment {
    private DataBase user;
    public BlankFragment5() {
        super (R.layout.fragment_blank5);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = DataBase.getInstance(getContext());
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user.userDao().getUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users != null && users.size() > 0) {
                    for (User user : users) {
                        ((TextView)view.findViewById(R.id.name1)).setText(user.getName());
                        ((TextView)view.findViewById(R.id.textView)).setText(user.getProm());
                    }
                }
            }
        });
    }
}