package com.gc.demoapp.info

import android.content.Intent
import com.gc.demoapp.ViewModelTest
import com.gc.demoapp.operations.info.viewmodel.InfoViewModel
import com.gc.demoapp.operations.login.viewmodel.LoginViewModel
import org.junit.*
import org.mockito.ArgumentMatchers.any

/**
 * Created by 674756 on 08/02/2018.
 */
class InfoViewModelTest : ViewModelTest() {

    lateinit var viewModel : InfoViewModel

    @Before
    override fun setupTest() {
        super.setupTest()
        viewModel = InfoViewModel()
        viewModel.viewManager = viewManager
        viewModel.navigationManager = navigationManager
    }

    @Test
    fun openRepoLink(){
        viewModel.openLink(null)
        var clazz = Intent::class.java
        viewManager.launchActivity(any(clazz))
    }
}