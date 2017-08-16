package com.android.geoquiz;

/**
 * Created by elcin on 8/16/17.
 */

public class DataModelProfile {
    String name;
    String lastname;
    String username;
    String highscore;


    public DataModelProfile(String nameuser, String lastnameuser, String usernameuser, String highscoreuser) {

        this.name=nameuser;
        this.lastname=lastnameuser;
        this.username=usernameuser;
        this.highscore=highscoreuser;

    }



    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getHighscore() {
        return highscore;
    }

}
