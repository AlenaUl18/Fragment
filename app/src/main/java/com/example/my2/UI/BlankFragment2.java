package com.example.my2.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.my2.DataSource.Room.DataBase;
import com.example.my2.DataSource.User;
import com.example.my2.R;
import com.example.my2.Model.ViewModels.RegistPattern;

import java.io.FileNotFoundException;

public class BlankFragment2 extends Fragment {
    RegistPattern viewPattern;
    DataBase user;
    public BlankFragment2() {
        super(R.layout.fragment_blank2);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPattern = new ViewModelProvider(this).get(RegistPattern.class);
        user = DataBase.getInstance(getContext());
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = String.valueOf(((EditText) view.findViewById(R.id.editTextTextPersonName4)).getText());
                String Pass = String.valueOf(((EditText) view.findViewById(R.id.editTextTextPassword4)).getText());
                String Promocode = String.valueOf(((EditText) view.findViewById(R.id.editTextTextPersonName6)).getText());
                try {
                    viewPattern.createAppSpec(requireContext(), "app_specific", Name + Promocode);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                viewPattern.CreateExternal(requireContext(), "external", Name + Promocode);
                viewPattern.CreateSharedPreferences(requireContext(), "shared_preference", Name + Promocode);
                user.userDao().insertUser(new User(Name,Pass,Promocode));
                Navigation.findNavController(view).navigate(R.id.action_BlankFragment2_to_BlankFragment5);
            }
        });
    }
}