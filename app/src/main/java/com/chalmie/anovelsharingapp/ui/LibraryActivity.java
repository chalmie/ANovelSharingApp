package com.chalmie.anovelsharingapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.searchBookEditText) EditText mSearchBookEditText;
    private Query mQuery;
    public ArrayList<Book> mBooks = new ArrayList<>();
    private Firebase mSearchedBookRef;
    private ValueEventListener mSearchedBookRefListener;
    private FirebaseBookListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
        mSearchedBookRef = new Firebase(Constants.FIREBASE_URL_ADDED_BOOK);
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
        mQuery = new Firebase(book);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseBookListAdapter(mQuery, Book.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

}
