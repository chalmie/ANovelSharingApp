package com.chalmie.anovelsharingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity {
    @Bind(R.id.userLibraryListView) ListView mUserLibraryListView;
    private String[] userBooks = new String[] {"A Confederacy of Dunces", "The Idiot", "Candide", "Infinite Jest", "Oliver Twist", "The Trial", "The Picture of Dorian Gray"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, userBooks);
        mUserLibraryListView.setAdapter(adapter);
    }
}
