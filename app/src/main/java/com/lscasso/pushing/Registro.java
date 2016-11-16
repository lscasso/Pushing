package com.lscasso.pushing;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by leandro on 10/17/16.
 */

public class Registro extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String s = FirebaseInstanceId.getInstance().getToken();
        //sendToMyServer(s);
        Log.v("lal", s);
    }
}
