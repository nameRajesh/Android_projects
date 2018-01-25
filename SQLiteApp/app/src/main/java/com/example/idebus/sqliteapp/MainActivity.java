package com.example.idebus.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText myInput;
    TextView myText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInput = (EditText) findViewById(R.id.inputText);
        myText = (TextView) findViewById(R.id.textDisplay);
        dbHandler = new MyDBHandler(this, null,null, 1);
        printDatabase();
    }


    public void addOnClicked(View view) {

        String input = myInput.getText().toString();
        Products product = new Products(input);
        dbHandler.addProduct(product);
        printDatabase();


    }


    public void deleteOnCliced(View view) {

        String text = myInput.getText().toString();

        if(dbHandler.checkString(text)) {
            dbHandler.deleteProduct(text);
            printDatabase();
        }else {
            Toast.makeText(MainActivity.this, "input not found", Toast.LENGTH_LONG).show();
        }
    }

    private void printDatabase() {
        String dbString = dbHandler.databaseToString();
        myText.setText(dbString);

        myInput.setText("");

    }


}
