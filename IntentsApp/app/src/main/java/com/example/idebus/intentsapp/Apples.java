package com.example.idebus.intentsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);

    /*    Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);*/

        Intent i = new Intent( this, MyService.class);
        startService(i);
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Bacon.class);
        final EditText applesInput = (EditText) findViewById(R.id.appleInput);
        String userMessage= applesInput.getText().toString();
        i.putExtra("appleMessage", userMessage);
        startActivity(i);
    }
}
