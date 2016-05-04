package com.chalmie.anovelsharingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by chalmie on 5/4/16.
 */
public class FirebaseBookListAdapter extends FirebaseRecyclerAdapter<BookViewHolder, Book> {

    public FirebaseBookListAdapter(Query query, Class<Book> itemClass) {
        super(query, itemClass);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.bindBook(getItem(position));
    }

    @Override
    protected void itemAdded(Book item, String key, int position) {

    }

    @Override
    protected void itemChanged(Book oldItem, Book newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Book item, String key, int position) {

    }

    @Override
    protected void itemMoved(Book item, String key, int oldPosition, int newPosition) {

    }
}
