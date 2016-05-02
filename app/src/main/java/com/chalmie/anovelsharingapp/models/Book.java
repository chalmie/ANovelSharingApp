package com.chalmie.anovelsharingapp.models;

import org.parceler.Parcel;

/**
 * Created by chalmie on 4/29/16.
 */
@Parcel
public class Book {
    String Title;
    String Author;
    String Image;
    int PageCount;
    String PublishedDate;

    public Book() {}

    public Book(String Title, String Author, String Image, int PageCount, String PublishedDate) {
        this.Title = Title;
        this.Author = Author;
        this.Image = Image;
        this.PageCount = PageCount;
        this.PublishedDate = PublishedDate;
    }


    public String getBookTitle() {
        return Title;
    }

    public String getBookAuthor() {
        return Author;
    }

    public String getBookImage() {
        return Image;
    }

    public String getPageCount() {
        return Integer.toString(PageCount);
    }

    public String getPublishedDate() {
        return PublishedDate;
    }
}
