package com.chalmie.anovelsharingapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chalmie on 5/4/16.
 */
public class User {
    String username;
    String email;

    public User() {}

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}
