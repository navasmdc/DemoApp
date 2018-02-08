package com.gc.demoapp.login

import com.gc.demoapp.*
import com.gc.demoapp.operations.login.viewmodel.LoginViewModel
import com.gc.demoapp.repository.CustomCallBack
import com.gc.demoapp.repository.mock.MockRepository
import com.gc.demoapp.repository.model.*
import org.junit.*
import org.junit.Assert.assertFalse
import org.mockito.*
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*
import javax.security.auth.callback.Callback

class LoginViewModelTest : ViewModelTest() {

    lateinit var viewModel : LoginViewModel

    @Before
    override fun setupTest() {
        super.setupTest()
        repository = Mockito.mock(RepositoryForTest::class.java, Mockito.CALLS_REAL_METHODS)
        viewModel = LoginViewModel(repository)
        viewModel.viewManager = viewManager
        viewModel.navigationManager = navigationManager
    }

    // CONSTANTS
    val USER = "50289527G"
    val WRONG_USER = "503ADE986"
    val PASSWORD = "1234"
    val WRONG_PASSWORD = "12"

    @Test
    fun invalidUser(){
        viewModel.requestLogin.user = WRONG_USER
        viewModel.requestLogin.password = PASSWORD
        assertFalse(viewModel.buttonEnabled.get())
    }

    @Test
    fun invalidPassword(){
        viewModel.requestLogin.user = USER
        viewModel.requestLogin.password = WRONG_PASSWORD
        assertFalse(viewModel.buttonEnabled.get())
    }

    @Test
    fun validUserAndPassword(){
        viewModel.requestLogin.user = USER
        viewModel.requestLogin.password = PASSWORD
        assert(viewModel.buttonEnabled.get())
    }

    @Test
    fun doLogin(){
        viewModel.requestLogin.user = USER
        viewModel.requestLogin.password = PASSWORD
        viewModel.doLogin(null)
        verify(viewManager).showProgressDialog()
        val clazz = CustomCallBack<ResponseLogin>(action = {})::class.java
        verify(repository).doLogin(viewModel.requestLogin, viewModel.requestCallback)
        verify(viewManager).hideProgressDialog()
        verify(navigationManager).navigateTo(MyStates.PRODUCT_LIST)
    }




}