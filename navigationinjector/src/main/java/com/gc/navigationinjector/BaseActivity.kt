package com.gc.navigationinjector

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open abstract class BaseActivity : AppCompatActivity(), NavigationManager {

    companion object {
        const val NEXT_STATE = "nexState"
    }

    abstract class Default : BaseActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentState = initialState
                ?: BaseApplication.instance.getStateByName(intent.getStringExtra(NEXT_STATE))
        currentOperation = currentState.Operation().java.newInstance()
        switchState(currentState)
    }

    abstract fun getFragmentContainer() : Int

    //region NavigationManager implementation

    override lateinit var  currentOperation: Operation

    override lateinit var currentState: BaseState

    override var currentActivity: BaseActivity = this

    override var currentFragment: BaseFragment? = null

    open var initialState: BaseState? = null

    override fun navigateTo(state: BaseState) {
        switchState(state)
    }

    override fun navigateBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun switchState(state : BaseState){
        var nextOperation = currentOperation
        if(!currentOperation.javaClass.equals(state.Operation()))
            nextOperation = state.Operation().java.newInstance()
        nextOperation.onStateChanged {
            if(!javaClass.equals(state.Activity().java) && !state.Activity().java.equals(Default::class.java)){
                val intent = Intent(this, state.Activity().java)
                intent.putExtra(NEXT_STATE, (state as Enum<*>).name)
                startActivity(intent)
                finish()
            }else {
                currentOperation = nextOperation
                currentFragment = state.Fragment().java.newInstance()
                currentFragment?.navigationManager = this
                currentFragment?.viewModel = state.ViewModel().java.newInstance()
                supportFragmentManager
                        .beginTransaction()
                        .replace(getFragmentContainer(),currentFragment)
                        .commitNowAllowingStateLoss()
            }
        }
    }

    //endregion
}