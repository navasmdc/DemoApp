package com.gc.demoapp.repository.remote

import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.*

open class Repository(var api : Api) : IRepository {


    var tokenCredential : String = ""

    override var globalPosition : GlobalPosition? = null

    override var selectedProduct : Product? = null

    override fun doLogin(reuest : RequestLogin?, callback : CustomCallBack<ResponseLogin?>?) {
        api.doLogin(reuest!!).enqueue(CustomCallBack<ResponseLogin?>(action = {
            if(it != null && it.isSuccessful) tokenCredential = it.body()?.tokenCredential!!
            callback?.action?.invoke(it)
        }))
    }

    override fun doGetGlobalPosition(callBack : CustomCallBack<GlobalPosition?>?) {
        api.getGlobalPosition(tokenCredential).enqueue(CustomCallBack<GlobalPosition?>(action = {
            if(it != null && it.isSuccessful) globalPosition = it.body()
            callBack?.action?.invoke(it)
        }))
    }



}