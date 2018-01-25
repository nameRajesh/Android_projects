package com.example.idebus.fragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;


public class TopSectionFragment extends Fragment {

    private static EditText topText;
    private static EditText bottomText;

    TopSectionListener activityComander;

    public interface TopSectionListener {
        public void CreateMemo(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityComander = (TopSectionListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.top_section_fragment, container, false);

       topText= (EditText) view.findViewById(R.id.topText);
       bottomText = (EditText) view.findViewById(R.id.bottomText);
       final Button button = (Button) view.findViewById(R.id.button1);

       button.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       buttonClick(view);
                   }
               }
       );

        return view;
    }


    public void buttonClick(View view){

        activityComander.CreateMemo(topText.getText().toString(), bottomText.getText().toString());

    }
}
