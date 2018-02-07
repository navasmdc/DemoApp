package com.gc.demoapp.operations.login.viewmodel

import android.databinding.ObservableBoolean
import android.support.design.widget.*
import android.view.View
import android.widget.EditText
import com.gc.demoapp.*
import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.RequestLogin
import com.gc.demoapp.utils.*
import com.gc.navigationinjector.BaseViewModel

class LoginViewModel : ViewModelWithRepository {

    constructor()

    constructor(repository : IRepository)

    override fun getLayout() : Int = R.layout.login_state

    val requestLogin = RequestLogin()

    var buttonEnabled = ObservableBoolean(false)

    var textChangedListenr = TextChangedListener(textChanged = {
        validateUserAndPass()
    })

    fun validateUserAndPass(){
        buttonEnabled.set(requestLogin.user.isUserValid() && requestLogin.password.isPasswordValid())
    }

    fun doLogin(v : View){
        viewManager.showProgressDialog()
        val response = repository.doLogin(requestLogin, CustomCallBack {
            viewManager.hideProgressDialog()
            if(it.isSuccessful) navigationManager.navigateTo(MyStates.PRODUCT_LIST)
            else viewManager.showDialog("Error")
        })
    }





}