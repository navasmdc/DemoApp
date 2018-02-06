package com.gc.navigationinjector

abstract class BaseViewModel {

    lateinit var navigationManager : NavigationManager
    lateinit var viewManager : ViewManager

    abstract fun getLayout() : Int

    //region LifeCycle
    fun onCreate(){}
    fun onResume(){}
    fun onPause(){}
    fun onDestroy(){}
    //endregion


}