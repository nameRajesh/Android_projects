package com.example.idebus.imagecapture;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button) findViewById(R.id.buttonId);
        myImage = (ImageView) findViewById(R.id.imageId);

        // Disable the button if the user has no camera

        if(!hasCemera()){
            myButton.setEnabled(false);
        }

    }

    // check the camera
    public boolean hasCemera(){

        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);

    }

    // Lunching the camera
    public void lunchCamera(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // take picture and pass result along to an Activity Result

        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

    }

    // if you want to store the image taken overrie
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){

            // get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            myImage.setImageBitmap(photo);

        }

    }
}
