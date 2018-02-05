package com.gc.navigationinjector

interface BaseState {

    fun Operation() = getAnnotation()!!.Operation

    fun ViewModel() = getAnnotation()!!.ViewModel

    fun Activity() = getAnnotation()!!.Activity

    fun Fragment() = getAnnotation()!!.Fragment

    private fun getAnnotation() : State?{
        javaClass.fields
                .filter { (it.get(this) as Enum<*>).name == (this as Enum<*>).name }
                .forEach {
                    it.annotations.filter { it is State }
                            .forEach {
                                return it as State
                            }
                }
        return null
    }
}