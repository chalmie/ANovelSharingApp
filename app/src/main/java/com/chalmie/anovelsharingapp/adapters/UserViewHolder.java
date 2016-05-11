package com.chalmie.anovelsharingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.models.User;
import com.chalmie.anovelsharingapp.ui.LibraryActivity;
import com.chalmie.anovelsharingapp.ui.SearchActivity;
import com.chalmie.anovelsharingapp.util.ItemTouchHelperViewHolder;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chalmie on 5/11/16.
 */
public class UserViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.usernameTextView) TextView mUsernameTextView;
    private Context mContext;
    private ArrayList<User> mUsers = new ArrayList<>();

    public UserViewHolder(View itemView, ArrayList<User> users) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mUsers = users;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, SearchActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("users", Parcels.wrap(mUsers));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindUser(User user) {
        mUsernameTextView.setText(user.getUsername());
    }




}
