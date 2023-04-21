package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void mainActivityTest() {
        onView(allOf(withText("TAB 1"), isDisplayed()));
        onView(allOf(withText("TAB 2"), isDisplayed()));

        ViewInteraction textPage_1 = onView(
                allOf(withId(R.id.section_label), withText("Page: 1"),
                        withParent(allOf(withId(R.id.constraintLayout),
                                withParent(withId(R.id.view_pager)))),
                        isDisplayed()));
        textPage_1.check(matches(withText("Page: 1")));

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.constraintLayout),
                        withParent(allOf(withId(R.id.view_pager),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction linearLayout = onView(
                allOf(withContentDescription("Tab 1"),
                        withParent(withParent(withId(R.id.tabs))),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction tab_1 = onView(
                allOf(withText("Tab 1"), isDisplayed()));
        tab_1.check(matches(isDisplayed()));

        ViewInteraction tab_2 = onView(allOf(withContentDescription("Tab 2"),
                        isDescendantOfA(withId(R.id.tabs)),
                        isDisplayed()));
        tab_2.perform(click());

        ViewInteraction textPage_2 = onView(
                allOf(withId(R.id.section_label), withText("Page: 2"), isDisplayed()));
        textPage_2.check(matches(withText("Page: 2")));
    }
}
