package com.example.leftover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numbest;
    private ImageView thingy;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thingy = findViewById(R.id.imageButton);
    }

    public void Add1(View view) {
        numbest += 1;
        TextView t = (TextView) findViewById(R.id.counter);
        t.setText(numbest + " Portion");
    }

    public void Subtract1(View view) {
        numbest -= 1;
        TextView t = (TextView) findViewById(R.id.counter);
        t.setText(numbest + " Portion");
    }

    public void cameraStuff(View view) {
        Intent imageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (imageIntent.resolveActivity(getPackageManager())!=null) {
        startActivityForResult(imageIntent,REQUEST_IMAGE_CAPTURE);
            }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBit = (Bitmap) extras.get("data");
            thingy.setImageBitmap(imageBit);
        }
    }
}

