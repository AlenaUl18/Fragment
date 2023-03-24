package com.example.my2;

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
//        notificationManager = (NotificationManager) getActivity().getSystemService (Context.NOTIFICATION_SERVICE) ;
//
//        Button button = view.findViewById(R.id.button5);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent(getActivity(), MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//            PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//            NotificationCompat.Builder notificationBuilder =
//                   new NotificationCompat. Builder (getActivity(), CHANNEL_ID)
//                            .setAutoCancel (false)
//                            .setSmallIcon(R.drawable.ic_launcher_foreground)
//                            .setWhen (System. currentTimeMillis())
//                            .setContentIntent (pendingIntent)
//                            .setContentTitle("Уведомление")
//                            .setContentText("Выполнен вход в аккаунт")
//                            .setPriority (PRIORITY_HIGH);
//            createChannelIfNeeded(notificationManager) ;
//            notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
//
//
//            //getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment.class, null).commit();
//        });
//        Button button1 = view.findViewById(R.id.button4);
//        button1.setOnClickListener(v -> {
//            getActivity().startService(new Intent(getActivity(), Services.class));
//    });}
//    public static void createChannelIfNeeded(NotificationManager manager) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
//            manager.createNotificationChannel(notificationChannel);
//        }
//    }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Button addButton = view.findViewById(R.id.button5);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "My Notification");
                builder.setSmallIcon(R.drawable.movie_camera_svgrepo_com);
                builder.setContentTitle("My Title");
                builder.setContentText("Hello");
                builder.setAutoCancel(true);
                //.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                managerCompat.notify(1, builder.build());
            }
        });

        Button serviceButton = view.findViewById(R.id.button4);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startService(new Intent(getActivity(), Services.class));
            }
        });
    }
}