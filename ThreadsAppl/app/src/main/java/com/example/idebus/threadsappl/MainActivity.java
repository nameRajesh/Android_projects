
package com.example.idebus.threadsappl;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView text1 = (TextView) findViewById(R.id.testId);
            text1.setText("nice job");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMe(View view) {

        Runnable r = new Runnable() {
            @Override
            public void run() {

                long futuretime = System.currentTimeMillis() + 5000;
                while (System.currentTimeMillis() < futuretime) {
                    synchronized (this) {
                        try {
                            wait(futuretime - System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Thread waitThread = new Thread(r);
        waitThread.start();
    }
}
