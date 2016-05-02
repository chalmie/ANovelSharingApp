package com.chalmie.anovelsharingapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.chalmie.anovelsharingapp.Constants;
import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.searchBookEditText) EditText mSearchBookEditText;
    public ArrayList<Book> mBooks = new ArrayList<>();
    private Firebase mSearchedBookRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
//        Firebase mSearchedBookRef = new Firebase(Constants.FIREBASE_URL_ADDED_BOOK);
//
//        mSearchedBookRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String books = dataSnapshot.getValue().toString();
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title = mSearchBookEditText.getText().toString();
        Intent putIntent = new Intent(LibraryActivity.this, LibraryListActivity.class);
        putIntent.putExtra("title", title);
        startActivity(putIntent);
    }

}
