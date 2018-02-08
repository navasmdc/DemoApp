package com.gc.demoapp.globalposition

import android.content.Intent
import android.provider.Telephony.Carriers.PASSWORD
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.gc.demoapp.*
import com.gc.demoapp.repository.CustomCallBack
import com.gc.demoapp.repository.model.Product
import com.gc.demoapp.utils.CustomMatchers.Companion.withContentDescription
import com.gc.demoapp.utils.CustomMatchers.Companion.withName
import com.gc.demoapp.utils.CustomMatchers.Companion.withNumber
import com.gc.navigationinjector.BaseActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ProductDetailScreenTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<PrivateActivity>(PrivateActivity::class.java,true, false)

    val ALIAS = "NEW ALIAS"

    @Before
    fun setupTest(){
        // Prepare the repository for the test
        MyApplication.appComponent.repository().doGetGlobalPosition(CustomCallBack {
            MyApplication.appComponent.repository().selectedProduct = it?.body()!!.accounts[2]
            var intent = Intent()
            intent.putExtra(BaseActivity.NEXT_STATE, MyStates.PRODUCT_DETAIL.name)
            Thread({activity.launchActivity(intent)}).start()
        })

    }

    @Test
    fun Change_alias(){
        onView(withId(R.id.ed_product_name))
                .perform(typeText(ALIAS))
        onView(withId(R.id.btn_save_product))
                .perform(click())
        onView(withId(R.id.lvProducts))
                .check(matches(isDisplayed()))

    }


}