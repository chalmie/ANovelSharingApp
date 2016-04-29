package com.chalmie.anovelsharingapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryDetailFragment extends Fragment {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    @Bind(R.id.titleTextView) TextView mTitleTextView;

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
        mTitleTextView.setText(mBook.getBookTitle());
        return inflater.inflate(R.layout.fragment_library_detail, container, false);
    }

}
