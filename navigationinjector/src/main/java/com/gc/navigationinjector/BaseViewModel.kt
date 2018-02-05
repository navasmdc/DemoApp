package com.gc.navigationinjector

abstract class BaseViewModel {

    lateinit var navigationManager : NavigationManager

    abstract fun getLayout() : Int

    //region LifeCycle
    fun onCreate(){}
    fun onResume(){}
    fun onPause(){}
    fun onDestroy(){}
    //endregion


}