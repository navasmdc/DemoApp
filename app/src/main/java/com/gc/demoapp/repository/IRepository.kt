package com.gc.demoapp.repository

import com.gc.demoapp.repository.model.*
import retrofit2.Response

/**
 * Created by 674756 on 05/02/2018.
 */
interface IRepository {

    var globalPosition : GlobalPosition?
    var selectedProduct : Product?

    fun doLogin(reuest : RequestLogin?, callback : CustomCallBack<ResponseLogin?>? )

    fun doGetGlobalPosition(callBack : CustomCallBack<GlobalPosition?>?)

}