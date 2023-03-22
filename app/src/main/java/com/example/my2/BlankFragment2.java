package com.example.my2;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BlankFragment2 extends Fragment {
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";
    public BlankFragment2() {
        super(R.layout.fragment_blank2);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notificationManager = (NotificationManager) getActivity().getSystemService (Context.NOTIFICATION_SERVICE) ;
        getParentFragmentManager().setFragmentResultListener("requestKey", this, (key, bundle) -> {

        });

        Button button = view.findViewById(R.id.button5);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder notificationBuilder =
                    new NotificationCompat. Builder (getActivity(), CHANNEL_ID)
                            .setAutoCancel (false)
                            .setSmallIcon(R.drawable.ic_launcher_foreground)
                            .setWhen (System. currentTimeMillis())
                            .setContentIntent (pendingIntent)
                            .setContentTitle("Уведомление")
                            .setContentText("Выполнен вход в аккаунт")
                            .setPriority (PRIORITY_HIGH);
            createChannelIfNeeded(notificationManager) ;
            notificationManager.notify(NOTIFY_ID, notificationBuilder.build());

            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment.class, null).commit();
        });
    }
    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}