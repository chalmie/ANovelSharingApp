package com.chalmie.anovelsharingapp;

import android.os.Build;
import android.widget.ListView;

import com.chalmie.anovelsharingapp.ui.LibraryActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by chalmie on 4/23/16.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class LibraryActivityTest {
    private LibraryActivity activity;
    private ListView mUserLibraryListView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(LibraryActivity.class);
        mUserLibraryListView = (ListView) activity.findViewById(R.id.userLibraryListView);
    }

    @Test
    public void userLibraryListViewPopulates() {
        assertNotNull(mUserLibraryListView.getAdapter());
        assertEquals(mUserLibraryListView.getAdapter().getCount(), 7);
    }
}
