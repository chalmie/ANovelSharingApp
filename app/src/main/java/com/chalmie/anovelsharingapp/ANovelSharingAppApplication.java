package com.chalmie.anovelsharingapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by chalmie on 4/26/16.
 */
public class ANovelSharingAppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
