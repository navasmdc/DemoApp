package com.gc.demoapp.demo

import android.os.Bundle
import android.util.Log
import com.gc.navigationinjector.BaseActivity
import com.gc.navigationinjector.isDefault

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("Operation -> ", MyStates.LOGIN.Fragment().isDefault().toString())
    }


}
