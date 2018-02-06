package com.gc.demoapp.repository

import com.gc.demoapp.repository.model.*
import retrofit2.Response

/**
 * Created by 674756 on 05/02/2018.
 */
interface IRepository {

    fun doLogin(reuest : RequestLogin ) : Response<ResponseLogin>

}