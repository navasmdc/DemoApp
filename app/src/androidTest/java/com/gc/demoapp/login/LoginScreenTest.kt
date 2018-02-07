package com.gc.demoapp.login

import android.content.Intent
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.gc.demoapp.*
import com.gc.navigationinjector.BaseActivity
import com.gc.navigationinjector.DialogManager
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.not
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginScreenTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<AppActivity>(AppActivity::class.java,true, false)

    // CONSTANTS
    val USER = "50289527G"
    val WRONG_USER = "503ADE986"
    val PASSWORD = "1234"
    val WRONG_PASSWORD = "12"

    @Before
    fun setupTest(){
        var intent = Intent()
        intent.putExtra(BaseActivity.NEXT_STATE,MyStates.LOGIN.name)
        activity.launchActivity(intent)
    }


    @Test fun Input_invalid_user_disabled_login_button(){
        // Input the invalid user
        onView(withId(R.id.ed_user))
                .perform(typeText(WRONG_USER))
        // Input the password
        onView(withId(R.id.ed_pass))
                .perform(typeText(PASSWORD), closeSoftKeyboard())
        // Check if the button keeps disabled
        onView(withId(R.id.btn_login))
                .check(matches(not(isEnabled())))
    }

    @Test fun Input_invalid_password_disabled_login_button(){
        // Input the  user
        onView(withId(R.id.ed_user))
                .perform(typeText(USER))
        // Input the invalid password
        onView(withId(R.id.ed_pass))
                .perform(typeText(WRONG_PASSWORD), closeSoftKeyboard())
        // Check if the button keeps disabled
        onView(withId(R.id.btn_login))
                .check(matches(not(isEnabled())))
    }

    @Test fun Input_valid_user_and_password_enabled_login_button(){
        // Input the  user
        onView(withId(R.id.ed_user))
                .perform(typeText(USER))
        // Input the invalid password
        onView(withId(R.id.ed_pass))
                .perform(typeText(PASSWORD), closeSoftKeyboard())
        // Check if the button is enabled
        onView(withId(R.id.btn_login))
                .check(matches(isEnabled()))
    }

    @Test fun Input_valid_user_and_password_enabled_and_click_login_button_do_login(){
        // Input the  user
        onView(withId(R.id.ed_user))
                .perform(typeText(USER))
        // Input the invalid password
        onView(withId(R.id.ed_pass))
                .perform(typeText(PASSWORD), closeSoftKeyboard())
        // CLick the button
        onView(withId(R.id.btn_login))
                .perform(click())
        // Check if the progress bar was displayed because the call to the webservice was called
        onView(withId(DialogManager.PROGRESS_ID))
                .check(matches(isDisplayed()))
    }

}