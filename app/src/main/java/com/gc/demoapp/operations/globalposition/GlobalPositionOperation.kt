package com.gc.demoapp.operations.globalposition

import com.gc.demoapp.*
import com.gc.demoapp.repository.*
import com.gc.navigationinjector.*
import kotlin.reflect.KClass

class GlobalPositionOperation : Operation() {

    val repository : IRepository = MyApplication.appComponent.repository()

    override fun Activity() : KClass<out BaseActivity> = AppActivity::class

    override fun onStateChanged(currentState : BaseState, nextState: BaseState, continueNavigation: () -> Unit) {

        when(nextState as MyStates){
            MyStates.PRODUCT_LIST-> {
                if(currentState == MyStates.LOGIN){
                    repository.doGetGlobalPosition(CustomCallBack { if(it.isSuccessful) continueNavigation()})
                }else continueNavigation()
            }
            else -> continueNavigation()
        }

    }

}