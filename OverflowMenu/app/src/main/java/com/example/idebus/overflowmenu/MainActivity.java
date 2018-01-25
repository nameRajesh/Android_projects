package com.example.idebus.overflowmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar( toolbar);
        toolbar.setTitle("Good");*/
       // toolbar.inflateMenu(R.menu.menu_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        RelativeLayout main_view1 = (RelativeLayout) findViewById(R.id.main_view);
        switch (item.getItemId()){
            case R.id.menu_red :
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                main_view1.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu_green:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                main_view1.setBackgroundColor(Color.GREEN);
                return true;


            case R.id.menu_yellow :
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                main_view1.setBackgroundColor(Color.YELLOW);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
