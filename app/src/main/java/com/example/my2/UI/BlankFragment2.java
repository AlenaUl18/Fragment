package com.example.my2.UI;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.my2.DataSource.Room.DataBase;
import com.example.my2.DataSource.User;
import com.example.my2.R;
import com.example.my2.ViewModels.RegistPattern;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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