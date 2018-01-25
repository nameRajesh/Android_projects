package com.example.idebus.listviewapp;

/**
 * Created by IDEBUS on 1/13/2018.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(@NonNull Context context, String[] foods) {
        super(context, R.layout.custom_row ,foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);
        String singleFoodItem = getItem(position);
        TextView myText = (TextView) customView.findViewById(R.id.textId);
        ImageView myImage = (ImageView) customView.findViewById(R.id.image1);

        myText.setText(singleFoodItem);
        myImage.setImageResource(R.drawable.large);

        return customView;
    }
}
