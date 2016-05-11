package com.chalmie.anovelsharingapp.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.chalmie.anovelsharingapp.Constants;
import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.models.User;
import com.chalmie.anovelsharingapp.util.FirebaseRecyclerAdapter;
import com.chalmie.anovelsharingapp.util.ItemTouchHelperAdapter;
import com.chalmie.anovelsharingapp.util.OnStartDragListener;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.util.Collections;

/**
 * Created by chalmie on 5/11/16.
 */
public class FirebaseUserListAdapter extends FirebaseRecyclerAdapter<UserViewHolder, User> {

    private Context mContext;

    public FirebaseUserListAdapter(Query query, Class<User> itemClass) {
        super(query, itemClass);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {
        holder.bindUser(getItem(position));
    }


    @Override
    protected void itemAdded(User item, String key, int position) {

    }

    @Override
    protected void itemChanged(User oldItem, User newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(User item, String key, int position) {

    }

    @Override
    protected void itemMoved(User item, String key, int oldPosition, int newPosition) {

    }
}
