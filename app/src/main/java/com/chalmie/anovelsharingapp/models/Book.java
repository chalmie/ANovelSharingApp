package com.chalmie.anovelsharingapp.models;

import org.parceler.Parcel;

/**
 * Created by chalmie on 4/29/16.
 */
@Parcel
public class Book {
    String title;
    String author;
    String image;
    int pageCount;
    String publishedDate;

    public Book() {}

    public Book(String title, String author, String image, int pageCount, String publishedDate) {
        this.title = title;
        this.author = author;
        this.image = image;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public String getPageCount() {
        return Integer.toString(pageCount);
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}
