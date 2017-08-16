package com.android.geoquiz;

/**
 * Created by elcin on 8/16/17.
 */

public class User {


    public String username;
    public String name;
    public String surname;
    public String password;


        public User(String username, String name, String surname, String password) {
            this.username = username;
            this.name = name;
            this.surname = surname;
            this.password = password;


        }


    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}
