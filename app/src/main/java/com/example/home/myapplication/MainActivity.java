package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.home.myapplication.DataBase.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private final AppCompatActivity activity = MainActivity.this;
    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    private DatabaseHelper databaseHelper;
    private CoordinatorLayout cd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // set the view now
        setContentView(R.layout.activity_main);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        databaseHelper=new DatabaseHelper(activity);
        cd=(CoordinatorLayout)findViewById(R.id.cdlayout);

        //Get Firebase auth instance

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });
       /* btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, Questionarre.class));
                verifyFromSQLite();
            }
        });*/



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter account number!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                verifyFromSQLite();

                //authenticate user

            }
        });
    }
    private void verifyFromSQLite(){
        if (databaseHelper.checkUser(inputEmail.getText().toString().trim()
                , inputPassword.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, Questionarre.class);
            accountsIntent.putExtra("EMAIL", inputEmail.getText().toString().trim());
            //emptyInputEditText();
            startActivity(accountsIntent);


        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(cd, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }
    }


