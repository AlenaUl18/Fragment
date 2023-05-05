package com.example.my2.UI;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my2.R;
import com.example.my2.blurWorker;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlankFragment3 extends Fragment {
    private WorkManager workManager;
    public BlankFragment3() {
        super(R.layout.fragment_blank3);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = requireActivity().getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/*".equals(type)) {
                ((TextView)getView().findViewById(R.id.textView2)).setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
    }
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button but = view.findViewById(R.id.button4);
        but.setOnClickListener(v -> {
            String number = "89017016838";
            Uri map = Uri.parse("tel:" + number);
            Intent telIntent = new Intent(Intent.ACTION_VIEW, map);
            telIntent.putExtra(Intent.EXTRA_TEXT, "number");
            try {
                startActivity(telIntent);
            } catch (ActivityNotFoundException e) {
                e.getStackTrace();
            }
        });
        workManager = WorkManager.getInstance();
        workManager.enqueue(new OneTimeWorkRequest.Builder(blurWorker.class).build());
        Callable<String> callableTask = () -> {
            return "1 зал";
        };

        final ExecutorService service = Executors.newFixedThreadPool(2);
        Future<String> future;
        future = service.submit(callableTask);

        TextView text = view.findViewById(R.id.textView2);
        try {
            text.setText(future.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();

    }
}