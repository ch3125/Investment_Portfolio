package com.example.home.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.home.myapplication.Modal.User;

public class offers extends AppCompatActivity {
    private String offers[];
    private Drawable drawable_investments,drawable_expenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        SessionManager sessionManager= new SessionManager(getApplicationContext());
        User user= sessionManager.getUserDetails();
        offer o = new offer();
        try {
            offers=o.han(user.getAcc_no().charAt(user.getAcc_no().length()-1), getApplicationContext());
        }
        catch(Exception e)
        {

        }
        ImageView imgView=(ImageView) findViewById(R.id.imageView);
        ImageView imgView1=(ImageView) findViewById(R.id.imageView1);
        drawable_investments  = getResources().getDrawable(R.drawable.cust1_i);
        imgView.setImageDrawable(drawable_investments);
        drawable_expenses  = getResources().getDrawable(R.drawable.cust1_exp);
        imgView1.setImageDrawable(drawable_expenses);
    }
}
