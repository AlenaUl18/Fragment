package com.example.my2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Services extends Service {
    public Services() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}