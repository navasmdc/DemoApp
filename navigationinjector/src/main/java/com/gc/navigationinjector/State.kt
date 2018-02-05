package com.gc.navigationinjector

import kotlin.reflect.KClass

/**
 * Created by 674756 on 05/02/2018.
 */
annotation class State(
        val Operation : KClass<out Operation>,
        val ViewModel : KClass<out BaseViewModel>,
        val Activity : KClass<out BaseActivity> = BaseActivity.Default :: class,
        val Fragment : KClass<out BaseFragment> = BaseFragment.Default :: class
)