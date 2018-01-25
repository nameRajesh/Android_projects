package com.example.idebus.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetector;
    private TextView message;
    private EditText myInput;
    MyDBHandler dbHandler;
    private ImageView imageview;
    GridView gv;
    EditText myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbHandler = new MyDBHandler(this, null,null, 1);
        gv= findViewById(R.id.gridId);
        printDatabase();

         gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String selectedItem = String.valueOf(adapterView.getItemAtPosition(position));

                //Toast.makeText(MainActivity.this, selectedItem , Toast.LENGTH_LONG).show();

                setContentView(R.layout.display_test);
                myText = findViewById(R.id.displayText);
                myText.setText(selectedItem);

                //DisplaySelectedItem.setText(selectedItem +" is selected.");


            }
        });

    }

    public void printDatabase() {
       /* String dbString = dbHandler.databaseToString();
        myText.setText(dbString);*/

        //String[] foods ={"Bacon", "Ham" , "Olive" , "Candy", "MeatBall", "Lemon" ,"Banana", "Apple", "Orange", "Mango","Bilberry","Grapefruit","Blueberry","Pear","Guava","Cherry","Melon","Strawberry","Cucumber"};
        String[] foods = dbHandler.databaseToString();
        ListAdapter myAdapter = new CustomAdapter(this,  foods);
        GridView listView = (GridView) findViewById(R.id.gridId);
        listView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addNotes(MenuItem item) {
        Intent i = new Intent(this, PageActivity.class);
        startActivity(i);

    }

    public void backButtonDisplay(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void deleteButton(View view) {
        myInput = (EditText) findViewById(R.id.displayText);
        String text = myInput.getText().toString();
        dbHandler.deleteProduct(text);
        Toast.makeText(this,"Note Deleted",Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }


/*
    public void gridlayouttouch(View view) {

        Button button = (Button) view;
        GridLayout.LayoutParams params = (GridLayout.LayoutParams) button.getLayoutParams();
        //String s = params.toString();
        Toast.makeText(MainActivity.this,"s",Toast.LENGTH_LONG).show();
    }*/
}
