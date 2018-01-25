package com.example.idebus.boundserviceapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import com.example.idebus.boundserviceapp.MyService.MyLocalBinder;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {

    MyService mainService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);
        bindService(i, myConnection, Context.BIND_AUTO_CREATE);
    }

    public void showTime(View view) {

        String currentTIme = mainService.getCurrentTime();
        TextView text = (TextView) findViewById(R.id.textId);
        text.setText(currentTIme);
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyLocalBinder binder = (MyLocalBinder) iBinder;
            mainService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound=false;
        }
    };
}
