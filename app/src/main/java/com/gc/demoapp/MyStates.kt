package com.gc.demoapp

import com.gc.demoapp.operations.globalposition.GlobalPositionOperation
import com.gc.demoapp.operations.globalposition.viewmodel.*
import com.gc.demoapp.operations.login.InfoOperation
import com.gc.demoapp.operations.info.viewmodel.InfoViewModel
import com.gc.demoapp.operations.login.LoginOperation
import com.gc.demoapp.operations.login.viewmodel.LoginViewModel
import com.gc.navigationinjector.*

enum class MyStates : BaseState{

    @State(Operation = LoginOperation::class, ViewModel = LoginViewModel::class)
    LOGIN,
    @State(Operation = GlobalPositionOperation::class, ViewModel = ProductListViewModel::class)
    PRODUCT_LIST,
    @State(Operation = GlobalPositionOperation::class, ViewModel = ProductDetailViewModel::class)
    PRODUCT_DETAIL,
    @State(Operation = InfoOperation::class, ViewModel = InfoViewModel::class)
    INFO

}