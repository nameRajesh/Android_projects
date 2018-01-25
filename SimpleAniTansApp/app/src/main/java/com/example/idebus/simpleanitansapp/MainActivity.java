
package com.example.idebus.simpleanitansapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.view.View;
import android.transition.TransitionManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylayout = findViewById(R.id.myLayout);

        mylayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent e) {
                        moveBotton();
                        // Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );
    }


    public void moveBotton() {
        View mybutton = findViewById(R.id.myButton);


        // change the position
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        mybutton.setLayoutParams(positionRules);

        //change the size of the botton

     /*   ViewGroup.LayoutParams sizeRules =
                mybutton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        mybutton.setLayoutParams(sizeRules);*/

    }


}
