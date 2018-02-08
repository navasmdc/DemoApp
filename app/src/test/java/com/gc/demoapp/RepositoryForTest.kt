package com.gc.demoapp

import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.*
import retrofit2.Response

/**
 * Created by 674756 on 08/02/2018.
 */
class RepositoryForTest : IRepository {
    override var globalPosition : GlobalPosition? = null
    override var selectedProduct : Product? = null

    override fun doLogin(reuest : RequestLogin?,
                         callback : CustomCallBack<ResponseLogin?>?
    ) {
        callback?.action?.invoke(Response.success(null))
    }

    override fun doGetGlobalPosition(callBack : CustomCallBack<GlobalPosition?>?) {
        callBack?.action?.invoke(Response.success(null))
    }
}