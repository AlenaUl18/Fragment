package com.example.my2.ViewModels;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.lifecycle.ViewModel;

import java.io.File;
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
    public void CreateExternal(Context context, String fileName, String fileInformation) {
        if (context.getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(filePath, fileName);
            FileOutputStream outStream;
            try {
                outStream = new FileOutputStream(file);
                outStream.write(fileInformation.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
