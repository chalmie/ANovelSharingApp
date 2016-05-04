package com.chalmie.anovelsharingapp.models;

/**
 * Created by chalmie on 5/4/16.
 */
public class User {
    private String username;
    private String email;

    public User() {}

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getName() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
