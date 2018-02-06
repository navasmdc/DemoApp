package com.gc.demoapp.repository.remote

import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.*
import retrofit2.Response

/**
 * Created by 674756 on 05/02/2018.
 */
open class Repository(var api : Api) : IRepository {

    lateinit var tokenCredential : String

    override fun doLogin(reuest : RequestLogin) : Response<ResponseLogin>{
        var response = api.doLogin(reuest).execute()
        if(response.isSuccessful) tokenCredential = response.body()?.tokenCredential!!
        return response
    }

}