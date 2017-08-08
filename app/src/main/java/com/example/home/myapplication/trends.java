package com.example.home.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class trends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends);
        ImageView imgView=(ImageView) findViewById(R.id.imageView);
        Drawable drawable  = getResources().getDrawable(R.drawable.cust1_i);
        imgView.setImageDrawable(drawable);
    }
}