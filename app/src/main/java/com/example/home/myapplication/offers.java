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
        switch(offers[0])
        {
            case "swiggy":
                drawable_investments  = getResources().getDrawable(R.drawable.swiggyoffer1);
                imgView.setImageDrawable(drawable_investments);
                break;
            case "pizzahut":
                drawable_investments  = getResources().getDrawable(R.drawable.pizzahutoffer1);
                imgView.setImageDrawable(drawable_investments);
                break;
            case "pantaloons":
                drawable_investments  = getResources().getDrawable(R.drawable.pantaloonsoffer1);
                imgView.setImageDrawable(drawable_investments);
                break;
            case "paytm":
                drawable_investments  = getResources().getDrawable(R.drawable.paytmoffer1);
                imgView.setImageDrawable(drawable_investments);
                break;
            case "uber":
                drawable_investments  = getResources().getDrawable(R.drawable.uberoffer1);
                imgView.setImageDrawable(drawable_investments);
                break;
            case "inox":
                drawable_investments  = getResources().getDrawable(R.drawable.inoxoffer1);
                imgView.setImageDrawable(drawable_investments);
                break;
        }
        switch(offers[1]) {
            case "swiggy":
                drawable_expenses  = getResources().getDrawable(R.drawable.swiggyoffer2);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case "pizzahut":
                drawable_expenses  = getResources().getDrawable(R.drawable.pizzahutoffer2);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case "pantaloons":
                drawable_expenses  = getResources().getDrawable(R.drawable.pantaloonsoffer2);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case "paytm":
                drawable_expenses  = getResources().getDrawable(R.drawable.paytmoffer1);
                imgView1.setImageDrawable(drawable_expenses);
            case "uber":
                drawable_expenses  = getResources().getDrawable(R.drawable.uberoffer2);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case "inox":
                drawable_expenses  = getResources().getDrawable(R.drawable.inoxoffer1);
                imgView1.setImageDrawable(drawable_expenses);
                break;
        }
    }
}
