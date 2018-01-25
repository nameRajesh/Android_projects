package com.example.idebus.clickapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button redbutton = (Button) findViewById(R.id.button2) ;
        redbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView userdetails = (TextView) findViewById(R.id.email1);
                        userdetails.setText( userdetails.getText().toString() +" "+"DONE");
                    }
                }
        );

        redbutton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView buckysText = (TextView)findViewById(R.id.email1);
                        buckysText.setText("Holy carp, that was a long one!");
                        return true;
                    }
                }
        );
        /*redbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView userdetails = (TextView) findViewById(R.id.email1);
                userdetails.setText("DONE");
            }
        });*/

    }
}
