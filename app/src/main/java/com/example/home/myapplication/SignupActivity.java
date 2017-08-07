package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.home.myapplication.DataBase.DatabaseHelper;
import com.example.home.myapplication.Modal.User;

public class SignupActivity extends AppCompatActivity {
    private EditText inputAcct, inputPassword,inputEmail;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    CoordinatorLayout cd;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputAcct = (EditText) findViewById(R.id.accnt_no);
        inputPassword = (EditText) findViewById(R.id.password);
        inputEmail=(EditText)findViewById(R.id.email);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
        cd=(CoordinatorLayout)findViewById(R.id.cd);
        databaseHelper=new DatabaseHelper(getApplicationContext());
        user=new User();

     /*   btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));
            }
        });*/

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                if (!databaseHelper.checkUser(inputEmail.getText().toString().trim())) {

                    user.setAcc_no(inputAcct.getText().toString().trim());
                    user.setEmail(inputEmail.getText().toString().trim());
                    user.setPassword(inputPassword.getText().toString().trim());

                    databaseHelper.addUser(user);

                    // Snack Bar to show success message that record saved successfully
                    Snackbar.make(cd, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
               //     emptyInputEditText();
                    progressBar.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));


                } else {
                    // Snack Bar to show error message that record already exists
                    Snackbar.make(cd, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}