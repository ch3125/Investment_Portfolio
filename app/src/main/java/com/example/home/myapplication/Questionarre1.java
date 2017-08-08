package com.example.home.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questionarre1 extends AppCompatActivity {

    private TextView question1;
    private TextView question2;
    private TextView question3;
    private TextView question4;
    private TextView question5;
    private TextView question6;
    private TextView question7;
    private TextView question8;
    private RadioGroup g;
    //private boolean flag=false;
    EditText question1_answer;
    EditText question2_answer ;
    EditText question8_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionarre1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        boolean flag=false;
        if (id == R.id.action_favorite) {
            //String toast= "";
            g = (RadioGroup) findViewById(R.id.radio1);
            if(g.getCheckedRadioButtonId()==-1) {
                question3 = (TextView) findViewById(R.id.question3);
                question3.setTextColor(Color.parseColor("#f44336"));
                question3.setText(question3.getText()+"");
                flag=true;
            }
            else
            {
                question3 = (TextView) findViewById(R.id.question3);
                question3.setTextColor(Color.parseColor("#263238"));
                //flag=false;
            }
            g = (RadioGroup) findViewById(R.id.radio2);
            if(g.getCheckedRadioButtonId()==-1) {
                question4 = (TextView) findViewById(R.id.question4);
                question4.setTextColor(Color.parseColor("#f44336"));
                question4.setText(question4.getText()+"");
                flag=true;
            }
            else
            {
                question4 = (TextView) findViewById(R.id.question4);
                question4.setTextColor(Color.parseColor("#263238"));
                //flag=false;
            }
            g = (RadioGroup) findViewById(R.id.radio3);
            if(g.getCheckedRadioButtonId()==-1) {
                question5 = (TextView) findViewById(R.id.question5);
                question5.setTextColor(Color.parseColor("#f44336"));
                question5.setText(question5.getText()+"");
                flag=true;
            }
            else
            {
                question5 = (TextView) findViewById(R.id.question5);
                question5.setTextColor(Color.parseColor("#263238"));
                //flag=false;
            }
            g = (RadioGroup) findViewById(R.id.radio4);
            if(g.getCheckedRadioButtonId()==-1) {
                question6 = (TextView) findViewById(R.id.question6);
                question6.setTextColor(Color.parseColor("#f44336"));
                question6.setText(question6.getText()+"");
                flag=true;
            }
            else
            {
                question6 = (TextView) findViewById(R.id.question6);
                question6.setTextColor(Color.parseColor("#263238"));
                //flag=false;
            }
            g = (RadioGroup) findViewById(R.id.radio5);
            if(g.getCheckedRadioButtonId()==-1) {
                question7 = (TextView) findViewById(R.id.question7);
                question7.setTextColor(Color.parseColor("#f44336"));
                question7.setText(question7.getText()+"");
                flag=true;
            }
            else
            {
                question7 = (TextView) findViewById(R.id.question7);
                question7.setTextColor(Color.parseColor("#263238"));
                //flag=false;
            }
            question8_answer = (EditText)findViewById(R.id.question8_answer);
            try{
                if(question8_answer.getText().toString().length()==0 || Long.parseLong(question8_answer.getText().toString())>100 || Long.parseLong(question8_answer.getText().toString())<1 )
                {
                    question8 = (TextView) findViewById(R.id.question8);
                    question8.setTextColor(Color.parseColor("#f44336"));
                    question8.setText(question8.getText()+"");
                    flag=true;
                    //Toast.makeText(this, "in if", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    question8 = (TextView) findViewById(R.id.question8);
                    question8.setTextColor(Color.parseColor("#263238"));
                    //Toast.makeText(this, "in else", Toast.LENGTH_SHORT).show();
                }}
            catch(Exception e)
            {
                question8 = (TextView) findViewById(R.id.question8);
                question8.setTextColor(Color.parseColor("#f44336"));
                question8.setText(question8.getText()+"");
                //Toast.makeText(this, "in catch", Toast.LENGTH_SHORT).show();
            }
            question1_answer = (EditText)findViewById(R.id.question1_answer);
            try{
                if(question1_answer.getText().toString().length()==0 || Long.parseLong(question1_answer.getText().toString())>100000 || Long.parseLong(question1_answer.getText().toString())<10000)
                {
                    question1 = (TextView) findViewById(R.id.question1);
                    question1.setTextColor(Color.parseColor("#f44336"));
                    question1.setText(question1.getText()+"");
                    flag=true;
                }
                else
                {
                    question1 = (TextView) findViewById(R.id.question1);
                    question1.setTextColor(Color.parseColor("#263238"));
                    //flag=false;
                }
            }
            catch(Exception e)
            {
                question1 = (TextView) findViewById(R.id.question1);
                question1.setTextColor(Color.parseColor("#f44336"));
                question1.setText(question1.getText()+"");
            }
            question2_answer = (EditText)findViewById(R.id.question2_answer);
            try{
                if(question2_answer.getText().toString().length()==0 || Long.parseLong(question2_answer.getText().toString())>1200000 || Long.parseLong(question2_answer.getText().toString())<120000)
                {
                    question2 = (TextView) findViewById(R.id.question2);
                    question2.setTextColor(Color.parseColor("#f44336"));
                    question2.setText(question2.getText()+"");
                    flag=true;
                }
                else
                {
                    question2 = (TextView) findViewById(R.id.question2);
                    question2.setTextColor(Color.parseColor("#263238"));
                    //flag=false;
                }
            }
            catch(Exception e)
            {
                question2 = (TextView) findViewById(R.id.question2);
                question2.setTextColor(Color.parseColor("#f44336"));
                question2.setText(question2.getText()+"");
            }
            if(!flag)
            {
                Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
            }
            //startActivity(new Intent(this));
            else {
                Snackbar.make(getCurrentFocus(),"Please answer all the questions properly highlighted in red",Snackbar.LENGTH_SHORT);
                    //Toast.makeText(this, "Please answer all the questions properly highlighted in red", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void help1(View view) {
        Snackbar.make(getCurrentFocus(),"Please enter a value between 1,20,000 and 12,00,000",Snackbar.LENGTH_SHORT);
        //Toast.makeText(this, "Please enter a value between 1,20,000 and 12,00,000", Toast.LENGTH_SHORT).show();
    }
    public void help2(View view) {
        Snackbar.make(getCurrentFocus(),"Please enter a value between 0 and 100",Snackbar.LENGTH_SHORT);
        //Toast.makeText(this, "Please enter a value between 0 and 100", Toast.LENGTH_SHORT).show();
    }
    public void help(View view) {
        Snackbar.make(getCurrentFocus(),"Please enter a value between 10,000 and 1,00,000",Snackbar.LENGTH_SHORT);
        //Toast.makeText(this, "Please enter a value between 10,000 and 1,00,000", Toast.LENGTH_SHORT).show();
    }
}
