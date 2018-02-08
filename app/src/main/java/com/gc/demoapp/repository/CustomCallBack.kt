package com.gc.demoapp.repository

import okhttp3.ResponseBody
import retrofit2.*

/**
 * Created by 674756 on 06/02/2018.
 */
class CustomCallBack<T>(var action : (Response<T>?) -> Unit ) : Callback<T> {

    override fun onFailure(call : Call<T>?,
                           t : Throwable?
    ) = action(Response.error(0, ResponseBody.create(null, t?.message)))

    override fun onResponse(call : Call<T>?,
                            response : Response<T>?
    ) = action(response!!)
}