package com.gc.demoapp.operations.login

import com.gc.demoapp.PrivateActivity
import com.gc.navigationinjector.*
import kotlin.reflect.KClass

class InfoOperation : Operation() {

    override fun Activity() : KClass<out BaseActivity> = PrivateActivity::class

}