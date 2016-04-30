package com.chalmie.anovelsharingapp.models;

import org.parceler.Parcel;

/**
 * Created by chalmie on 4/29/16.
 */
@Parcel
public class Book {
    String mTitle;
    String mAuthor;
    String mImage;
    int mPageCount;
    String mPublishedDate;

    public Book() {}

    public Book(String mTitle, String mAuthor, String mImage, int mPageCount, String mPublishedDate) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mImage = mImage;
        this.mPageCount = mPageCount;
        this.mPublishedDate = mPublishedDate;
    }


    public String getBookTitle() {
        return mTitle;
    }

    public String getBookAuthor() {
        return mAuthor;
    }

    public String getBookImage() {
        return mImage;
    }

    public String getPageCount() {
        return Integer.toString(mPageCount);
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }
}
