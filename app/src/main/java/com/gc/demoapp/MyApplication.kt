package com.gc.demoapp

import com.gc.demoapp.injection.*
import com.gc.navigationinjector.*

/**
 * Created by 674756 on 05/02/2018.
 */
class MyApplication : BaseApplication(){

    companion object {
        lateinit var appComponent : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }

    override fun getStateByName(name : String) : BaseState = MyStates.valueOf(name)

}