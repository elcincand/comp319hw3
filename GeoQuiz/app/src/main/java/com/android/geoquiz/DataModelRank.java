package com.android.geoquiz;

/**
 * Created by elcin on 8/16/17.
 */

public class DataModelRank {
    String userrank;
    String userscore;


    public DataModelRank(String userranktop, String userscoretop) {

        this.userrank=userranktop;
        this.userscore=userscoretop;

    }

    public String getUserrank() {
        return userrank;
    }

    public String getUserscore() {
        return userscore;
    }
}
