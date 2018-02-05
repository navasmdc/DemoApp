package com.gc.navigationinjector

interface NavigationManager {

    var currentOperation : Operation
    var currentState : BaseState
    var currentFragment : BaseFragment?
    var currentActivity : BaseActivity

    fun navigateTo(state : BaseState)

    fun navigateBack()


}