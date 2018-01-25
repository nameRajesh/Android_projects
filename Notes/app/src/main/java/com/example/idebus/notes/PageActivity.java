package com.example.idebus.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class PageActivity extends AppCompatActivity {

    EditText myText;
    EditText myInput;
    MyDBHandler dbHandler;
    MainActivity mainactivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarpage);
        setSupportActionBar(toolbar);
        dbHandler = new MyDBHandler(this, null,null, 1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.page_menu, menu);
        return true;
    }

    public void backToMain(MenuItem item) {
        callMain();
    }

    public void callMain(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



    public void saveText(View view) {

        myText = (EditText) findViewById(R.id.noteWriteId);
        String input = myText.getText().toString();
        Products product = new Products(input);
        dbHandler.addProduct(product);
       // mainactivity.printDatabase();
        callMain();
        //myText.setText("");
        /*String dbString = "";
        String[] a = dbHandler.databaseToString();
        for(int i=0; i<a.length; i++){
            dbString += a[i];
            dbString += "  ";
        }*/

       Toast.makeText(this,"Note Saved",Toast.LENGTH_LONG).show();


    }


    public void clearText(View view) {
        myText = findViewById(R.id.noteWriteId);
        myText.setText("");
    }


}
