package com.oussema.eventregistration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction()))
            Toast.makeText(context,"Airplane mode",Toast.LENGTH_SHORT).show();
    }
}