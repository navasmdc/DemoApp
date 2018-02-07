package com.gc.navigationinjector

import kotlin.reflect.KClass

abstract class Operation {

    open fun onStateChanged(currentState : BaseState, nextState: BaseState, continueNavigation : () -> Unit){
        continueNavigation()
    }

    abstract fun Activity() : KClass<out BaseActivity>
}