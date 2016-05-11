package com.chalmie.anovelsharingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.ui.LibraryActivity;
import com.chalmie.anovelsharingapp.util.ItemTouchHelperViewHolder;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chalmie on 5/4/16.
 */
public class BookViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;


    private Context mContext;
    private ArrayList<Book> mBooks = new ArrayList<>();

    public BookViewHolder(View itemView, ArrayList<Book> books) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mBooks = books;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, LibraryActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("books", Parcels.wrap(mBooks));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindBook(Book book) {

        mTitleTextView.setText(book.getTitle());
        mAuthorTextView.setText(book.getAuthor());
    }

    @Override
    public void onItemSelected() {
        //  Will add code for animations here later.
    }

    @Override
    public void onItemClear() {
        //  Will add code for removing animations here later.
    }
}
