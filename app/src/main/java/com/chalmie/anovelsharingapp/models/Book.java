package com.chalmie.anovelsharingapp.models;

import org.parceler.Parcel;

/**
 * Created by chalmie on 4/29/16.
 */
@Parcel
public class Book {
    String mTitle;

    public Book() {}

    public Book(String title) {
        this.mTitle = title;
    }

    public String getBookTitle() {
        return mTitle;
    }
}
