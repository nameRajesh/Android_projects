package com.example.idebus.intentsapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "com.example.idebus.intentsapp";


    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG,"onStartCommand menthod is called");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++){
                    long futureTime = System.currentTimeMillis() + 5000;

                    while (System.currentTimeMillis() < futureTime){
                        synchronized (this){
                            try{
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG ,"something is doing something");
                            } catch (Exception e){}
                        }

                    }
                }
            }
        };

        Thread sThread = new Thread(r1);
        sThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i( TAG, "onDestory method is called");
    }

    @Override
    public IBinder onBind(Intent intent) {
      return null;
    }
}
