package com.gc.demoapp

import android.os.Bundle
import com.gc.navigationinjector.*

class AppActivity : BaseActivity() {

    override var initialState : BaseState? = MyStates.LOGIN

    override fun getFragmentContainer() : Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_app)
        super.onCreate(savedInstanceState)
    }


}
