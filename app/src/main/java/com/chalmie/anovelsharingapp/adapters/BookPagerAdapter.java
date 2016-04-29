package com.chalmie.anovelsharingapp.adapters;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by chalmie on 4/29/16.
 */
public class BookPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Book> mBooks;

    public BookPagerAdapter(FragmentManager fm, ArrayList<Book> books) {
        super(fm);
        mBooks = books;
    }


}
