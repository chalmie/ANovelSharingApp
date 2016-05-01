package com.chalmie.anovelsharingapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalmie.anovelsharingapp.Constants;
import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;
import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.bookImageView) ImageView mBookImageView;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;
    @Bind(R.id.pageCountTextView) TextView mPageCountTextView;
    @Bind(R.id.publishedDateTextView) TextView mPublishedDateTextView;
    @Bind(R.id.addBookButton) Button mAddBookButton;


    private Book mBook;

    public LibraryDetailFragment() {
        // Required empty public constructor
    }

    public static LibraryDetailFragment newInstance(Book book) {
        LibraryDetailFragment libraryDetailFragment = new LibraryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("book", Parcels.wrap(book));
        libraryDetailFragment.setArguments(args);
        return libraryDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = Parcels.unwrap(getArguments().getParcelable("book"));


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library_detail, container, false);
        ButterKnife.bind(this,view);
        Picasso.with(view.getContext()).load(mBook.getBookImage()).into(mBookImageView);
        mTitleTextView.setText(mBook.getBookTitle());
        mAuthorTextView.setText("Author: " + mBook.getBookAuthor());
        mPageCountTextView.setText("Pages: " + mBook.getPageCount());
        mPublishedDateTextView.setText("Published Date: " + mBook.getPublishedDate());
        mAddBookButton.setOnClickListener(this);
        return view;
    }

    public void saveLocationToFirebase(Book book) {
        Firebase searchedBookRef = new Firebase(Constants.FIREBASE_URL_ADDED_BOOK);
        searchedBookRef.push().setValue(book);
    }

    @Override
    public void onClick(View v) {
        if (v == mAddBookButton) {
            saveLocationToFirebase(mBook);
            Intent intent = new Intent(getActivity(), LibraryActivity.class);
            startActivity(intent);
        }
    }

}
