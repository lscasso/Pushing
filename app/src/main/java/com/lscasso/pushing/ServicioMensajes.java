package com.lscasso.pushing;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by leandro on 10/17/16.
 */
public class ServicioMensajes extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.v("nooo",remoteMessage.getNotification().getBody());
        Intent broadcast = new Intent();
        broadcast.putExtra("BODY", remoteMessage.getNotification().getBody());
        broadcast.setAction("OPEN_NEW_ACTIVITY");
        sendBroadcast(broadcast);
    }
}

