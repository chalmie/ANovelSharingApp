package com.chalmie.anovelsharingapp;

/**
 * Created by chalmie on 4/26/16.
 */
public class Constants {
    //GoogleBooksApi
    public static final String API_KEY = BuildConfig.API_KEY;

    //Firebase
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;

    //Firebase UserLibrary
    public static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes";
    public static final String BOOK_QUERY_TITLE_PARAMETER = "q";
    public static final String FIREBASE_BOOKS = "books";
    public static final String FIREBASE_URL_ADDED_BOOK = FIREBASE_URL + FIREBASE_BOOKS;

    //Firebase users
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
}
