package com.example.idebus.vedioplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final VideoView myVideo = (VideoView) findViewById(R.id.videoId);
        myVideo.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(myVideo);
        myVideo.setMediaController(mediaController);


    }
}
