package com.example.home.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.home.myapplication.Modal.User;

public class trends extends AppCompatActivity {

    private SessionManager session;
    private User user;
    private Drawable drawable_investments,drawable_expenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends);
        ImageView imgView=(ImageView) findViewById(R.id.imageView);
        ImageView imgView1=(ImageView) findViewById(R.id.imageView1);
        session = new SessionManager(getApplicationContext());
        user=session.getUserDetails();
        switch(user.getAcc_no().charAt(user.getAcc_no().length()-1))
        {
            case '1':
                drawable_investments  = getResources().getDrawable(R.drawable.cust1_i);
                imgView.setImageDrawable(drawable_investments);
                drawable_expenses  = getResources().getDrawable(R.drawable.cust1_exp);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case '2':
                drawable_investments  = getResources().getDrawable(R.drawable.cust2_i);
                imgView.setImageDrawable(drawable_investments);
                drawable_expenses  = getResources().getDrawable(R.drawable.cust2_exp);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case '3':
                drawable_investments  = getResources().getDrawable(R.drawable.cust3_i);
                imgView.setImageDrawable(drawable_investments);
                drawable_expenses  = getResources().getDrawable(R.drawable.cust3_exp);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            case '4':
                drawable_investments  = getResources().getDrawable(R.drawable.cust4_i);
                imgView.setImageDrawable(drawable_investments);
                drawable_expenses  = getResources().getDrawable(R.drawable.cust4_exp);
                imgView1.setImageDrawable(drawable_expenses);
                break;
            default:
                break;
        }
    }
}