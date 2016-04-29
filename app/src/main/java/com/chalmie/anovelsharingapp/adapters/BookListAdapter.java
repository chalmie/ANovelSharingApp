package com.chalmie.anovelsharingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chalmie.anovelsharingapp.models.Book;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chalmie on 4/29/16.
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    private ArrayList<Book> mBooks = new ArrayList<>();
    private Context mContext;

    public BookListAdapter(Context context, ArrayList<Book> books) {
        mContext = context;
        mBooks = books;
    }

    @Override
    public void onBindViewHolder(BookListAdapter.BookViewHolder holder, int position) {
        holder.bindBook(mBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.titleTextView) TextView mBookTextView;
        private Context mContext;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, LibraryListDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                    intent.putExtra("books", Parcels.wrap(mBooks));
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindBook(Book book) {
            mBookTextView.setText(book.getBookTitle());
        }
    }
}
