package com.chalmie.anovelsharingapp;

import android.os.Build;
import android.widget.Button;

import com.chalmie.anovelsharingapp.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

/**
 * Created by chalmie on 4/22/16.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateButtonTextContent() {
        Button startSharingButton = (Button) activity.findViewById(R.id.startSharingbutton);
        assertTrue("Start Sharing!".equals(startSharingButton.getText().toString()));
    }

}
