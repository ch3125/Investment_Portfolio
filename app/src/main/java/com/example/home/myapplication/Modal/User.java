package com.example.home.myapplication.Modal;

/**
 * Created by home on 03-08-2017.
 */

public class User {
    private int cid;
    private String acc_no;
    private String password;
    private String email;

    public int getCid() {
        return cid;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public String getPassword() {
        return password;
    }



    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
