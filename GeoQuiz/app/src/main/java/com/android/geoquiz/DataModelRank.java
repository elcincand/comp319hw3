package com.android.geoquiz;

/**
 * Created by elcin on 8/16/17.
 */

public class DataModelRank {
    String usernamerank;
    String scorerank;
    String namerank;
    String lastnamescore;

    public DataModelRank(String usernametop, String userlastnametop, String nametop , String scoretop) {

        this.usernamerank=usernametop;
        this.scorerank=userlastnametop;
        this.namerank=nametop;
        this.lastnamescore=scoretop;


    }

    public String getUsernamerank() {
        return usernamerank;
    }

    public String getScorerank() {
        return scorerank;
    }

    public String getNamerank() {
        return namerank;
    }

    public String getLastnamescore() {
        return lastnamescore;
    }
}
