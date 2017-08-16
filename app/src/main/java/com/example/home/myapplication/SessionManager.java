package com.example.home.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.home.myapplication.Modal.User;

/**
 * Created by home on 13-08-2017.
 */

public class SessionManager {
        // Shared Preferences
        SharedPreferences pref;

        // Editor for Shared preferences
        SharedPreferences.Editor editor;

        // Context
        Context _context;

        // Shared pref mode
        int PRIVATE_MODE = 0;

        // Sharedpref file name
        private static final String PREF_NAME = "LoginPref";

        // All Shared Preferences Keys
        private static final String IS_LOGIN = "IsLoggedIn";

        // User name (make variable public to access from outside)
        public static final String KEY_ACC_NO = "acc_no";

        // Email address (make variable public to access from outside)
        public static final String KEY_PASSWORD = "password";

        // Constructor
        public SessionManager(Context context){
            this._context = context;
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }
    public void createLoginSession(String acc_no, String password){

        editor.putBoolean(IS_LOGIN, true);

        // Storing password in pref
        editor.putString(KEY_PASSWORD, password);

        // Storing acc_no in pref
        editor.putString(KEY_ACC_NO, acc_no);

        // commit changes
        editor.commit();
    }
    public User getUserDetails(){
        User user=new User();
        user.setAcc_no(pref.getString(KEY_ACC_NO, null));
        user.setPassword(pref.getString(KEY_PASSWORD,null));
        return user;
    }
    public boolean isloggedin(){
        return pref.getBoolean(IS_LOGIN,false);
    }
    public void checkLogin(){
        // Check login status
        if(!this.isloggedin()){
            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }

    }
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, MainActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }
}