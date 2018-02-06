package com.gc.demoapp.operations.globalposition

import com.gc.demoapp.AppActivity
import com.gc.navigationinjector.*
import kotlin.reflect.KClass

/**
 * Created by 674756 on 05/02/2018.
 */
class GlobalPositionOperation : Operation() {

    override fun Activity() : KClass<out BaseActivity> = AppActivity::class



}