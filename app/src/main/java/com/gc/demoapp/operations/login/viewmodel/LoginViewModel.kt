package com.gc.demoapp.operations.login.viewmodel

import android.view.View
import com.gc.demoapp.*
import com.gc.navigationinjector.BaseViewModel

/**
 * Created by 674756 on 05/02/2018.
 */
class LoginViewModel : BaseViewModel() {

    override fun getLayout() : Int = R.layout.login_state

    fun doLogin(v : View){
        navigationManager.navigateTo(MyStates.PRODUCT_LIST)
    }

}