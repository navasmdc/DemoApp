package com.gc.navigationinjector

interface NavigationManager {

    var currentOperation : Operation
    var currentState : BaseState
    var currentFragment : BaseFragment?
    var currentActivity : BaseActivity

    var initialState : BaseState?

    fun navigateTo(state : BaseState)

    fun navigateBack()


}