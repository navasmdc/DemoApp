package com.gc.demoapp.repository

import com.gc.demoapp.repository.model.*
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("/login")
    fun doLogin(@Body requestLogin : RequestLogin) : Call<ResponseLogin>

    @GET("/globalposition")
    fun getGlobalPosition(@Header("tokenCredential") tokenCredential: String): Call<GlobalPosition>

}