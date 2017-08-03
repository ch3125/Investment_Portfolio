package com.example.home.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.home.myapplication.Modal.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 03-08-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";
    // User table name
    private static final String TABLE_USER = "user";
    // User Table Columns names
    private static final String COLUMN_USER_ID = "c_id";
    private static final String COLUMN_ACC_NO = "acc_no";
    private static final String COLUMN_USER_PHONE = "user_phone";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    // create table sql query
    private String CREATE_USER_TABLE="CREATE TABLE "+TABLE_USER+" ("+COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_ACC_NO+
            COLUMN_USER_PHONE+" TEXT,"+COLUMN_USER_PASSWORD+" TEXT"+")";
    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);
    }
    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ACC_NO,user.getAcc_no());
        values.put(COLUMN_USER_PHONE,user.getPhone());
        values.put(COLUMN_USER_PASSWORD,user.getPassword());

        //inserting row
        db.insert(TABLE_USER,null,values);
        db.close();

    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser(){
        //array of colums to fetch
        String[] columns={COLUMN_USER_ID,COLUMN_ACC_NO,COLUMN_USER_PHONE,COLUMN_USER_PASSWORD};
        //SORTING ORDER
        String sortOrder=COLUMN_ACC_NO+" ASC";
        List<User> userList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor=db.query(TABLE_USER ,//TABLE TO QUERY
                columns, //columns to return
                 null, //columns for where clause
                null, //values for where clause
                null, //group the rows
                null, //filter by row groups
                sortOrder); //the sort order

    // Traversing through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                User user=new User();
                user.setCid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setAcc_no(cursor.getString(cursor.getColumnIndex(COLUMN_ACC_NO)));
                user.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PHONE)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                userList.add(user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;


}
    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ACC_NO, user.getAcc_no());
        values.put(COLUMN_USER_PHONE, user.getPhone());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getCid())});
        db.close();
    }
    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getCid())});
        db.close();
    }
    /**
     * This method to check user exist or not
     *
     * @param acc_no
     * @return true/false
     */
    public boolean checkUser(String acc_no){
        //array of columns to fetch
        String[] columns={COLUMN_USER_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        //selection criteria
        String selection=COLUMN_ACC_NO+" =?";
        //SELECTION ARGUMENT
        String[] selectionArgs={acc_no};
        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount=cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount>0)
            return true;
        return false;

    }
    /**
     * This method to check user exist or not
     *
     * @param acc_no
     * @param password
     * @return true/false
     */
    public boolean checkUser(String acc_no, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_ACC_NO + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {acc_no, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}

