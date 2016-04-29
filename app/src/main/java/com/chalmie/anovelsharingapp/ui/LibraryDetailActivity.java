package com.chalmie.anovelsharingapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.adapters.BookPagerAdapter;
import com.chalmie.anovelsharingapp.models.Book;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LibraryDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private BookPagerAdapter adapterViewPager;
    ArrayList<Book> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_detail);
        ButterKnife.bind(this);

        mBooks = Parcels.unwrap(getIntent().getParcelableExtra("books"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new BookPagerAdapter(getSupportFragmentManager(), mBooks);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
