package com.chalmie.anovelsharingapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.ui.LibraryDetailFragment;

import java.util.ArrayList;

/**
 * Created by chalmie on 4/29/16.
 */
public class BookPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Book> mBooks;

    public BookPagerAdapter(FragmentManager fm, ArrayList<Book> books) {
        super(fm);
        mBooks = books;
    }

    @Override
    public Fragment getItem(int position) {
        return LibraryDetailFragment.newInstance(mBooks.get(position));
    }

    @Override
    public int getCount() {
        return mBooks.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBooks.get(position).getTitle();
    }

}
