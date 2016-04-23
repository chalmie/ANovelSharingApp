package com.chalmie.anovelsharingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.profileImageView) ImageView mProfileImageView;
    @Bind(R.id.libraryButton) Button mLibraryButton;
    @Bind(R.id.sharedBooksButton) Button mSharedBooksButton;
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.welcomeTextView) TextView mWelcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mWelcomeTextView.setText("Welcome " + username + "!");

        mLibraryButton.setOnClickListener(this);
        mSharedBooksButton.setOnClickListener(this);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLibraryButton) {
            Intent intent = new Intent(ProfileActivity.this, LibraryActivity.class);
            startActivity(intent);
        } else if (v == mSharedBooksButton) {
            Intent intent = new Intent(ProfileActivity.this, SharedBooksActivity.class);
            startActivity(intent);
        } else if (v == mSearchButton) {
            Intent intent = new Intent(ProfileActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }
}
