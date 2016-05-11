package com.chalmie.anovelsharingapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.chalmie.anovelsharingapp.Constants;
import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.adapters.FirebaseBookListAdapter;
import com.chalmie.anovelsharingapp.models.Book;
import com.chalmie.anovelsharingapp.util.OnStartDragListener;
import com.chalmie.anovelsharingapp.util.SimpleItemTouchHelperCallback;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener, OnStartDragListener {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.searchBookEditText) EditText mSearchBookEditText;
    private Query mQuery;
    public ArrayList<Book> mBooks = new ArrayList<>();
    private Firebase mSearchedBookRef;
    private ValueEventListener mSearchedBookRefListener;
    private FirebaseBookListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(LibraryActivity.this);

        mSearchedBookRef = new Firebase(Constants.FIREBASE_URL_USERS + "/" + mSharedPreferences.getString("UID", "WRONG") + "/" + Constants.FIREBASE_BOOKS);
        setUpFirebaseQuery();
        setUpRecyclerView();

        mSearchedBookRefListener = mSearchedBookRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null) {
                    String books = dataSnapshot.getValue().toString();
                    Log.d("Books updated", books);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mSearchButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mSearchedBookRef.removeEventListener(mSearchedBookRefListener);
    }

    @Override
    public void onClick(View v) {
        String title = mSearchBookEditText.getText().toString();
        Intent putIntent = new Intent(LibraryActivity.this, LibraryListActivity.class);
        putIntent.putExtra("title", title);
        startActivity(putIntent);
    }

    private void setUpFirebaseQuery() {
        String book = mSearchedBookRef.toString();
        mQuery = new Firebase(book).orderByChild("title");
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseBookListAdapter(mQuery, Book.class, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

}
