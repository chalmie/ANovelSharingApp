package com.chalmie.anovelsharingapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.chalmie.anovelsharingapp.R;
import com.chalmie.anovelsharingapp.models.Book;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.userLibraryListView) ListView mUserLibraryListView;
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.searchBookEditText) EditText mSearchBookEditText;
    public ArrayList<Book> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);



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
