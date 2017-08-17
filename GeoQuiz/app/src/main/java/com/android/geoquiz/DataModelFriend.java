package com.android.geoquiz;

/**
 * Created by elcin on 8/16/17.
 */

public class DataModelFriend {
    String friendName;
    String friendlastname;
    String friendusername;
    String friendhighscore;


    public DataModelFriend(String friendusernamedata, String friendNamedata, String friendlastnamedata,  String friendhighscoredata) {

        this.friendName=friendNamedata;
        this.friendlastname=friendlastnamedata;
        this.friendusername=friendusernamedata;
        this.friendhighscore=friendhighscoredata;


    }

    public String getFriendName() {
        return friendName;
    }


    public String getFriendlastname() {
        return friendlastname;
    }

    public String getFriendusername() {
        return friendusername;
    }

    public String getFriendhighscore() {
        return friendhighscore;
    }
}
