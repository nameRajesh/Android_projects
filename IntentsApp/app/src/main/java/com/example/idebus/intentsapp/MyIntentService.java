package com.example.idebus.intentsapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.support.annotation.Nullable;

public class MyIntentService extends IntentService {
    
    private static final String TAG = "com.example.idebus.intentsapp";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.i(TAG, "The services has been Started");
    }
}
