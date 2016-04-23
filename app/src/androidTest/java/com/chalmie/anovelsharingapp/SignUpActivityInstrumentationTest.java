package com.chalmie.anovelsharingapp;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by chalmie on 4/23/16.
 */
public class SignUpActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<SignUpActivity> activityTestRule =
            new ActivityTestRule<>(SignUpActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.usernameEditText)).perform(typeText("testUsername")).check(matches(withText("testUsername")));
    }

    @Test
    public void usernameIsSentToProfileActivity() {
        String username = "testUsername";
        onView(withId(R.id.usernameEditText)).perform(typeText(username), closeSoftKeyboard());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.signUpButton)).perform(click());
        onView(withId(R.id.welcomeTextView)).check(matches(withText("Welcome " + username + "!")));
    }
}
