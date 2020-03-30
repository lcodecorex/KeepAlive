package com.boolbird.keepalive.demo;

import android.content.Intent;
import android.util.Log;

import com.boolbird.keepalive.KeepAliveService;

public class Service1 extends KeepAliveService {
    private static final String TAG = "KeepAliveService1";
    int x = 0;
    private boolean exit = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!exit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                // int x = 8/0;
                    x++;
                    Log.d("Service1", x + "");
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
