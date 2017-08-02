package com.example.home.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questionarre extends AppCompatActivity {
    //private static final String LOG_TAG = MainActivity.class.getSimpleName();
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
        // Hide the keyboard
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_questionarre);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
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
                if(Long.parseLong(question8_answer.toString())>100)// || Long.parseLong(question8_answer.toString())>100 || Long.parseLong(question8_answer.toString())<1)
                {
                    question8 = (TextView) findViewById(R.id.question8);
                    question8.setTextColor(Color.parseColor("#f44336"));
                    question8.setText(question8.getText()+"");
                    flag=true;
                    Toast.makeText(this, "in if", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    question8 = (TextView) findViewById(R.id.question8);
                    question8.setTextColor(Color.parseColor("#263238"));
                    Toast.makeText(this, "in else", Toast.LENGTH_SHORT).show();
                }}
            catch(Exception e)
            {
                question8 = (TextView) findViewById(R.id.question8);
                question8.setTextColor(Color.parseColor("#f44336"));
                question8.setText(question8.getText()+"");
                Toast.makeText(this, "in catch", Toast.LENGTH_SHORT).show();
            }
            question1_answer = (EditText)findViewById(R.id.question1_answer);
            try{
                if(question1_answer.toString().length()==0 || Long.parseLong(question1_answer.toString())>100000 || Long.parseLong(question1_answer.toString())<10000)
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
                if(question2_answer.toString().length()==0 || Long.parseLong(question2_answer.toString())>1200000 || Long.parseLong(question2_answer.toString())<120000)
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

            }
                //startActivity(new Intent(this, Portfolio.class));
            else {


                //Toast.makeText(this, "Please answer all the questions properly highlighted in red", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void help1(View view) {
        Toast.makeText(this, "Please enter a value between 120000 and 1200000", Toast.LENGTH_SHORT).show();
    }
    public void help2(View view) {
        Toast.makeText(this, "Please enter a value between 0 and 100", Toast.LENGTH_SHORT).show();
    }
    public void help(View view) {
        Toast.makeText(this, "Please enter a value between 10000 and 100000", Toast.LENGTH_SHORT).show();
        /*CharSequence resultsDisplay;
        Log.e(LOG_TAG, " " + this.findViewById(R.id.question3_choice3));
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int answer6_score;
        int answer7_score;
        int answer8_score;
        int answer9_score;
        int answer10_score;
        int final_score;

        //------------------------------------------------------------------------------------------
        // Question 1 - Correct Answer is #3 (DNA)
        //------------------------------------------------------------------------------------------
        Boolean answer1;

        question1_choice3 = (RadioButton) this.findViewById(R.id.question1_choice3);
        answer1 = question1_choice3.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 2 - Correct Answer is "Vulcanizing"
        //------------------------------------------------------------------------------------------
        String answer2;
        question2_answer = (EditText) this.findViewById(R.id.question2_answer);
        answer2 = question2_answer.getText().toString().toLowerCase();
        if (answer2.equals("vulcanizing")) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 3  - Correct Answers are #1 (Ribosomes) and #3 (Golgi Apparatus)
        //------------------------------------------------------------------------------------------
        Boolean answer3_choice1;
        Boolean answer3_choice2;
        Boolean answer3_choice3;
        Boolean answer3_choice4;
        question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
        question2_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
        question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
        question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
        answer3_choice1 = question3_choice1.isChecked();
        answer3_choice2 = question2_choice2.isChecked();
        answer3_choice3 = question3_choice3.isChecked();
        answer3_choice4 = question3_choice4.isChecked();
        if (answer3_choice1 && !answer3_choice2 && answer3_choice3 && !answer3_choice4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 4 - Correct Answer is "Gravity"
        //------------------------------------------------------------------------------------------
        String answer4;
        question4_answer = (EditText) this.findViewById(R.id.question4_answer);
        answer4 = question4_answer.getText().toString().toLowerCase();
        if (answer4.equals("gravity")) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 5  - Correct Answers is #2 "Pine trees"
        //------------------------------------------------------------------------------------------
        Boolean answer5;
        question5_choice2 = (RadioButton) this.findViewById(R.id.question5_choice2);
        answer5 = question5_choice2.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 6 - Correct Answer is "Clouds" or "Cloud"
        //------------------------------------------------------------------------------------------
        String answer6;
        question6_answer = (EditText) this.findViewById(R.id.question6_answer);
        answer6 = question6_answer.getText().toString().toLowerCase();
        if (answer6.equals("clouds") || answer6.equals("cloud")) {
            answer6_score = 1;
        } else {
            answer6_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 7  - Correct Answers are #3 (Earth) and #4 (Pluto)
        //------------------------------------------------------------------------------------------
        Boolean answer7_choice1;
        Boolean answer7_choice2;
        Boolean answer7_choice3;
        Boolean answer7_choice4;
        question7_choice1 = (CheckBox) this.findViewById(R.id.question7_choice1);
        question7_choice2 = (CheckBox) this.findViewById(R.id.question7_choice2);
        question7_choice3 = (CheckBox) this.findViewById(R.id.question7_choice3);
        question7_choice4 = (CheckBox) this.findViewById(R.id.question7_choice4);
        answer7_choice1 = question7_choice1.isChecked();
        answer7_choice2 = question7_choice2.isChecked();
        answer7_choice3 = question7_choice3.isChecked();
        answer7_choice4 = question7_choice4.isChecked();
        if (!answer7_choice1 && !answer7_choice2 && answer7_choice3 && answer7_choice4) {
            answer7_score = 1;
        } else {
            answer7_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 8 - Correct Answer is "Wrist"
        //------------------------------------------------------------------------------------------
        String answer8;
        question8_answer = (EditText) this.findViewById(R.id.question8_answer);
        answer8 = question8_answer.getText().toString().toLowerCase();
        if (answer8.equals("wrist")) {
            answer8_score = 1;
        } else {
            answer8_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 9  - Correct Answers is #2 "Stalagmites"
        //------------------------------------------------------------------------------------------
        Boolean answer9;
        question9_choice2 = (RadioButton) this.findViewById(R.id.question9_choice2);
        answer9 = question9_choice2.isChecked();
        if (answer9) {
            answer9_score = 1;
        } else {
            answer9_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Question 10 - Correct Answer is "Smelting"
        //------------------------------------------------------------------------------------------
        String answer10;
        question10_answer = (EditText) this.findViewById(R.id.question10_answer);
        answer10 = question10_answer.getText().toString().toLowerCase();
        if (answer10.equals("smelting")) {
            answer10_score = 1;
        } else {
            answer10_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score +
                answer6_score + answer7_score + answer8_score + answer9_score + answer10_score;

        if (final_score == 10) {
            resultsDisplay = "Perfect! You scored 10 out of 10";
        } else {
            resultsDisplay = "Try again. You scored " + final_score + " out of 10";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();*/
    }

}

