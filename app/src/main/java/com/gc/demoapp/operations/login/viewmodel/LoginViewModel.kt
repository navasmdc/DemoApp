package com.gc.demoapp.operations.login.viewmodel

import android.view.View
import com.gc.demoapp.*
import com.gc.demoapp.repository.IRepository
import com.gc.demoapp.repository.model.RequestLogin
import com.gc.navigationinjector.BaseViewModel

class LoginViewModel : ViewModelWithRepository {

    constructor()

    constructor(repository : IRepository)

    val requestLogin = RequestLogin()

    override fun getLayout() : Int = R.layout.login_state

    fun doLogin(v : View){
        viewManager.showProgressDialog()
        val response = repository.doLogin(requestLogin)
        viewManager.hideProgressDialog()
        if(response.isSuccessful) navigationManager.navigateTo(MyStates.PRODUCT_LIST)
        else{
            viewManager.showDialog(viewManager.getString(R.string.error_login_message))
        }
    }



}