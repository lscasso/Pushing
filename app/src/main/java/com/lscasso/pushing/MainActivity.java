package com.lscasso.pushing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance()
                .subscribeToTopic("tema");
        final MainActivity ma = this;
        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setBody(intent.getStringExtra("BODY"));
                Log.v("lalal",intent.getStringExtra("BODY"));
            }
        };
        registerReceiver(mReceiver,
                new IntentFilter("OPEN_NEW_ACTIVITY"));
    }


    public void setTitulo(String titulo) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(titulo);
    }

    public void setBody(String body) {
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(body);
    }
}
