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
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.my2.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlankFragment2 extends Fragment {
    String filename = "Cinema";
    public BlankFragment2() {
        super(R.layout.fragment_blank2);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(((EditText) view.findViewById(R.id.editTextTextPersonName4)).getText());
                String prom = String.valueOf(((EditText) view.findViewById(R.id.editTextTextPersonName6)).getText());
                String pass = String.valueOf(((EditText) view.findViewById(R.id.editTextTextPassword4)).getText());
            File file = new File(getContext().getFilesDir(), filename);
            try (FileOutputStream fos = getContext().openFileOutput(filename, Context.MODE_PRIVATE)) {
                fos.write((name+"\n").getBytes());
                fos.write((prom+"\n").getBytes());
                fos.write((pass+"\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
                Navigation.findNavController(view).navigate(R.id.action_BlankFragment2_to_BlankFragment5);
            }
        });
    }
}