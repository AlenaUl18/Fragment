package com.example.my2.UI;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my2.R;

public class BlankFragment extends Fragment {
    public BlankFragment() {
        super(R.layout.fragment_blank);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(v -> { Bundle result = new Bundle();
            result.putString("bundleKey", String.valueOf("Аня"));
            getParentFragmentManager().setFragmentResult("requestKey", result); getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment2.class, null).commit();});
        Button button1 = view.findViewById(R.id.button);
        button1.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment3.class, null).commit();
        });
        Button button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment4.class, null).commit();
        });
    }
}