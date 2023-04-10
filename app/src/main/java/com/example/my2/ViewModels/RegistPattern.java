package com.example.my2.ViewModels;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.lifecycle.ViewModel;

import com.example.my2.Manifest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RegistPattern extends ViewModel {
private static final int REQUEST=1;
public void createAppSpec (Context context, String filename, String fileContent) throws FileNotFoundException {
    try (FileOutputStream fos = context.openFileOutput(filename + ".txt", Context.MODE_PRIVATE)) {
    fos.write(fileContent.getBytes());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
