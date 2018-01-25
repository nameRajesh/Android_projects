package com.example.idebus.notes;

/**
 * Created by IDEBUS on 1/14/2018.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(@NonNull Context context, String[] a) {
        super(context, R.layout.custom_layout, a);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_layout, parent, false);
        //String singleFoodItem = getItem(position);
        TextView myText = (TextView) customView.findViewById(R.id.noteNameId);
        ImageView myImage = (ImageView) customView.findViewById(R.id.imageId);

      //  for(int i=1;i<=position;i++){
            myText.setText("Note "+ (position+1));
            myImage.setImageResource(R.drawable.inner);
        //}

        return customView;
    }





    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getM

        //getMenuInflate().inflate(R.menu.menu_main, menu);
        return true;
    }*/
}

