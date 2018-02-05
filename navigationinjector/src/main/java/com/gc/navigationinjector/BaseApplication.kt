package com.gc.navigationinjector

import android.app.Application

abstract class BaseApplication : Application() {

    companion object {
        lateinit var instance : BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    abstract fun getStateByName(name : String) : BaseState

}