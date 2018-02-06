package com.gc.demoapp.repository.remote

import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.*
import retrofit2.*

/**
 * Created by 674756 on 05/02/2018.
 */
open class Repository(var api : Api) : IRepository {

    lateinit var tokenCredential : String

    override fun doLogin(reuest : RequestLogin, callback : CustomCallBack<ResponseLogin>) {
        api.doLogin(reuest).enqueue(CustomCallBack<ResponseLogin>(action = {
            if(it.isSuccessful) tokenCredential = it.body()?.tokenCredential!!
            callback.action(it)
        }))
    }



}