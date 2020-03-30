package com.boolbird.keepalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AutoBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AutoBootReceiver", intent.getAction() + "");
        if (KeepAliveConfigs.bootReceivedListener != null) {
            KeepAliveConfigs.bootReceivedListener.onReceive(context, intent);
        }
        KeepAlive.launchAlarm(context);
    }
}
