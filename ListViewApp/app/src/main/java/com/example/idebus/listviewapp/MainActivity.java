package com.example.idebus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] foods ={"Bacon", "Ham" , "Olive" , "Candy", "MeatBall", "Potato", "Onion", "Lemon" ,"Banana", "Apple", "Orange", "Mango","Bilberry","Grapefruit","Blueberry","Pear","Guava","Cherry","Melon","Strawberry","Cucumber"};
        ListAdapter myAdapter = new CustomAdapter(this, foods);

        ListView listView = (ListView) findViewById(R.id.listId);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String food = String.valueOf(adapterView.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_LONG).show();

                    }
                }
        );

    }


}

