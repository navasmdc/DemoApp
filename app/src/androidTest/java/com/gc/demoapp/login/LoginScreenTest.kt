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
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.not
import org.junit.*
import org.junit.runner.RunWith

/**
 * Created by 674756 on 07/02/2018.
 */
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


    @Test fun `Input invalid user disabled login button`(){
        onView(withId(R.id.ed_user))
                .perform(typeText(WRONG_USER))
        onView(withId(R.id.ed_pass))
                .perform(typeText(PASSWORD))
        onView(withId(R.id.btn_login))
                .check(matches(not(isEnabled())))
    }

    @Test fun `Input invalid password disabled login button`(){
        onView(withId(R.id.ed_user))
                .perform(typeText(USER))
        onView(withId(R.id.ed_pass))
                .perform(typeText(WRONG_PASSWORD))
        onView(withId(R.id.btn_login))
                .check(matches(not(isEnabled())))
    }

    @Test fun `Input valid user and password enabled login button`(){
        onView(withId(R.id.ed_user))
                .perform(typeText(USER))
        onView(withId(R.id.ed_pass))
                .perform(typeText(PASSWORD))
        onView(withId(R.id.btn_login))
                .check(matches(isEnabled()))
    }

    @Test fun `Input valid user and password enabled and click login button do login`(){
        onView(withId(R.id.ed_user))
                .perform(typeText(USER))
        onView(withId(R.id.ed_pass))
                .perform(typeText(PASSWORD))
        onView(withId(R.id.btn_login))
                .perform(click())
        onView(withId(R.id.tvUserName))
                .check(matches(isDisplayed()))
    }

}