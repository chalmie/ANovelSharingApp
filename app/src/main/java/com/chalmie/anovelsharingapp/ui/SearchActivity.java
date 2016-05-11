package com.chalmie.anovelsharingapp.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.chalmie.anovelsharingapp.Constants;
import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.adapters.FirebaseBookListAdapter;
import com.chalmie.anovelsharingapp.adapters.FirebaseUserListAdapter;
import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.models.User;
import com.chalmie.anovelsharingapp.util.SimpleItemTouchHelperCallback;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private Query mQuery;
    private Firebase mSearchedUserRef;
    private ValueEventListener mSearchedUserRefListener;
    private FirebaseUserListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        mSearchedUserRef = new Firebase(Constants.FIREBASE_URL_USERS);
        setUpFirebaseQuery();
        setUpRecyclerView();

        mSearchedUserRefListener = mSearchedUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null) {
                    String users = dataSnapshot.getValue().toString();
                    Log.d("Users updated", users);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mSearchedUserRef.removeEventListener(mSearchedUserRefListener);
    }

    private void setUpFirebaseQuery() {
        String user = mSearchedUserRef.toString();
        mQuery = new Firebase(user);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseUserListAdapter(mQuery, User.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
