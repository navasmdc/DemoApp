package com.gc.demoapp.utils

import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import com.gc.demoapp.repository.model.Product
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class CustomMatchers {
    companion object {

        fun withNumber(number : String) : Matcher<*>{
            return  object : TypeSafeMatcher<Product>(){
                override fun describeTo(description: Description?) {
                }

                override fun matchesSafely(item: Product?): Boolean = item?.getNumber().equals(number)
            }
        }

        fun withName(name : String) : Matcher<*>{
            return  object : TypeSafeMatcher<Product>(){
                override fun describeTo(description: Description?) {
                }

                override fun matchesSafely(item: Product?): Boolean = item?.getName().equals(name)
            }
        }

        fun withContentDescription(description : String) : Matcher<View> {
            return object : TypeSafeMatcher<View>(){
                override fun describeTo(description: Description?) {}

                override fun matchesSafely(item: View?): Boolean = description.equals(item?.contentDescription)

            }
        }

    }
}