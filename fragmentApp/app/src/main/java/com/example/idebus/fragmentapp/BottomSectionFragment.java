package com.example.idebus.fragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomSectionFragment extends Fragment {

    private static TextView topText;
    private static TextView bottomText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment_layout, container, false);

        topText = (TextView) view.findViewById(R.id.topTextb);
        bottomText = (TextView) view.findViewById(R.id.bottomTextb);
        return view;
    }

    public void  setText(String top, String bottom){
        topText.setText(top);
        bottomText.setText(bottom);
    }
}
