package com.gc.demoapp.repository.mock

import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.model.GlobalPosition
import com.gc.demoapp.repository.model.RequestLogin
import com.gc.demoapp.repository.model.ResponseLogin
import com.gc.demoapp.repository.remote.Repository

/**
 * Created by 674756 on 05/02/2018.
 */
class MockRepository(api : Api, var mockInterceptor : MockInterceptor) : Repository(api) {

    override fun doLogin(reuest: RequestLogin, callback: CustomCallBack<ResponseLogin>) {
        MockInterceptor.addResponse("login.json")
        super.doLogin(reuest, callback)
    }

    override fun doGetGlobalPosition(callBack: CustomCallBack<GlobalPosition>) {
        MockInterceptor.addResponse("global_position.json")
        super.doGetGlobalPosition(callBack)
    }
}