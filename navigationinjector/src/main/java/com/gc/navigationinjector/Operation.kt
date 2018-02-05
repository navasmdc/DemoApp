package com.gc.navigationinjector

import kotlin.reflect.KClass

abstract class Operation {

    fun onStateChanged(continueNavigation : () -> Unit){
        continueNavigation()
    }

    abstract fun Activity() : KClass<out BaseActivity>
}