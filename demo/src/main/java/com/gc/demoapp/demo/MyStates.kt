package com.gc.demoapp.demo

import com.gc.navigationinjector.BaseState
import com.gc.navigationinjector.BaseViewModel
import com.gc.navigationinjector.MyOperation
import com.gc.navigationinjector.State

enum class MyStates : BaseState{

    @State(Operation = MyOperation::class, ViewModel = BaseViewModel::class, Activity = MainActivity::class)
    LOGIN,
    @State(Operation = MyOperation::class, ViewModel = BaseViewModel::class)
    GLOBAL_POSITION

}