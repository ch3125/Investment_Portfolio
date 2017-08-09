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
        ImageView imgView1=(ImageView) findViewById(R.id.imageView1);
        Drawable drawable1  = getResources().getDrawable(R.drawable.cust1_exp);
        imgView1.setImageDrawable(drawable1);
       // FileReader fileReader= getResources().getAssets().open("TCS_DATABASE1");
    }
}