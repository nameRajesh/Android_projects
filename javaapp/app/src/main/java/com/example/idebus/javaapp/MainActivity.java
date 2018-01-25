package com.example.idebus.javaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout
        RelativeLayout newLayout = new RelativeLayout(this);
        newLayout.setBackgroundColor(Color.GREEN);

        // user name
        final EditText username = new EditText(this);
        username.setId(1);

        // button
        Button redButton = new Button(this);
        redButton.setText("Click Me!!");
        redButton.setBackgroundColor(Color.RED);
        redButton.setId(2);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT );

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT );

        // give rules for the position of widgets

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,75);

        // text space (converting DIP to pixels)

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                200, r.getDisplayMetrics());
        username.setWidth(px);


        // event handling

       Button buckysButton = (Button)findViewById(redButton.getId());

        buckysButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView buckysText = (TextView)findViewById(username.getId());
                        buckysText.setText("Good job!");
                    }
                }
        );



        // add widget to layout
        newLayout.addView(redButton, buttonDetails);
        newLayout.addView(username,usernameDetails);

        // set this activities content / display to this view

        setContentView(newLayout);
    }
}

