package com.gc.demoapp.info

import android.app.Instrumentation
import android.content.Intent
import android.provider.Telephony.Carriers.PASSWORD
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.gc.demoapp.*
import com.gc.demoapp.repository.CustomCallBack
import com.gc.demoapp.repository.model.Product
import com.gc.demoapp.utils.CustomMatchers.Companion.withContentDescription
import com.gc.demoapp.utils.CustomMatchers.Companion.withNumber
import com.gc.navigationinjector.BaseActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class InfoScreenTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<PrivateActivity>(PrivateActivity::class.java, true, false)

    @Before
    fun setupTest() {
        Intents.init()
        var intent = Intent()
        intent.putExtra(BaseActivity.NEXT_STATE, MyStates.INFO.name)
        activity.launchActivity(intent)
    }

    @After fun finishTest() = Intents.release()

    @Test
    fun Launch_browser() {
        // Catch the intent when will be launched
        var matcher = allOf(hasAction(Intent.ACTION_VIEW))
        intending(matcher).respondWith(Instrumentation.ActivityResult(0, null))
        // Click the url
        onView(withId(R.id.tvURL))
                .perform(click())
        // Check if the browser was launched
        intended(matcher)
    }

}