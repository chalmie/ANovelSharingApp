package com.chalmie.anovelsharingapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalmie.anovelsharingapp.Constants;
import com.chalmie.anovelsharingapp.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.profileImageView) ImageView mProfileImageView;
    @Bind(R.id.libraryButton) Button mLibraryButton;
    @Bind(R.id.sharedBooksButton) Button mSharedBooksButton;
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.welcomeTextView) TextView mWelcomeTextView;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);

        Intent intent = getIntent();
        String userUid = intent.getStringExtra("userUid");
        mWelcomeTextView.setText("Welcome " + userUid + "!");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void logout() {
        mFirebaseRef.unauth();
        takeUserToLoginScreenOnUnAuth();
    }

    private void takeUserToLoginScreenOnUnAuth() {
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
