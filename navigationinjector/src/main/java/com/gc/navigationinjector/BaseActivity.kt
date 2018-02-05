package com.gc.navigationinjector

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open abstract class BaseActivity : AppCompatActivity(), NavigationManager {

    companion object {
        const val NEXT_STATE = "nexState"
    }

    abstract class Default : BaseActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //region NavigationManager implementation

    override lateinit var  currentOperation: Operation

    override lateinit var currentState: BaseState

    override var currentActivity: BaseActivity = this

    override var currentFragment: BaseFragment? = null

    override var initialState: BaseState? = null

    override fun navigateTo(state: BaseState) {
        switchState(state)
    }

    override fun navigateBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun switchState(state : BaseState){

    }

    //endregion

    fun <T> generateInstance(clazz : Class<T>) : T {
        clazz.newInstance()
    }

}