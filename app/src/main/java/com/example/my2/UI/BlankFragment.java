package com.example.my2.UI;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
        ImageView animation = view.findViewById(R.id.imageView4);
        Drawable drawable = animation.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_BlankFragment_to_BlankFragment3);
            }
        });
        Button button1 = view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_BlankFragment_to_BlankFragment4);
            }
        });
        Button button2 = view.findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_BlankFragment_to_BlankFragment2);
            }
        });
        ImageButton button4 = view.findViewById(R.id.imageButton3);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_BlankFragment_to_BlankFragment5);
            }
        });
    }
}