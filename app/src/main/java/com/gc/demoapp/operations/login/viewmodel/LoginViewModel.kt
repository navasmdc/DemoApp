package com.gc.demoapp.operations.login.viewmodel

import android.view.View
import com.gc.demoapp.*
import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.RequestLogin
import com.gc.navigationinjector.BaseViewModel

class LoginViewModel : ViewModelWithRepository {

    constructor()

    constructor(repository : IRepository)

    val requestLogin = RequestLogin()

    override fun getLayout() : Int = R.layout.login_state

    fun doLogin(v : View){
        viewManager.showProgressDialog()
        val response = repository.doLogin(requestLogin, CustomCallBack {
            viewManager.hideProgressDialog()
            if(it.isSuccessful) navigationManager.navigateTo(MyStates.PRODUCT_LIST)
            else viewManager.showDialog("Error")
        })
    }



}