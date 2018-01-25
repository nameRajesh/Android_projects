package com.example.idebus.fragmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // this gets called by the Top Fragment when the user click the button

    @Override
    public void CreateMemo(String top, String bottom) {

      BottomSectionFragment bottomFragment =
                (BottomSectionFragment) getSupportFragmentManager().findFragmentById(R.id.fragment8);

        bottomFragment.setText(top, bottom);
    }
}
