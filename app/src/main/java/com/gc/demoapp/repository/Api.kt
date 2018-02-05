package com.gc.demoapp.repository

import retrofit2.http.POST

/**
 * Created by 674756 on 05/02/2018.
 */
interface Api {

    @POST("/login")
    fun doLogin()

//    @GET("/v1/login")
//    fun doLogin(@Header("Authorization") basic: String): Observable<Login>
//
//    @GET("/v1/forgetpin/{email}/")
//    fun recoverPin(@Path("email") email: String): Observable<ForgetPin>
//
//    @GET("/v1/process")
//    fun getProcess(@Header("Authorization") basic: String): Observable<Response<ProcessCandidate>>
//
//    @PUT("/v1/feedback/{feedbackId}")
//    fun sendFeedback(@Header("Authorization") basic: String,
//                     @Path("feedbackId") feedbackId: String,
//                     @Body feedback: Feedback): Observable<FeedbackResult>
//
//    @GET("/v1/aboutus/")
//    fun getCopyright(@Header("Accept-Language") language: String): Observable<Copyright>
//
//    @GET("/v1/poi/{locationId}")
//    fun getPOIs(@Header("Authorization") basic: String,
//                @Path("locationId") locationId: String) : Observable<List<Poi>>
//
//    @GET("/v1/video")
//    fun getVideo(): Observable<Video>
//
//    @GET("/v1/value")
//    fun getValues(@Header("Authorization") basic: String): Observable<List<Values>>

}